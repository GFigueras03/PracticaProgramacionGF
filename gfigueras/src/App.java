import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // ?1
        System.out.println(Arrays.toString(NumeroBinario.crearMensaje()));
        //?2
        NumeroBinario.calcularParidad();
        NumeroBinario.rellenarArray();
        NumeroBinario.rellenarParidades(NumeroBinario.getCodigoHamming());
        NumeroBinario.calcularBitsParidad(NumeroBinario.getCodigoHamming(), NumeroBinario.getBitParidadGuardados());
        System.out.println(NumeroBinario.calcularParidadGlobal(NumeroBinario.getCodigoHamming(), NumeroBinario.getBitParidadGuardados()));
        //?3
        NumeroBinario.noise();
        NumeroBinario.hacerRuido();
        NumeroBinario.reciever();
        

    }
}//