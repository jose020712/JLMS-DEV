
class Estudiante:
    
    def __init__(self, nombre, edad, curso, notas,asistido,totalHC):
        self.nombre = nombre
        self.edad = edad
        self.curso = curso
        self.notas = notas 
        self.asistencia = (asistido*100)/totalHC
    
        
        

    #Método para calcular el promedio de las notas del estudiante
    def calcular_promedio(self):
        suma = sum(self.notas)
        cantidad = len(self.notas)
        promedio = suma / cantidad
        return promedio

    #Método para mostrar la información del estudiante
    def mostrar_informacion(self):
        print(f"Nombre: {self.nombre}")
        print(f"Edad: {self.edad}")
        print(f"Curso: {self.curso}")
        print(f"Notas: {self.notas}")
        print(f"Asistencia: {self.asistencia}%")
        print(f"Promedio: {self.calcular_promedio()}")    
