import java.util.Arrays;
import java.util.*;

public class NumeroBinario {
  final static Integer PARIDADGLOBAL = 1;
  private static Integer tamaño;
  private static ArrayList<Integer> codigoHamming = new ArrayList<Integer>();
  private static ArrayList<Integer> mensajeSended = new ArrayList<Integer>();
  private static Integer[] bitparidadGuardados;
  private static Integer[] bitParidadComparados;
  private static Integer arrayPosiciones[];
  private static Integer[] resultado;
  private static Integer noise;
  private static Integer hammingSize;
  private static Integer suma = 0;
  private static Integer bitParidad;

  public static ArrayList<Integer> getCodigoHamming() {
    return codigoHamming;
  }

  public static Integer[] getBitParidadGuardados() {
    return bitparidadGuardados;
  }
  // *MENSAJE ALEATORIO */

  public static Integer tamaño() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Introduce el tamaño del mensaje");
    tamaño = sc.nextInt();
    return tamaño;
  }

  public static Integer[] mensaje = new Integer[tamaño()];

  public static Integer[] crearMensaje() {
    for (int i = 0; i < mensaje.length; i++) {
      mensaje[i] = (int) Math.round(Math.random() * 1);
    }
    return mensaje;
  }

  // !FUNCTION CALCULAR BITS DE PARIDAD
  public static void calcularParidad() {
    int calculoParidad = 0;
    do {
      calculoParidad++;
      bitParidad = calculoParidad;
    } while ((mensaje.length + calculoParidad + PARIDADGLOBAL) > Math.pow(2, calculoParidad));

    for (int i = 0; i < bitParidad + 1; i++) {
      if ((((mensaje.length) + (bitParidad) + 1) + PARIDADGLOBAL) == Math.pow(2, i)) {
        bitParidad--;
      }
    }
    bitparidadGuardados = new Integer[bitParidad + PARIDADGLOBAL];
    bitParidadComparados = new Integer[bitParidad + PARIDADGLOBAL];
    resultado = new Integer[bitParidad];
  }

  public static void rellenarArray() {
    hammingSize = ((mensaje.length) + (bitParidad) + PARIDADGLOBAL);
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
  }

  public static ArrayList<Integer> rellenarParidades(ArrayList<Integer> codigo) {
    for (int i = 0; i < codigoHamming.size(); i++) {
      if (codigo.get(i) == null) {
        codigo.set(i, 0);
      }
    }
    return codigo;
  }

  public static ArrayList<Integer> calcularBitsParidad(ArrayList<Integer> codigo, Integer[] bitsguardados) {
    suma = 0;
    for (int i = 0; i < bitParidad; i++) {
      for (int j = (int) Math.pow(2, i); j <= (codigoHamming.size() - 1); j += (int) Math.pow(2, (i + 1))) {
        for (int k = 0; k < (int) Math.pow(2, i); k++) {
          if ((j + k) == hammingSize) {
            break;
          } else if ((j + k) == (hammingSize - 1)) {
            if (codigo.get(j + k) == 1) {
              suma++;
            }
          } else {
            if (codigo.get(j + k) == 1) {
              suma++;
            }
          }
        }
      }
      if (suma % 2 == 0) {
        codigo.set((int) Math.pow(2, i), 0);
        bitsguardados[i + 1] = 0;
        suma = 0;
      } else {
        codigo.set((int) Math.pow(2, i), 1);
        bitsguardados[i + 1] = 1;
        suma = 0;
      }
    }
    return codigo;
  }

  public static ArrayList<Integer> calcularParidadGlobal(ArrayList<Integer> codigo, Integer[] bitsguardados) {
    suma = 0;
    for (int i = 0; i < hammingSize; i++) {
      if (codigo.get(i) == 1) {
        suma++;
      }
      if (suma % 2 == 0) {
        codigo.set(0, 0);
        bitsguardados[0] = 0;
      } else {
        codigo.set(0, 1);
        bitsguardados[0] = 1;

      }
    }
    return codigo;
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
      arrayPosiciones = new Integer[noise];
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
    }

  }

  public static void changenulls() {
    for (int i = 0; i < 1; i++) {
      for (int j = (int) Math.pow(2, i); j <= (codigoHamming.size() - 1); j *= 2) {
        mensajeSended.set(j, null);
        mensajeSended.set(0, null);
      }
    }
  }

  public static void reciever() {
    changenulls();
    switch (noise) {
      case 0:
        System.out.println("\u001B[32mNO HA HABIDO NINGUN ERROR \u001B[37m");
        break;
      case 1:
        System.out.println("\u001B[31m Ha ocurrido 1 error \u001B[37m");
        comprobar();
        System.out.println(codigoHamming + "ORIGINAL");
        System.out.println(mensajeSended + "RECIBIDO");
        break;
      case 2:
        System.out.println("\u001B[31m Han ocurrido 2 errores \u001B[37m");
        break;
    }
  }

  public static void case1() {
    for (int i = 0; i < bitParidad; i++) {
      for (int j = (int) Math.pow(2, i); j <= (codigoHamming.size() - 1); j *= 2) {
        if (arrayPosiciones[0] == j) {
          System.out.println("Ha fallado un bit de paridad ");
          break;
        }
      }
    }
  }

  public static void case2() {
    int aux = (bitParidad - 1);
    for (int i = 1; i < bitParidadComparados.length; i++) {
      if (bitparidadGuardados[i] != bitParidadComparados[i]) {
        resultado[aux] = 1;
        aux--;
      } else {
        resultado[aux] = 0;
        aux--;
      }
    }
    System.out.println(Arrays.toString(resultado));
  }

  public static void comprobar() {
    for (int i = 0; i < bitParidad; i++) {
      for (int j = (int) Math.pow(2, i); j <= (codigoHamming.size() - 1); j *= 2) {
        if (arrayPosiciones[0] == j) {
          case1();
          break;
        } else {
          rellenarParidades(mensajeSended);
          calcularBitsParidad(mensajeSended, bitParidadComparados);
          calcularParidadGlobal(mensajeSended, bitParidadComparados);
          case2();
          break;
        }
      }
      break;
    }
  }
}