import java.util.Arrays;
import java.util.*;

public class NumeroBinario {
  public static Integer tamaño;
  public static ArrayList<Integer> potenciasDeDos = new ArrayList<Integer>();
  public static ArrayList<Integer> posicionesArray = new ArrayList<Integer>();
  public static ArrayList<Integer> codigoHamming = new ArrayList<Integer>();
  public static ArrayList<Integer> mensajeSended = new ArrayList<Integer>();
  public static ArrayList<Integer> arrayPosicionesErroneas = new ArrayList<Integer>();
  public static Integer numeroEscogido;
  private static Integer noise;
  static Integer hammingSize;
  static Integer suma = 0;
  static Integer paridadGlobal;
  static Integer bitParidad;
  static Integer ruidoCase1;

  public static ArrayList<Integer> getCodigoHamming() {
    return codigoHamming;
  }

  // *MENSAJE ALEATORIO */
  public static Integer tamaño() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce el tamaño del mensaje");
    tamaño = sc.nextInt();
    return tamaño;
  }

  public static Integer[] mensaje = new Integer[tamaño()];

  public static Integer[] mensaje() {
    for (int i = 0; i < mensaje.length; i++) {
      mensaje[i] = (int) Math.round(Math.random() * 1);
    }
    return mensaje;
  }

  // !FUNCTION CALCULAR BITS DE PARIDAD
  public static void calcularParidad() {
    System.out.println(codigoHamming);

    int i = 0;
    do {
      i++;
      bitParidad = i;
    } while ((mensaje.length + i + 1) > Math.pow(2, i));
    System.out.println(bitParidad);
    for (int j = 0; j < bitParidad + 1; j++) {
      if ((((mensaje.length) + (bitParidad) + 1) + 1) == Math.pow(2, j)) {
        bitParidad--;
      }
    }
    System.out.println("bitParidad = " + i);
  }

  public static void rellenarArray() {
    hammingSize = ((mensaje.length) + (bitParidad) + 1);
    for (int i = 0; i < mensaje.length; i++) {
      codigoHamming.add(i, mensaje[i]);
    } // For rellena el mensaje con el codigo original
    for (int i = 0; i <= hammingSize; i++) {
      for (int j = 0; j < hammingSize; j++) {
        if ((i == Math.pow(2, j)) || i == 0) {
          codigoHamming.add(i, null);
          break;
        }
      }
    } // For que añade en las posiciones de paridad un null
    if (codigoHamming.get(codigoHamming.size() - 1) == null) {
      codigoHamming.remove(codigoHamming.size() - 1);
    }
    System.out.println(codigoHamming);
  }

  public static ArrayList<Integer> rellenarParidades() {
    for (int i = 0; i < codigoHamming.size(); i++) {
      if (codigoHamming.get(i) == null) {
        codigoHamming.set(i, 0);
      }
    }
    return codigoHamming;
  }

  public static ArrayList<Integer> calcularBitsParidad(ArrayList<Integer> codigo) {
    suma = 0;
    for (int i = 0; i < bitParidad; i++) {
      for (int j = (int) Math.pow(2, i); j <= codigoHamming.size(); j += (int) Math.pow(2, (i + 1))) {
        for (int k = 0; k < (int) Math.pow(2, i); k++) {
          if ((j + k) == hammingSize) {
            break;
          } else if ((j + k) == (hammingSize - 1)) {
            if (codigoHamming.get(j + k) == 1) {
              suma++;
            }
          } else {
            if (codigoHamming.get(j + k) == 1) {
              suma++;
            }
          }
        }

      }
      if (suma % 2 == 0) {
        codigoHamming.set((int) Math.pow(2, i), 0);
        suma = 0;
      } else {
        codigoHamming.set((int) Math.pow(2, i), 1);
        suma = 0;
      }
    }
    return codigoHamming;
  }

  public static ArrayList<Integer> paridadGlobal(ArrayList<Integer> codigo) {
    suma = 0;
    for (int i = 0; i < hammingSize; i++) {
      if (codigoHamming.get(i) == 1) {
        suma++;
      }
      if (suma % 2 == 0) {
        codigoHamming.set(0, 0);
      } else {
        codigoHamming.set(0, 1);
      }
    }
    return codigoHamming;
  }

  public static Integer noise() {
    noise = (int) Math.round(Math.random() * 2);
    for (int i = 0; i < codigoHamming.size(); i++) {
      mensajeSended.add(i, codigoHamming.get(i));
    }
    return noise;
  }

  public static void hacerRuido() {
    if (noise != 0) {
      Integer arrayPosiciones[] = new Integer[noise];
      for (int i = 0; i < noise; i++) {
        Integer aux = (int) Math.round(Math.random() * (mensajeSended.size() - 1));
        arrayPosiciones[i] = aux;
      }
      if (noise == 1) {
        mensajeSended.set((arrayPosiciones[0]), ((mensajeSended.get(arrayPosiciones[0]) + 1) %
            2));
      }

      else if (noise == 2) {
        while (arrayPosiciones[0] == arrayPosiciones[1]) {
          arrayPosiciones[0] = (int) Math.round(Math.random() * (mensajeSended.size() - 1));
        }
        mensajeSended.set((arrayPosiciones[0]), ((mensajeSended.get(arrayPosiciones[0]) + 1) %
            2));
        mensajeSended.set((arrayPosiciones[1]), ((mensajeSended.get(arrayPosiciones[1]) + 1) %
            2));
      }
      System.out.println(Arrays.toString(arrayPosiciones) + "TAMAÑO DEL MENSAJE ==" + codigoHamming.size());
    }
  }

  // public static void reciever() {
  //   Integer cuenta = 0;
  //   System.out.println("<==||Mensaje enviado/original = " + codigoHamming + "||==>");
  //   System.out.println("<==||Mensaje recibido = " + mensajeSended + "||==>");
  //   for (int i = 0; i < codigoHamming.size(); i++) {
  //     if (codigoHamming.get(i) != mensajeSended.get(i)) {
  //       System.out.println("||||| el bit numero " + i + " falla |||||");
  //       cuenta++;
  //     }
  //   }
  //   if (cuenta > 0)
  //     System.out.println("<======El mensaje ha sufrido daños======>");
  //   else
  //     System.out.println("<=====El mensaje no ha sufrido daños======>");
  // }
}
