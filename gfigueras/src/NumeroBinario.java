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
  static Integer paridadUno;
  static Integer paridadDos;
  static Integer paridadTres;
  static Integer paridadCuatro;
  static Integer paridadCinco;
  static Integer paridadGlobal;
  static Integer bitParidad;
  static Integer ruidoCase1;

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

  // *PARDIDAD 1
  public static void paridadUno() {
    int suma = 0;
    for (int i = 1; i < hammingSize; i += 2) {
      if (codigoHamming.get(i) != null) {
        suma += codigoHamming.get(i);
      }
    }
    if (suma % 2 == 0) {
      paridadUno = 0;
    } else {
      paridadUno = 1;
    }
    codigoHamming.set(1, paridadUno);
    // System.out.println(suma + " paridadUno");
  }

  // *PARDIDAD 2
  public static void paridadDos() {
    int suma = 0;
    for (int i = 2; i < hammingSize; i += 4) {
      for (int j = 0; j < 2; j++) {
        if (codigoHamming.get(i) == null) {
          codigoHamming.set(i, 0);
        }
        if ((i + j) == hammingSize) {
          break;
        } else {
          suma += codigoHamming.get(i + j);
        }
      }
    }
    if (suma % 2 == 0) {
      paridadDos = 0;
    } else {
      paridadDos = 1;
    }
    codigoHamming.set(2, paridadDos);
    // System.out.println(suma + " paridadDos");
    // System.out.println(codigoHamming);
  }

  // *PARDIDAD 3
  public static void paridadTres() {
    if (codigoHamming.size() > 4) {
      int suma = 0;
      for (int i = 4; i < hammingSize; i += 8) {
        for (int j = 0; j < 4; j++) {
          if (codigoHamming.get(i) == null) {
            codigoHamming.set(i, 0);
          } else if ((i + j) == hammingSize) {
            break;
          } else {
            suma += codigoHamming.get(i + j);
          }
        }
      }
      if (suma % 2 == 0) {
        paridadTres = 0;
      } else {
        paridadTres = 1;
      }
      codigoHamming.set(4, paridadTres);
      // System.out.println(suma + " paridadTres");
      // System.out.println(codigoHamming);
    }
  }

  // *PARDIDAD 4
  public static void paridadCuatro() {
    if (bitParidad >= 4) {
      int suma = 0;
      for (int i = 8; i < hammingSize; i += 16) {
        for (int j = 0; j < 8; j++) {
          if (codigoHamming.get(i) == null) {
            codigoHamming.set(i, 0);
          }
          if ((i + j) == hammingSize) {
            break;
          } else {
            suma += codigoHamming.get(i + j);
          }
          // System.out.println(codigoHamming.get(i+j));
        }
      }
      if (suma % 2 == 0) {
        paridadCuatro = 0;
      } else {
        paridadCuatro = 1;
      }
      codigoHamming.set(8, paridadCuatro);
      // System.out.println(suma + " paridadCuatro");
      // System.out.println(codigoHamming);
    }
  }

  // *PARDIDAD 4
  public static void paridadCinco() {
    if (bitParidad >= 5) {
      int suma = 0;
      for (int i = 16; i < hammingSize; i += 32) {
        for (int j = 0; j < 16; j++) {
          if (codigoHamming.get(i) == null) {
            codigoHamming.set(i, 0);
          }
          if ((i + j) == hammingSize) {
            break;
          } else {
            suma += codigoHamming.get(i + j);
          }
          // System.out.println(codigoHamming.get(i+j));
        }
      }
      if (suma % 2 == 0) {
        paridadCinco = 0;
      } else {
        paridadCinco = 1;
      }
      codigoHamming.set(16, paridadCuatro);
      // System.out.println(suma + " paridadCuatro");
      // System.out.println(codigoHamming);
    }
  }

  public static void calcularParidadGlobal() {
    int suma = 0;
    for (int i = 1; i < hammingSize; i++) {
      if (codigoHamming.get(i) == 1) {
        suma += 1;
      }
    }
    if (suma % 2 == 0) {
      paridadGlobal = 0;
    } else {
      paridadGlobal = 1;
    }
    codigoHamming.set(0, paridadGlobal);
    // System.out.println(suma + " paridadGlobal");
    System.out.println("Codigo hamming entero = " + codigoHamming);
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

  public static void reciever() {
    Integer cuenta = 0;
    System.out.println("<==||Mensaje enviado/original = " + codigoHamming + "||==>");
    System.out.println("<==||Mensaje recibido = " + mensajeSended + "||==>");
    for (int i = 0; i < codigoHamming.size(); i++) {
      if (codigoHamming.get(i) != mensajeSended.get(i)) {
        System.out.println("||||| el bit numero " + i + " falla |||||");
        cuenta++;
      }
    }
    if (cuenta > 0)
      System.out.println("<======El mensaje ha sufrido daños======>");
    else
      System.out.println("<=====El mensaje no ha sufrido daños======>");
  }
}
