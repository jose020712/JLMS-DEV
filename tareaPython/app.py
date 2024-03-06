from modulos.estudiante import Estudiante
from modulos.curso import Curso


estudiante1 = Estudiante("Ana", 18, "Matemáticas", [3, 3, 4, 5], 10, 50)
estudiante2 = Estudiante("Luis", 19, "Matemáticas", [2, 5, 3, 2], 45, 50)
estudiante3 = Estudiante("Pedro", 20, "Matemáticas", [2, 2, 2, 2], 30, 50)
estudiante4 = Estudiante("María", 18, "Física", [3, 4, 2, 5], 50, 50)
estudiante5 = Estudiante("Carlos", 19, "Física", [5, 4, 3, 2], 20, 50)
estudiante6 = Estudiante("Sofía", 20, "Física", [2, 5, 2, 2], 1, 50)


curso1 = Curso("Matemáticas", [estudiante1, estudiante2, estudiante3])
curso2 = Curso("Física", [estudiante4, estudiante5, estudiante6])

curso1.evaluar_estudiantes()
curso2.evaluar_estudiantes()


# se puede implementar para q el usuario vaya introduciendo los datos pero bueno es simplemente un esbozo
