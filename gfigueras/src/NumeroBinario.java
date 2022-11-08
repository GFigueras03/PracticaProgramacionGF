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
}