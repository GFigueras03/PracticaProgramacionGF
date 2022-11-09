import java.util.Arrays;
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
      System.out.println(posicionesArray);
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
        System.out.println(potenciasDeDos);
      }
      //!FUNCTION CALCULAR BITS DE PARIDAD
      public static Integer bitParidad = 0;
      public static void calcularParidad(){
        for(int i = 0; i<= 5; i++){
          if((obtenerNumeroBinario().length + 1 + i) <= Math.pow(2, i)){
            bitParidad = i;
            break;
          }
        }
        // System.out.println(bitParidad);
      
      }
    }
