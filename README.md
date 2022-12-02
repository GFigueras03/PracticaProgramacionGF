# Practica Programacion Guillermo Figueras
## <div align="center">Hamming Code</div>
* * *
### Apartado: 1
* Creo el metodo **createWord( )** que utiliza un scanner al que le pasamos el tamaño del mensaje que queremos generar, posteriormente con un Math.Random() se crea con 1's y 0's aleatorios.
### Aartado: 2
* Creo **calculateParitySize()** que principalmente calcula la cantidad de bits de paridad que vamos a utilizar mediante el tamaño de la palabra y las potencias de 2 que caben en ella.
* Creo **fillArray()** y **fillParities()** Para crear un nuevo array del tamaño del mensaje + los bits de paridad + eñ bit global... y le asigno nulls en las posiciones de paridad.
* Creo y diseño el metodo **calculateParityBits( )** el cual al principio puede ser bastante abstracto pero una vez lo pillas es sencillo. 
>![Image text](/img/diagrama.png)
    Con j te colocas en cada posicion de paridad y con k recorres hasta donde llega j para sumar 1 si 1 no o 2 si 2 no ... al final con j luego multiplicas por el doble para saltarte las posiciones que no miras
* Creo **calculateGlobalParityBit( )** que simplemente recorre el array ya con los bits de paridad calculados y suma++ si hay 1, y hace el %2 y lo setea en la paridad global
### APARTADO: 3
* **randomNoise()** : Genera aleatoriamente un numero entre 0, 1 y 2 y se guarda en la variable noise
* **makeNoise()** : 3 casos:
    * **noise = 0**: no hace nada
    * **noise = 1**: calcula un numero aleatorio hasta el tamaño del mensaje y en esa posicion cambia el valor al digito opuesto
    * **Noise = 2**: da aleatoriamente una posicion hasta el tamaño del array, (pero esta vez 2 veces) y si coincide la misma posicion se vuelve a ejecutar hasta que no coincida

### APARTADO: 4
* **reciever()**: hago un switch donde comprueba el ruido:
    * si es 0, suelta un mensaje sin error y no hace nada.
    * si es 1, comprueba con el metodo **checkError()**:
        * Este metodo comprueba que la posicion cambiada sea de datos o de paridad:
            * Si es de paridad ejecutara la funcion que avisa de que el fallo esta en un bit de paridad.
            * Si es de datos , ejecutara de nuevo el proceso de rellenar las de paridad con nulls, y calcular de nuevo el codigo hamming con el nuevo bit de datos cambiado, al crear las nuevas posiciones de paridad seran comparadas con las del mensaje enviado y hallaremos en binario la posicion del error.
    * Si es 2 no podra hacer el calculo de 2 errores y mostrara que hay 2 errores por pantalla 

### FINAL:
> LOS METODOS DE ESTA CLASE SERAN LLAMADOS EN LA CLASE APP 