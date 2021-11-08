import os


class FileManager:
    def __init__(self):
        self.clientes = "csv/clientes.csv"
        self.ventas = "csv/ventas.csv"

    def create_file(self, f):
        if f == "c":
            f_name = self.clientes
        elif f == "v":
            f_name = self.ventas
        else:
            return 0
        if not os.path.isfile(f_name):
            file = open(f_name, "w")
        else:
            return
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
            "main": ["agregar cliente", "realizar venta", "cargar clientes", "cargar ventas", "listar clientes"],
            "listar_clientes": ["todos", "nuevos", "calificados", "propuestos", "ganados"]
        }
        self.nivel_actual = "main"
        self.activo = True
        self.clientes = []
        self.compras = []

    def pintar_cabecera(self):
        # 33 caracteres entre los |
        print("+---------------------------------+")
        print("|       Gestión de clientes       |")
        print("+---------------------------------+")

    def pintar_separador(self):
        print("+---------------------------------+")
    
    def pintar_linea_vacia(self):
        print("|                                 |")

    def clear(self):
        os.system("cls")

    def confirm_msg(self, msg):
        print(msg)
        input("Presiona cualquier tecla para continuar.")

    def embeber_opcion(self, op, texto):
        prep = "| " + str(op) + ". " + texto
        while len(prep) <= 33:
            prep += " "
        prep += "|"
        print(prep)

    def crear_compra(self):
        print("Va a crear una nueva compra")
        fecha = input("Introduce la fecha: ")
        total = float(input("Introduce el total: "))
        productos = []
        t = 1
        while True:
            pr = input("Introduce el producto nº " + str(t) + ": ")
            productos.append(pr)
            sel = input("Producto nº " + str(t) + " introducido. Quieres introducir otro producto? s/n: ")
            if sel != "s":
                break
            t += 1
        return Compra(fecha, total, productos)


    def crear_cliente(self):
        print("Va a crear un nuevo cliente")
        nombre = input("Introduce el nombre completo: ")
        tlf = input("Introduce el número de teléfono: ")
        email = input("Introduce el email: ")
        cat = input("Introduce la categoría: ")
        compras = []
        t = 1
        while True:
            print("Introduce la compra nº " + str(t))
            comp = self.crear_compra()
            compras.append(comp)
            sel = input("Compra nº " + str(t) + " introducida. Quieres introducir otra compra? s/n")
            if sel != "s":
                break
            t += 1
        return Cliente(nombre, tlf, email, cat, compras)

    def option_check(self, selec):
        sel = int(selec)
        if sel == 0:
            return 0
        if self.nivel_actual == "main":
            if sel >= 1 and sel <= 5:
                return 1
        elif self.nivel_actual == "listar_clientes":
            if sel >= 1 and sel <= 5:
                return 1
        return -1

    def select_option(self, selec):
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
                clientes = []
                file_content = self.fm.read_file("c")
                for line in file_content.get("data"):
                    line = line.split("\n")[0]
                    parts = line.split(";")
                    clientes.append(Cliente(parts[0], parts[1], parts[2], parts[3], parts[4]))
                print("Clientes cargados:")
                for cli in clientes:
                    print(cli)
                self.confirm_msg("")
            elif selec == 4:
                # Cargar compras
                compras = []
                file_content = self.fm.read_file("v")
                for line in file_content.get("data"):
                    line = line.split("\n")[0]
                    parts = line.split(";")
                    compras.append(Compra(parts[0], parts[1], parts[2]))
                print("Compras cargadas:")
                for com in compras:
                    print(com)
                self.confirm_msg("")
            elif selec == 5:
                # Listar clientes
                self.nivel_actual = "listar_clientes"
        elif self.nivel_actual == "listar_clientes":
            if selec == 1:
                # Listar todos
                self.confirm_msg("Listar todos")
            elif selec == 2:
                # Listar nuevos
                self.confirm_msg("Listar nuevos")
            elif selec == 3:
                # Listar calificados
                self.confirm_msg("Listar calificados")
            elif selec == 4:
                # Listar propuestas
                self.confirm_msg("Listar propuestas")
            elif selec == 5:
                # Listar ganados
                self.confirm_msg("Listar ganados")


    def start(self):
        while self.activo:
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
            self.clear()
            if res == 0:
                if self.nivel_actual == "main":
                    self.activo = False
                    break
                else:
                    self.nivel_actual = "main"
            elif res == -1:
                print("ERROR: La opción introducida es incorrecta.")
                continue
            else:
                self.select_option(int(selec))



class Cliente:
    def __init__(self, nombre, tlf, email, cat, compras):
        self.nombre = nombre
        self.tlf = tlf
        self.email = email
        self.cat = cat
        self.compras = compras

    def desplegar_lista(self):
        ls = "["
        x = 0
        for compra in self.compras:
            ls += compra.__str__()
            x += 1
            if x < len(self.compras):
                ls += ","
        ls += "]"
        return ls

    def __str__(self):
        return self.nombre + ", " + self.tlf + ", " + self.email + ", " + self.cat + ", " + self.desplegar_lista()

    def toCSV(self):
        return self.nombre + ";" + self.tlf + ";" + self.email + ";" + self.cat + ";" + self.desplegar_lista() + "\n"

    def agregar_cliente(self, fm: FileManager):
        fm.append_to_file("c", self.toCSV())


class Compra:
    def __init__(self, fecha, total, productos):
        self.fecha = fecha
        self.total = total
        self.productos = productos

    def desplegar_lista(self):
            ls = "["
            x = 0
            for prod in self.productos:
                ls += prod
                x += 1
                if x < len(self.productos):
                    ls += ","
            ls += "]"
            return ls

    def __str__(self):
        return "[" + self.fecha + ", " + str(self.total) + ", " + self.desplegar_lista() + "]"

    def toCSV(self):
        return self.fecha + ";" + str(self.total) + ";" + self.desplegar_lista() + "\n"

    def realizar_venta(self, fm : FileManager):
        fm.append_to_file("v", self.toCSV())
