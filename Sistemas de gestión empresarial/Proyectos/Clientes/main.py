from Clases import *
import os

# Functions

if __name__ == '__main__':
    fm = FileManager()
    fm.create_file("c")
    fm.create_file("v")
    menu = Menu(fm)
    menu.start()