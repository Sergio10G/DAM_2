import os
from filemanager import FileManager
from empleado import Empleado

# La clase menú es la clase principal de la aplicación. Incluye el menú en si, las funciones del menú y el bucle 
# principal del programa.
class Menu:
    def __init__(self, fm: FileManager):
        self.fm = fm
        self.opciones = {
            "main": ["Agregar empleado", "Mostrar empleados", "Balance de gastos", "Exportar a csv"]
        }
        self.nivel_actual = "main"
        self.empleados: list[Empleado] = []

    def pintar_cabecera(self):
        # 33 caracteres entre los ║
        print("╔═════════════════════════════════╗")
        print("║       Gestión de empleados      ║")
        print("╠═════════════════════════════════╣")

    def pintar_separador(self):
        print("╚═════════════════════════════════╝")
    
    def pintar_linea_vacia(self):
        print("║                                 ║")

    # Clear limpia la terminal
    def clear(self):
        os.system("cls || clear")

    # Confirm msg ofrece un mensaje al usuario en el que tiene que pulsar intro para continuar.
    def confirm_msg(self, msg = ""):
        print(msg)
        input("Presiona intro para continuar.")

    # Esta función añade los límites del menú a los dos lados de cada opción, para que se integren perfectamente con
    # el resto del menú
    def embeber_opcion(self, op, texto):
        prep = "║ " + str(op) + ". " + texto
        prep += " " * (34 - len(prep))
        prep += "║"
        print(prep)

    # Esta función pedirá los datos al usuario para crear un nuevo empleado
    def crear_empleado(self):
        pass

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
        return -1
    
    def get_last_id(self):
        if (len(self.empleados) == 0):
            return 1
        else:
            lastid = 0
            for empleado in self.empleados:
                if empleado.id_emp > lastid:
                    lastid = empleado.id_emp
            return lastid + 1
    
    def update_salaries(self):
        if len(self.empleados) == 0:
            return 0
        total = 0
        for emp in self.empleados:
            total += emp.salario_base
        media = total / len(self.empleados)
        for emp in self.empleados:
            if emp.salario_base < media and emp.horas > 120:
                emp.salario_final = emp.salario_base * 1.1
            else:
                emp.salario_final = emp.salario_base


    # Las entrañas del menú en sí. Esta función contiene todas las acciones a llevar a cabo cuando el usuario selecciona
    # una opción del menú.
    def select_menu_option(self, selec):
        self.clear()
        if selec == 0:
            return 0
        if self.nivel_actual == "main":
            if selec == 1:
                # Agregar empleado
                id_emp = self.get_last_id()
                nombre = input("Introduce un nombre: ")
                apellido = input("Introduce los apellidos: ")
                while True:
                    try:
                        horas = input("Introduce las horas trabajadas: ")
                        horas = float(horas)
                        break
                    except:
                        print("ERROR: Introduce un número válido.")
                while True:
                    try:
                        salario_base = input("Introduce el salario base: ")
                        salario_base = float(salario_base)
                        break
                    except:
                        print("ERROR: Introduce un número válido.")
                emp = Empleado(id_emp, nombre, apellido, horas, salario_base)
                self.empleados.append(emp)
                self.update_salaries()
                self.confirm_msg("Empleado introducido con éxito!")
            elif selec == 2:
                # Mostrar empleados
                print("Listado de empleados:\n")
                if (len(self.empleados) != 0):
                    print("id - nombre y apellidos - horas trabajadas - salario base - salario final")
                for emp in self.empleados:
                    print(emp)
                self.confirm_msg("")

            elif selec == 3:
                # Balance de gastos
                total = 0
                for emp in self.empleados:
                    total += emp.salario_final
                print("Balance de gastos de la empresa:\n")
                print(str(total) + "€")
                self.confirm_msg("")
            elif selec == 4:
                # Exportar a csv
                self.fm.create_file()
                for emp in self.empleados:
                    self.fm.append_to_file(emp.toCSV())
                self.confirm_msg("Datos exportados con éxito!")


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