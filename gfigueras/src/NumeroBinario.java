import java.util.Arrays;

import javax.naming.NoInitialContextException;

import java.util.*;


public class NumeroBinario{
    public static ArrayList<Integer> potenciasDeDos = new ArrayList<Integer>();
    public static ArrayList<Integer> posicionesArray = new ArrayList<Integer>();
    public static ArrayList<Integer>codigoHamming = new ArrayList<Integer>();
    public static Integer numeroEscogido = 0;
    static Integer hammingSize;
    static Integer paridadUno;
    static Integer paridadDos;
    static Integer paridadTres;
    static Integer paridadCuatro;
    static Integer paridadCinco;
    static Integer paridadGlobal;
    static Integer bitParidad;
    static Integer noise;

    
    //!FUNCION PASAR DECIMAL A BINARIO
    public static Integer[] obtenerNumeroBinario(){
        String numBinario = Integer.toBinaryString(numeroEscogido);
        Integer numerosBinarios[] = new Integer[numBinario.length()];
        for(int i = 0; i< numBinario.length(); i++){
          numerosBinarios[i] = Integer.parseInt(numBinario.substring(i,i+1));
        }//for
        return numerosBinarios;
    }//Function


    //!FUNCION PASAR BINARIO A DECIMAL
    public static Integer binarioDecimal(){
      Integer numeroEscogido = NumeroBinario.numeroEscogido;
      Integer tamaño = Integer.toBinaryString(numeroEscogido).length();
      Integer suma = 0;
      for(int i = tamaño -1; i >= 0; i--){
        posicionesArray.add(i);
      }//for
      // System.out.println(posicionesArray);
      for(int i = 0; i <= tamaño - 1; i++){
        if(obtenerNumeroBinario()[i] != 0){
          System.out.print((int)Math.pow(2, posicionesArray.get(i)) + " ");
          suma += (int)Math.pow(2, posicionesArray.get(i));
        }//if
      }//For
      return suma;
      }//function

      
      //!FUNCTION BLOQUE
      public static void longitudBloque(){
        for(int i = 0; i<12; i++){
          potenciasDeDos.add((int)(Math.pow(2, i)));
        }
        // System.out.println(potenciasDeDos);
      }
      //!FUNCTION CALCULAR BITS DE PARIDAD
      public static void calcularParidad(){
        for(int i = 0; i<= 5; i++){
          if((obtenerNumeroBinario().length + 1 + i) <= Math.pow(2, i)){
            bitParidad = i;
            break;
          }
        }
         System.out.println(bitParidad);
      
      }
      //!FUNCTION RELLENO LOS HUECOS DEL ARRAY COMPLETO MENOS LA PARIDAD
    public static void rellenarArray(){
      hammingSize = (obtenerNumeroBinario().length + 1 + bitParidad);
      for(int i = 0; i< obtenerNumeroBinario().length; i++){
        codigoHamming.add(i,obtenerNumeroBinario()[i]);
      }
      for(int i = 0; i<= hammingSize; i++){
        for(int j = 0; j< hammingSize; j++){
          if((i == Math.pow(2, j)) || i == 0){
            codigoHamming.add(i,null);
            break;
          }
        }
      }
      if(codigoHamming.get(codigoHamming.size()-1) == null){
        codigoHamming.remove(codigoHamming.size()-1);
      }
      System.out.println(codigoHamming);
      }
      //*PARDIDAD 1
    public static void paridadUno(){
      int suma = 0;
      for(int i = 1; i< hammingSize; i+=2){
        if(codigoHamming.get(i) != null){
          suma += codigoHamming.get(i);
        }
      }
      if(suma % 2 == 0){
        paridadUno = 0;
      }else{
        paridadUno = 1;
      }
      codigoHamming.set(1, paridadUno);
      // System.out.println(suma + " paridadUno");
      
    }
    //*PARDIDAD 2
    public static void paridadDos(){
      int suma = 0;
      for(int i = 2; i<hammingSize; i+=4){
        for(int j = 0; j<2; j++){
          if(codigoHamming.get(i) == null){
             codigoHamming.set(i,0);
           }
           if((i+j) == hammingSize){
             break;
           }
           else{
             suma += codigoHamming.get(i + j);
           } 
         }
        }
      if(suma % 2 == 0){
        paridadDos = 0;
      }else{
        paridadDos = 1;
      }
      codigoHamming.set(2, paridadDos);
      // System.out.println(suma + " paridadDos");
      // System.out.println(codigoHamming);
    }
     //*PARDIDAD 3
      public static void paridadTres(){
       int suma = 0;
       for(int i = 4; i<hammingSize; i+=8){
          for(int j = 0; j<4; j++){
           if(codigoHamming.get(i) == null){
              codigoHamming.set(i,0);
            }
            if((i+j) == hammingSize){
              break;
            }
            else{
              suma += codigoHamming.get(i + j);
            } 
          }
      }
       if(suma % 2 == 0){
         paridadTres = 0;
       }else{
         paridadTres = 1;
       }
       codigoHamming.set(4, paridadTres);
      //  System.out.println(suma + " paridadTres");
      //  System.out.println(codigoHamming);
     }
     //*PARDIDAD 4
     public static void paridadCuatro(){
       if(bitParidad >=4){
        int suma = 0;
        for(int i = 8; i<hammingSize; i+=16){
            for(int j = 0; j<8; j++){
              if(codigoHamming.get(i) == null){
                codigoHamming.set(i,0);
              }
              if((i+j) == hammingSize){
                break;
              }
              else{
                suma += codigoHamming.get(i + j);
              } 
              // System.out.println(codigoHamming.get(i+j));
            }
        }
         if(suma % 2 == 0){
           paridadCuatro = 0;
         }else{
           paridadCuatro = 1;
         }
         codigoHamming.set(8, paridadCuatro);
        //  System.out.println(suma + " paridadCuatro");
        //  System.out.println(codigoHamming);
       }
     }
      //*PARDIDAD 4
      public static void paridadCinco(){
        if(bitParidad >=5){
         int suma = 0;
         for(int i = 16; i<hammingSize; i+=32){
             for(int j = 0; j<16; j++){
               if(codigoHamming.get(i) == null){
                 codigoHamming.set(i,0);
               }
               if((i+j) == hammingSize){
                 break;
               }
               else{
                 suma += codigoHamming.get(i + j);
               } 
                
               // System.out.println(codigoHamming.get(i+j));
             }
         }
          if(suma % 2 == 0){
            paridadCinco = 0;
          }else{
            paridadCinco = 1;
          }
          codigoHamming.set(16, paridadCuatro);
         //  System.out.println(suma + " paridadCuatro");
         //  System.out.println(codigoHamming);
        }
      }
     public static void calcularParidadGlobal(){
      int suma = 0;
      for(int i = 1; i<hammingSize; i++){
        if(codigoHamming.get(i) == 1){
          suma +=1;
        }
      }
      if(suma % 2 == 0){
        paridadGlobal = 0;
      }else{
        paridadGlobal = 1;
      }
      codigoHamming.set(0, paridadGlobal);
      // System.out.println(suma + " paridadGlobal");
      System.out.println(codigoHamming);
     }

     public static Integer noise(){
        noise = (int)Math.round(Math.random()*2);
        System.out.println(noise);
      return noise;
     }
     public static void hacerRuido(){
      if(noise > 0){
        Integer[] posicionesErroneas = new Integer[noise];
        for(int i = 1; i<= noise; i++){
          posicionesErroneas[i-1] = (int)Math.round(Math.random()*hammingSize -1);
         if(posicionesErroneas.length > 1){
           if(posicionesErroneas[0] == posicionesErroneas[1]){
            posicionesErroneas[0] = (int)Math.round(Math.random()*hammingSize -1); 
           }
         }
         System.out.println(Arrays.toString(posicionesErroneas));
         codigoHamming.set(posicionesErroneas[i-1],(codigoHamming.get(posicionesErroneas[i-1])+1)%2);

        
        }
      }
      System.out.println(codigoHamming);
     }
    
}
