import java.util.Arrays;


public class App {
    public static void main(String[] args) throws Exception {
        //?1
        //!NUMERO ALEATORIO O ESCOGIDO
        NumeroBinario.numeroEscogido = (int)Math.round(Math.random()*1000);
        // NumeroBinario.numeroEscogido = 1;
        System.out.println("mensaje original = " +  Arrays.toString(NumeroBinario.obtenerNumeroBinario()));
        System.out.println("<================================>");
        // System.out.println("= "+NumeroBinario.binarioDecimal());
        //!
        //?2
        //!CALCULAR LONGITUD CODIGO HAMMING
        NumeroBinario.longitudBloque();
        //!
        //!CALCULAR CANTIDAD DE PARIDAD
        NumeroBinario.calcularParidad();
        //!
        //!RELLENAR EL ARRAY
        NumeroBinario.rellenarArray();
        //!
        //! CALCULAR TODAS LAS PARIDADES Y BITS
        NumeroBinario.paridadUno();
        NumeroBinario.paridadDos();
        NumeroBinario.paridadTres();
        NumeroBinario.paridadCuatro();
        NumeroBinario.paridadCinco();
        NumeroBinario.calcularParidadGlobal();
        System.out.println("<=============================>");
        //!
        //?3
        NumeroBinario.noise();
        NumeroBinario.hacerRuido();
        //! RECIEVER
        NumeroBinario.reciever();


    }
}//     