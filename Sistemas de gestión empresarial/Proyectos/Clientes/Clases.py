import os

# La clase FileManager se encargará de gestionar todo el acceso a los archivos csv.
class FileManager:
    def __init__(self):
        self.clientes = "csv/clientes.csv"
        self.ventas = "csv/ventas.csv"
        self.custom_file = ""

    # Crea un archivo csv con su cabecera para clientes o compras. Si se le especifica un path, lo crea allí.
    def create_file(self, f, path=""):
        if f == "c":
            f_name = self.clientes
        elif f == "v":
            f_name = self.ventas
        else:
            return 0
        
        if (path != ""):
            f_name = path
            self.custom_file = path

        if not os.path.isfile(f_name):
            file = open(f_name, "w")
        else:
            return 0
        
        if f == "c":
            file.write("nombre;tlf;email;cat;compras\n")
        elif f == "v":
            file.write("fecha;total;productos\n")
        file.close()
        return 1

    # Lee el archivo de clientes o el de compras, y devuelve sus datos
    def read_file(self, f):
        if f == "c":
            f_name = self.clientes
        elif f == "v":
            f_name = self.ventas
        else:
            return 0
        file = open(f_name, "r")
        header = file.readline()
        data = []
        line = file.readline()
        while line != "":
            data.append(line)
            line = file.readline()
        file.close()
        return {"header": header, "data": data}

    # Añade una entrada a un archivo csv, que puede ser el de clientes, el de compras u otro fichero especificado
    # por el usuario al exportar datos.
    def append_to_file(self, f, data):
        if f == "c":
            f_name = self.clientes
        elif f == "v":
            f_name = self.ventas
        elif f == "x":
            f_name = self.custom_file
        else:
            return 0
        file = open(f_name, "a")
        file.write(data)
        file.close()
        return 1

# La clase menú es la clase principal de la aplicación. Incluye el menú en si, las funciones del menú y el bucle 
# principal del programa.
class Menu:
    def __init__(self, fm: FileManager):
        self.fm = fm
        self.opciones = {
            "main": ["Agregar cliente", "Realizar venta", "Cargar clientes", "Cargar compras",\
                "Exportar a archivo externo", "Listar clientes"],
            "listar_clientes": ["Todos", "Nuevos", "Calificados", "Propuestos", "Ganados"]
        }
        self.nivel_actual = "main"
        self.clientes = []
        self.compras = []

    def pintar_cabecera(self):
        # 33 caracteres entre los ║
        print("╔═════════════════════════════════╗")
        print("║       Gestión de clientes       ║")
        print("╠═════════════════════════════════╣")

    def pintar_separador(self):
        print("╚═════════════════════════════════╝")
    
    def pintar_linea_vacia(self):
        print("║                                 ║")

    # Clear limpia la terminal
    def clear(self):
        os.system("cls || clear")

    # Confirm msg ofrece un mensaje al usuario en el que tiene que pulsar intro para continuar.
    def confirm_msg(self, msg):
        print(msg + "\n")
        input("Presiona intro para continuar.")

    # Esta función añade los límites del menú a los dos lados de cada opción, para que se integren perfectamente con
    # el resto del menú
    def embeber_opcion(self, op, texto):
        prep = "║ " + str(op) + ". " + texto
        prep += " " * (34 - len(prep))
        prep += "║"
        print(prep)

    # Esta función pedirá los datos al usuario para crear una nueva compra
    def crear_compra(self):
        fecha = input("Introduce la fecha: ")
        while True:
            try:
                total = float(input("Introduce el total: "))
                break
            except:
                print("ERROR: El total debe ser un número.")
        productos = []
        t = 1
        print("A continuación se introducirán los productos comprados.")
        while True:
            pr = input("Introduce el producto nº " + str(t) + ": ")
            productos.append(pr)
            sel = input("Producto nº " + str(t) + " introducido. Quieres introducir otro producto? s/n: ")
            if sel != "s":
                break
            t += 1
        return Compra(fecha, total, productos)

    # Esta función pedirá los datos al usuario para crear un nuevo cliente
    def crear_cliente(self):
        nombre = input("Introduce el nombre completo: ")
        tlf = input("Introduce el número de teléfono: ")
        email = input("Introduce el email: ")
        # cat = input("Introduce la categoría: ")
        compras = []
        t = 1
        print("A continuación se introducirán las compras del cliente.")
        sel1 = input("¿Quieres introducir compras al cliente? s/n: ")
        if sel1.lower() == "s":
            while True:
                print("[Compra nº " + str(t) + "]")
                comp = self.crear_compra()
                compras.append(comp)
                sel = input("Compra nº " + str(t) + " introducida. ¿Quieres introducir otra compra? s/n: ")
                if sel != "s":
                    break
                t += 1
        return Cliente(nombre, tlf, email, "", compras)

    # Esta función asegurará que el usuario ha introducido una opción del menú válida. Si no lo ha hecho, devolverá
    # un código de error y el menú no hará nada.
    def option_check(self, selec):
        try:
            sel = int(selec)
        except:
            return -1
        if sel == 0:
            return 0
        if self.nivel_actual == "main":
            if sel >= 1 and sel <= len(self.opciones.get("main")):
                return 1
        elif self.nivel_actual == "listar_clientes":
            if sel >= 1 and sel <= len(self.opciones.get("listar_clientes")):
                return 1
        return -1

    # Función para listar clientes. Le dices la categoría, y te pinta todos los clientes que pertenecen a ella.
    def print_client_by_cat(self, cat):
        for cliente in self.clientes:
            if (cliente.cat == cat):
                print(cliente.__str__())

    # Las entrañas del menú en sí. Esta función contiene todas las acciones a llevar a cabo cuando el usuario selecciona
    # una opción del menú.
    def select_menu_option(self, selec):
        self.clear()
        if selec == 0:
            return 0
        if self.nivel_actual == "main":
            if selec == 1:
                # Agregar cliente
                cli = self.crear_cliente()
                cod = self.fm.append_to_file("c", cli.toCSV())
                if cod == 1:
                    self.confirm_msg("Cliente introducido con éxito.")
                else:
                    self.confirm_msg("Ha ocurrido algún error al introducir el cliente.")
            elif selec == 2:
                # Realizar compra
                ven = self.crear_compra()
                cod = self.fm.append_to_file("v", ven.toCSV())
                if cod == 1:
                    self.confirm_msg("Compra realizada con éxito.")
                else:
                    self.confirm_msg("Ha ocurrido algún error al realizar la compra.")
            elif selec == 3:
                # Cargar clientes
                self.fm.create_file("c")
                clientes = []
                file_content = self.fm.read_file("c")
                for csv_field in file_content.get("data"):
                    cliente = Cliente.fromCSV(csv_field)
                    clientes.append(cliente)
                self.clientes = clientes
                print("Clientes cargados:\n")
                print(file_content.get("header").replace(";", ", ").replace("\n", ""))
                for cliente in self.clientes:
                    print(cliente)
                self.confirm_msg("")
            elif selec == 4:
                # Cargar compras
                self.fm.create_file("v")
                compras = []
                file_content = self.fm.read_file("v")
                for csv_field in file_content.get("data"):
                    csv_field = csv_field.split("\n")[0]
                    compras.append(Compra.fromCSV(csv_field))
                self.compras = compras
                print("Compras cargadas:\n")
                print(file_content.get("header").replace(";", ", ").replace("\n", ""))
                for com in compras:
                    print(com)
                self.confirm_msg("")
            elif selec == 5:
                # Exportar a archivo externo
                print("Exportar a archivo externo")
                sel = ""
                while sel != "c" and sel != "v":
                    sel = input("¿Quieres exportar ventas o clientes? (v/c): ")
                    if (sel != "c" and sel != "v"):
                        print("Error. Por favor, introduzca c para clientes o v para ventas.")
                nombre = input("Introduce el nombre para el archivo de exportado: ")
                self.fm.create_file(sel, "./csv/" + nombre + ".csv")
                if (sel.lower() == "c"):
                    lista = self.clientes
                elif (sel.lower() == "v"):
                    lista = self.compras
                for elem in lista:
                    self.fm.append_to_file("x", elem.toCSV())
                self.confirm_msg("Elementos exportados con éxito.")
            elif selec == 6:
                # Listar clientes
                self.nivel_actual = "listar_clientes"
        elif self.nivel_actual == "listar_clientes":
            if selec == 1:
                # Listar todos
                print("Listar todos")
                for cliente in self.clientes:
                    print(cliente.__str__())
                self.confirm_msg("")
            elif selec == 2:
                # Listar nuevos
                print("Clientes nuevos:")
                self.print_client_by_cat("Nuevo")
                self.confirm_msg("")
            elif selec == 3:
                # Listar calificados
                print("Clientes calificados:")
                self.print_client_by_cat("Calificado")
                self.confirm_msg("")
            elif selec == 4:
                # Listar propuestas
                print("Clientes propuestos:")
                self.print_client_by_cat("Propuesta")
                self.confirm_msg("")
            elif selec == 5:
                # Listar ganados
                print("Clientes ganados:")
                self.print_client_by_cat("Ganado")
                self.confirm_msg("")

    # Bucle principal del menú. Será el que mantenga en ejecución el programa.
    def start(self):
        while True:
            self.clear()
            self.pintar_cabecera()
            op = 1
            for opcion in self.opciones.get(self.nivel_actual):
                self.embeber_opcion(op, opcion)
                op += 1
            self.pintar_linea_vacia()
            self.embeber_opcion(0, "Salir")
            self.pintar_separador()
            selec = input("Introduce una opción: ")
            res = self.option_check(selec)
            if res == 0:
                if self.nivel_actual == "main":
                    break
                else:
                    self.nivel_actual = "main"
            elif res == -1:
                continue
            else:
                self.select_menu_option(int(selec))

# La clase Compra representa una Compra, e incluye todos sus métodos.
class Compra:
    def __init__(self, fecha: str, total: float, productos: list[str]):
        self.fecha = fecha
        self.total = total
        self.productos = productos
    
    # Crea un objeto Compra desde una entrada csv.
    @classmethod
    def fromCSV(cls, csv):
        # 17/10/2021;1024.0;[razor]
        no_new_line = csv[0:len(csv) - 1]
        fields = no_new_line.split(";")
        fecha = fields[0]
        total = float(fields[1])
        productos = fields[2][1:len(fields[2])].split(",")
        return cls(fecha, total, productos)

    # Prepara la lista como string para que pueda ser pintada
    def desplegar_lista(self):
            ls = "["
            ls += ",".join(self.productos).strip()
            return ls + "]";

    # Convierte el objeto a un string para poder pintarlo
    def __str__(self):
        return "[" + self.fecha + ", " + str(self.total) + ", " + self.desplegar_lista() + "]"

    # Convierte el objeto a una entrada csv
    def toCSV(self):
        return self.fecha + ";" + str(self.total) + ";" + self.desplegar_lista() + "\n"

# La clase Cliente representa un Cliente, e incluye todos sus métodos.
class Cliente:
    def __init__(self, nombre, tlf, email, cat, compras: list[Compra]):
        self.nombre = nombre
        self.tlf = tlf
        self.email = email
        self.cat = cat
        self.compras = compras
        self._categorizar()
    
    # Crea un objeto Cliente desde una entrada csv.
    @classmethod
    def fromCSV(cls, csv):
        # Sergio;654789123;sergio@gmail.com;Calificado;[[17/10/2021, 1024.01, [razor, blade]]]
        no_new_line = csv[0:len(csv) - 1]
        fields = no_new_line.split(";")
        nombre = fields[0]
        tlf = fields[1]
        email = fields[2]
        cat = fields[3]
        compras = []
        if (fields[4] != "[]"):
            compras_csv = fields[4][2:len(fields[4]) - 2].split("],[")
            for c_csv in compras_csv:
                parts = c_csv.replace("[", "")
                parts = parts.replace("]", "")
                parts = parts.split(",")
                c_fecha = parts[0]
                c_total = float(parts[1])
                c_pedidos = []
                for x in range(2, len(parts)):
                    c_pedidos.append(parts[x])
                compras.append(Compra(c_fecha, c_total, c_pedidos))
            
        return cls(nombre, tlf, email, cat, compras)

    # Prepara la lista como string para que pueda ser pintada
    def desplegar_lista(self):
        comps = []
        ls = "["
        for compra in self.compras:
            comps.append(compra.__str__())
        ls += ','.join(comps)
        ls += "]"
        return ls

    # Función privada que asigna una categoría al cliente tras crear el objeto.
    def _categorizar(self):
        if len(self.compras) == 0:
            self.cat = "Nuevo"
        elif len(self.compras) == 1:
            self.cat = "Calificado"
        elif len(self.compras) > 1:
            self.cat = "Propuesta"
            for compra in self.compras:
                if compra.total > 1000:
                    self.cat = "Ganado"
                    break

    # Convierte el objeto a un string para poder pintarlo
    def __str__(self):
        return "[" + self.nombre + ", " + self.tlf + ", " + self.email + ", " + self.cat + ", " \
            + self.desplegar_lista() + "]"

    # Convierte el objeto a una entrada csv
    def toCSV(self):
        return self.nombre + ";" + self.tlf + ";" + self.email + ";" + self.cat + ";" + self.desplegar_lista() + "\n"
