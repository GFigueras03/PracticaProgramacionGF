import java.util.Arrays;


public class App {
    public static void main(String[] args) throws Exception {
        //NumeroBinario.numeroEscogido = (int)Math.round(Math.random()*1000);
        NumeroBinario.numeroEscogido = 17;
        System.out.println(Arrays.toString(NumeroBinario.obtenerNumeroBinario()));
        System.out.println("= "+NumeroBinario.binarioDecimal());
        NumeroBinario.longitudBloque();
        NumeroBinario.calcularParidad();
        NumeroBinario.rellenarArray();
        NumeroBinario.paridadUno();
        NumeroBinario.paridadDos();
        NumeroBinario.paridadTres();
        NumeroBinario.paridadCuatro();
        // NumeroBinario.contarParidadGlobal();
    }
}