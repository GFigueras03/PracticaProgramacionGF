import java.util.Arrays;
import java.util.*;
import java.util.stream.Stream;

public class NumeroBinario{
    public static Integer numeroEscogido = 0;
    //!FUNCION PASAR DECIMAL A BINARIO
    public static Integer[] imprimirNumeroBinario(){
        String numBinario = Integer.toBinaryString(numeroEscogido);
        Integer numerosBinarios[] = new Integer[numBinario.length()];
        for(int i = 0; i< numBinario.length(); i++){
          numerosBinarios[i] = Integer.parseInt(numBinario.substring(i,i+1));
        }//for
        return numerosBinarios;
    }//Function


    public static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    //!FUNCION PASAR BINARIO A DECIMAL
    public static Integer binarioDecimal(){
      Integer numeroEscogido = NumeroBinario.numeroEscogido;
      Integer tamaño = Integer.toBinaryString(numeroEscogido).length();
      Integer suma = 0;
      for(int i = tamaño -1; i >= 0; i--){
        arrayList.add(i);
      }//for
      System.out.println(arrayList);
      for(int i = 0; i <= tamaño - 1; i++){
        if(imprimirNumeroBinario()[i] != 0){
          System.out.print((int)Math.pow(2, arrayList.get(i)) + " ");
          suma += (int)Math.pow(2, arrayList.get(i));
        }//if
      }//for
      return suma;
      }//function
       
      public static ArrayList<Integer> potenciasDeDos = new ArrayList<Integer>();

      public static void longitudBloque(){
        Integer count = 0;
        for(int i = 0; i<100; i++){
          potenciasDeDos.add((int)(Math.pow(2, i)));
        }
        //  System.out.println(potenciasDeDos);
        for(int i = 0; i< arrayList.size(); i++){
          for(int j = 0; j<potenciasDeDos.size(); j++){
            if(i == potenciasDeDos.get(j)){
              count++;
            }
          }
        }
        System.out.println(count);
      }
    }//clase
