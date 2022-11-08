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
}