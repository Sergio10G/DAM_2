class Empleado:
	def __init__(self, id_emp: int, nombre: str, apellido: str, horas: float, salario_base: float) -> None:
		self.id_emp = id_emp
		self.nombre = nombre
		self.apellido = apellido
		self.horas = horas
		self.salario_base = salario_base
		self.salario_final = 0.0
	
	def __str__(self) -> str:
		return "[" + str(self.id_emp) + "] " + self.nombre + " " + self.apellido + ", " + str(self.horas) + ", " + \
			str(self.salario_base) + "€, " + str(self.salario_final) + "€"
	
	def toCSV(self) -> str:
		return str(self.id_emp) + ";" + self.nombre + ";" + self.apellido + ";" + str(self.horas) + ";" + \
			str(self.salario_base) + ";" + str(self.salario_final)