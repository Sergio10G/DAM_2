import os

# La clase FileManager se encargará de gestionar todo el acceso a los archivos csv.
class FileManager:
    def __init__(self):
        self.file = "empleados.csv"

    # Crea un archivo csv con su cabecera para los empleados.
    def create_file(self):
        if not os.path.isfile(self.file):
            file = open(self.file, "w")
        else:
            return 0
        file.write("id_emp;nombre;apellido;horas;salario_base;salario_final\n")
        file.close()
        return 1

    # Añade una entrada a un archivo csv
    def append_to_file(self, data):
        file = open(self.file, "a")
        file.write(data + "\n")
        file.close()
        return 1

