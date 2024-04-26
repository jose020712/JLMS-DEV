---Errores---

1. Falta de documentacion en el Proyecto (Archivo->Readme.md).



.................................................................
2. Implementacion de métodos (constructor) q no se usan:

2.1  Cisterna(float max_cis, float min_cis){
            this->max_cis = max_cis;
            this->min_cis = min_cis;
        }

2.2  Tanque(float max_tan, float min_tan){
            this->max_tan = max_tan;
            this->min_tan = min_tan;
        }
2.3 Bomba(bool encender, bool apagar){
            this->encender = encender;
            this->apagar = apagar;
        }


.................................................................


3. Utilizar comentarios descriptivos:
Ejemplo:
// Clase que representa una cisterna de agua
class Cisterna {
    // ...
};

En vista de futuros mantenimientos.


.................................................................

4.Utilizar nombres significativos:

float MAX_CISTERNA = 2.0;
float MIN_CISTERNA = 0.0003;
float MID_CISTERNA = 1.30;

Mejor compresión del código.

.................................................................

5.Simplificar la lógica de los métodos, ahorro de memoria y optimizacion:

 float cisternaVacia(float cis){
            if(cis <= 0.0003){
            	cout<<"Su cisterna esta vacia"<<endl;
                return 0;
            }
            else if(cis > 0.0003 && cis < 1.30){
            		cout<<"Su cisterna esta en la media"<<endl;
                return 1;
            }
            else if(cis >= 1.30 && cis <= 2.0){
            		cout<<"Su cisterna esta llena"<<endl;
                return 2;
            }
            else {
                return -1; // Valor invalido
            }
        }


 float tanqueVacio(float tan){
            if(tan <= 0.3){
            cout<<"Su tanque esta vacio"<<endl;
                return 0;
            }
            else if(tan > 0.3 && tan < 1.30){
            	cout<<"Su tanque esta en la media"<<endl;
                return 1;
            }
            else if(tan >= 1.30 && tan <= 1.80){
            	cout<<"Su tanque esta lleno"<<endl;
                return 2;
            }
            else {
                return -1; // Valor invalido
            }
        }

Hacer las funciones tipo Int ya q estamos returnando valores de ese tipo
Obesrvaciones: 
 Si la Bomba se debe encender cuando el tanque esta vacio osea q no esta lleno para q usar valores q digan q el tanque esta en la media q de hecho es una mala indicacion. 
En resumen con solo saber q no esta lleno basta valor de media es innecesario.


.................................................................

6. Falta de validaciones

Si introduces valores como para nivel de agua en cisterna 0.0002 
y nivel de agua en tanque 0.2 el programa no funciona como deberia ...

video adjunto



