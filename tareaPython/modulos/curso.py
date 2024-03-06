class Curso:

    def __init__(self, nombre, estudiantes):
        self.nombre = nombre
        self.estudiantes = estudiantes
# Método para evaluar a los estudiantes del curso

    def evaluar_estudiantes(self):
        
        for estudiante in self.estudiantes:
            print("//////////")
            promedio = estudiante.calcular_promedio()
            asistencia = estudiante.asistencia
            nota_minima = 3
            asistencia_minima = 20
            if promedio >= nota_minima and asistencia >= asistencia_minima:
                print(f"{estudiante.nombre} ha aprobado el curso {self.nombre}")
            else:
                print(f"{estudiante.nombre} no ha aprobado el curso {self.nombre}")
                if promedio < nota_minima:
                 print(f"Debe mejorar su rendimiento académico. Su promedio es {promedio} pts y debe ser al menos {nota_minima}pts.")
                if asistencia < asistencia_minima:
                 print(f"Debe mejorar su asistencia. Su asistencia es {asistencia}% y debe ser al menos {asistencia_minima}%")
            