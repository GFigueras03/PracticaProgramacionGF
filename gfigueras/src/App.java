import java.util.Arrays;
import javax.sound.sampled.SourceDataLine;
import java.util.stream.Stream;


public class App {
    public static void main(String[] args) throws Exception {
        //NumeroBinario.numeroEscogido = (int)Math.round(Math.random()*100000);
        NumeroBinario.numeroEscogido = 943;
        System.out.println(Arrays.toString(NumeroBinario.imprimirNumeroBinario()));
    }
}