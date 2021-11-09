import os


class FileManager:
    def __init__(self):
        self.clientes = "csv/clientes.csv"
        self.ventas = "csv/ventas.csv"
        self.custom_file = ""

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

    def append_to_file(self, f, data):
        if f == "c":
            f_name = self.clientes
        elif f == "v":
            f_name = self.ventas
        else:
            return 0
        file = open(f_name, "a")
        file.write(data)
        file.close()
        return 1


class Menu:
    def __init__(self, fm: FileManager):
        self.fm = fm
        self.opciones = {
            "main": ["Agregar cliente", "Realizar venta", "Cargar clientes", "Cargar ventas", "Cargar archivo externo"\
                , "Listar clientes"],
            "listar_clientes": ["Todos", "Nuevos", "Calificados", "Propuestos", "Ganados"]
        }
        self.nivel_actual = "main"
        self.clientes = []
        self.compras = []

    def pintar_cabecera(self):
        # 33 caracteres entre los |
        print("╔═════════════════════════════════╗")
        print("║       Gestión de clientes       ║")
        print("╠═════════════════════════════════╣")

    def pintar_separador(self):
        print("╚═════════════════════════════════╝")
    
    def pintar_linea_vacia(self):
        print("║                                 ║")

    def clear(self):
        os.system("cls || clear")

    def confirm_msg(self, msg):
        print(msg)
        input("Presiona intro para continuar.")

    def embeber_opcion(self, op, texto):
        prep = "║ " + str(op) + ". " + texto
        while len(prep) <= 33:
            prep += " "
        prep += "║"
        print(prep)

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
    
    def compra_from_csv(self, str):
        # 17/10/2021;1024.0;[razor]
        no_new_line = str[0:len(str) - 1]
        fields = no_new_line.split(";")
        fecha = fields[0]
        total = float(fields[1])
        productos = fields[2][1:len(fields[2])].split(",")
        compra = Compra(fecha, total, productos)
        return compra

    def crear_cliente(self):
        nombre = input("Introduce el nombre completo: ")
        tlf = input("Introduce el número de teléfono: ")
        email = input("Introduce el email: ")
        # cat = input("Introduce la categoría: ")
        compras = []
        t = 1
        print("A continuación se introducirán las compras del cliente.")
        sel1 = input("¿Quieres introducir compras al cliente? s/n: ")
        if sel1 == "s":
            while True:
                print("[Compra nº " + str(t) + "]")
                comp = self.crear_compra()
                compras.append(comp)
                sel = input("Compra nº " + str(t) + " introducida. ¿Quieres introducir otra compra? s/n: ")
                if sel != "s":
                    break
                t += 1
        return Cliente(nombre, tlf, email, "", compras)
    
    def cliente_from_csv(self, str):
        # Sergio;654789123;sergio@gmail.com;Calificado;[[17/10/2021, 1024.01, [razor, blade]]]
        no_new_line = str[0:len(str) - 1]
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
            
        return Cliente(nombre, tlf, email, cat, compras)

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

    def print_client_by_cat(self, cat):
        for cliente in self.clientes:
            if (cliente.cat == cat):
                print(cliente.toString())

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
                    cliente = self.cliente_from_csv(csv_field)
                    clientes.append(cliente)
                self.clientes = clientes
                print("Clientes cargados:\n")
                print(file_content.get("header").replace(";", ", ").replace("\n", ""))
                for cliente in self.clientes:
                    print(cliente.toString())
                self.confirm_msg("")
            elif selec == 4:
                # Cargar compras
                self.fm.create_file("v")
                compras = []
                file_content = self.fm.read_file("v")
                for csv_field in file_content.get("data"):
                    csv_field = csv_field.split("\n")[0]
                    compras.append(self.compra_from_csv(csv_field))
                self.compras = compras
                print("Compras cargadas:\n")
                print(file_content.get("header").replace(";", ", ").replace("\n", ""))
                for com in compras:
                    print(com.toString())
                self.confirm_msg("")
            elif selec == 5:
                #Cargar archivo externo
                self.confirm_msg("Cargar archivo externo")
            elif selec == 6:
                # Listar clientes
                self.nivel_actual = "listar_clientes"
        elif self.nivel_actual == "listar_clientes":
            if selec == 1:
                # Listar todos
                print("Listar todos")
                for cliente in self.clientes:
                    print(cliente.toString())
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
                print("ERROR: La opción introducida es incorrecta.")
                continue
            else:
                self.select_menu_option(int(selec))


class Compra:
    def __init__(self, fecha: str, total: float, productos: list[str]):
        self.fecha = fecha
        self.total = total
        self.productos = productos

    def getTotal(self):
        return self.total

    def desplegar_lista(self):
            ls = "["
            ls += ",".join(self.productos).strip()
            return ls + "]";

    def toString(self):
        return "[" + self.fecha + ", " + str(self.total) + ", " + self.desplegar_lista() + "]"

    def toCSV(self):
        return self.fecha + ";" + str(self.total) + ";" + self.desplegar_lista() + "\n"

    def realizar_venta(self, fm : FileManager):
        fm.append_to_file("v", self.toCSV())


class Cliente:
    def __init__(self, nombre, tlf, email, cat, compras: list[Compra]):
        self.nombre = nombre
        self.tlf = tlf
        self.email = email
        self.cat = cat
        self.compras = compras
        self.categorizar()

    def desplegar_lista(self):
        comps = []
        ls = "["
        for compra in self.compras:
            comps.append(compra.toString())
        ls += ','.join(comps)
        ls += "]"
        return ls

    def categorizar(self):
        if len(self.compras) == 0:
            self.cat = "Nuevo"
        elif len(self.compras) == 1:
            self.cat = "Calificado"
        elif len(self.compras) > 1:
            self.cat = "Propuesta"
            for compra in self.compras:
                if compra.getTotal() > 1000:
                    self.cat = "Ganado"
                    break
            

    def toString(self):
        return "[" + self.nombre + ", " + self.tlf + ", " + self.email + ", " + self.cat + ", " \
            + self.desplegar_lista() + "]"

    def toCSV(self):
        return self.nombre + ";" + self.tlf + ";" + self.email + ";" + self.cat + ";" + self.desplegar_lista() + "\n"

    def agregar_cliente(self, fm: FileManager):
        fm.append_to_file("c", self.toCSV())
