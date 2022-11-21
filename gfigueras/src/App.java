import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        // ?1
        NumeroBinario.tamaño();
        System.out.println(Arrays.toString(NumeroBinario.mensaje()));
        // //!CALCULAR LONGITUD CODIGO HAMMING
        NumeroBinario.longitudBloque();
        // !
        // !CALCULAR CANTIDAD DE PARIDAD
        NumeroBinario.calcularParidad();
        // !
        // !RELLENAR EL ARRAY
        NumeroBinario.rellenarArray();
        // // !
        // // ! CALCULAR TODAS LAS PARIDADES Y BITS
        // NumeroBinario.paridadUno();
        // NumeroBinario.paridadDos();
        // NumeroBinario.paridadTres();
        // NumeroBinario.paridadCuatro();
        // NumeroBinario.paridadCinco();
        // NumeroBinario.calcularParidadGlobal();
        // System.out.println("<=============================>");
        // // !
        // // ?3
        // NumeroBinario.noise();
        // NumeroBinario.hacerRuido();
        // // ! RECIEVER
        // NumeroBinario.reciever();

    }
}//