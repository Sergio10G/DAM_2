from menu import Menu
from filemanager import FileManager

# Este es el archivo ejecutable, el resto son clases.
if __name__ == '__main__':
	fm = FileManager()
	menu = Menu(fm)
	menu.start()