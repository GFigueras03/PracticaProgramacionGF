import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // ?1
        System.out.println(Arrays.toString(NumeroBinario.mensaje()));
        // //!CALCULAR LONGITUD CODIGO HAMMING
        // NumeroBinario.longitudBloque();
        // !
        // !CALCULAR CANTIDAD DE PARIDAD
        NumeroBinario.calcularParidad();
        // !
        // !RELLENAR EL ARRAY
        NumeroBinario.rellenarArray();
        NumeroBinario.rellenarParidades();
      
        // !
        // ! CALCULAR TODAS LAS PARIDADES Y BITS
        NumeroBinario.calcularBitsParidad(NumeroBinario.getCodigoHamming());
        System.out.println(NumeroBinario.paridadGlobal(NumeroBinario.getCodigoHamming()));
        // System.out.println("<=============================>");

        // // !
        // // ?3
        NumeroBinario.noise();
        NumeroBinario.hacerRuido();
        // // ! RECIEVER

    }
}//