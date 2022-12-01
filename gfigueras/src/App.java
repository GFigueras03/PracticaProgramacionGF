import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // ?1
        System.out.println(Arrays.toString(NumeroBinario.crearMensaje()) + "\u001B[33mMENSAJE ALEATORIO GENERADO \u001B[37m");
        // ?2
        NumeroBinario.calcularParidad();
        NumeroBinario.rellenarArray();
        NumeroBinario.rellenarParidades(NumeroBinario.getCodigoHamming());
        NumeroBinario.calcularBitsParidad(NumeroBinario.getCodigoHamming(), NumeroBinario.getBitParidadGuardados());
        System.out.println(NumeroBinario.calcularParidadGlobal(NumeroBinario.getCodigoHamming(),
                NumeroBinario.getBitParidadGuardados()) + "\u001B[33m==CODIGO HAMMING ENVIADO==\u001B[37m");
        // ?3
        NumeroBinario.noise();
        NumeroBinario.hacerRuido();
        NumeroBinario.reciever();
    }
}//