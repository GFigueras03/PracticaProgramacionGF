import java.util.Arrays;
import java.util.*;

public class HammingCodeSystemGF {
  private final static Integer GLOBAL_PARITY = 1;
  private static ArrayList<Integer> hammingCode = new ArrayList<Integer>();
  private static ArrayList<Integer> messageRecieved = new ArrayList<Integer>();
  private static Integer[] savedParityBits;
  private static Integer[] comparedParityBits;
  private static Integer[] arrayRandomPosition;
  private static Integer[] binaryResult;
  private static Integer noise = 0;
  private static Integer hammingSize = 0;
  private static Integer parityAddition = 0;
  private static Integer parityBit = 0;

  // GETTERS
  public static ArrayList<Integer> getHammingCode() {
    return hammingCode;
  }

  public static Integer[] getSavedParityBits() {
    return savedParityBits;
  }

  // APARTADO-1
  public static Integer calculateSize() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Introduce the word size: ");
    final Integer WORDSIZE = sc.nextInt();
    return WORDSIZE;
  }

  public static Integer[] message = new Integer[calculateSize()];

  public static Integer[] createWord() {
    for (int i = 0; i < message.length; i++) {
      message[i] = (int) Math.round(Math.random() * 1);
    }
    return message;
  }

  // APARTADO-2
  public static void calculateParitySize() {
    int partityCount = 0;
    do {
      partityCount++;
      parityBit = partityCount;
    } while ((message.length + partityCount + GLOBAL_PARITY) > Math.pow(2, partityCount));

    for (int i = 0; i < parityBit + 1; i++) {
      if ((((message.length) + (parityBit) + 1) + GLOBAL_PARITY) == Math.pow(2, i)) {
        parityBit--;
      }
    }
    savedParityBits = new Integer[parityBit + GLOBAL_PARITY];
    comparedParityBits = new Integer[parityBit + GLOBAL_PARITY];
    binaryResult = new Integer[parityBit];
  }

  public static void fillArray() {
    hammingSize = ((message.length) + (parityBit) + GLOBAL_PARITY);
    for (int i = 0; i < message.length; i++) {
      hammingCode.add(i, message[i]);
    } // For rellena el message con el codigo original
    for (int i = 0; i <= hammingSize; i++) {
      for (int j = 0; j < hammingSize; j++) {
        if ((i == Math.pow(2, j)) || i == 0) {
          hammingCode.add(i, null);
          break;
        }
      }
    } // For que añade en las posiciones de paridad un null
    if (hammingCode.get(hammingCode.size() - 1) == null) {
      hammingCode.remove(hammingCode.size() - 1);
    }
  }

  public static ArrayList<Integer> fillParities(ArrayList<Integer> code) {
    for (int i = 0; i < hammingCode.size(); i++) {
      if (code.get(i) == null) {
        code.set(i, 0);
      }
    }
    return code;
  }

  public static ArrayList<Integer> calculateParityBits(ArrayList<Integer> code, Integer[] parityArray) {
    parityAddition = 0;
    for (int i = 0; i < parityBit; i++) {
      for (int j = (int) Math.pow(2, i); j <= (hammingCode.size() - 1); j += (int) Math.pow(2, (i + 1))) {
        for (int k = 0; k < (int) Math.pow(2, i); k++) {
          if ((j + k) == hammingSize) {
            break;
          } else if ((j + k) == (hammingSize - 1)) {
            if (code.get(j + k) == 1) {
              parityAddition++;
            }
          } else {
            if (code.get(j + k) == 1) {
              parityAddition++;
            }
          }
        }
      }
      if (parityAddition % 2 == 0) {
        code.set((int) Math.pow(2, i), 0);
        parityArray[i + 1] = 0;
        parityAddition = 0;
      } else {
        code.set((int) Math.pow(2, i), 1);
        parityArray[i + 1] = 1;
        parityAddition = 0;
      }
    }
    return code;
  }

  public static ArrayList<Integer> calculateGlobalParityBit(ArrayList<Integer> code, Integer[] parityArray) {
    parityAddition = 0;
    for (int i = 0; i < hammingSize; i++) {
      if (code.get(i) == 1) {
        parityAddition++;
      }
      if (parityAddition % 2 == 0) {
        code.set(0, 0);
        parityArray[0] = 0;
      } else {
        code.set(0, 1);
        parityArray[0] = 1;

      }
    }
    return code;
  }
  //APARTADO-3
  public static Integer randomNoise() {
    noise = (int) Math.round(Math.random() * 2);
    for (int i = 0; i < hammingCode.size(); i++) {
      messageRecieved.add(i, hammingCode.get(i));
    }
    return noise;
  }

  public static void makeNoise() {
    if (noise != 0) {
      arrayRandomPosition = new Integer[noise];
      for (int i = 0; i < noise; i++) {
        arrayRandomPosition[i] = (int) Math.round(Math.random() * (messageRecieved.size() - 1));
      }
      if (noise == 1) {
        messageRecieved.set((arrayRandomPosition[0]), ((messageRecieved.get(arrayRandomPosition[0]) + 1) %
            2));
      }

      else if (noise == 2) {
        while (arrayRandomPosition[0] == arrayRandomPosition[1]) {
          arrayRandomPosition[0] = (int) Math.round(Math.random() * (messageRecieved.size() - 1));
        }
        messageRecieved.set((arrayRandomPosition[0]), ((messageRecieved.get(arrayRandomPosition[0]) + 1) %
            2));
        messageRecieved.set((arrayRandomPosition[1]), ((messageRecieved.get(arrayRandomPosition[1]) + 1) %
            2));
      }
    }
    System.out.println(messageRecieved + "\u001B[36m==WORD RECIVED==\u001B[37m");
  }
  //APARTADO-4
  public static void reciever() {
    switch (noise) {
      case 0:
        System.out.println("\u001B[32mTHERE HASN'T BEEN AN ERROR \u001B[37m");
        break;
      case 1:
        System.out.println("\u001B[31mAN ERROR HAS HAPPENED \u001B[37m");
        checkError();
        break;
      case 2:
        System.out.println("\u001B[31mTWO ERRORS HAVE HAPPENED \u001B[37m");
        break;
    }
  }

  public static void checkError() {
    boolean parity = false;
    for (int i = 0; i < parityBit; i++) {
      if (arrayRandomPosition[0] == (int) Math.pow(2, i) || arrayRandomPosition[0] == 0) {
        caseParityBitError();
        parity = true;
        break;
      }
    }
    if (parity == false) {
      setNullSpaces();
      fillParities(messageRecieved);
      calculateParityBits(messageRecieved, comparedParityBits);
      calculateGlobalParityBit(messageRecieved, comparedParityBits);
      caseDataBitError();
    }

  }

  public static void setNullSpaces() {
    for (int i = 0; i < 1; i++) {
      for (int j = (int) Math.pow(2, i); j <= (hammingCode.size() - 1); j *= 2) {
        messageRecieved.set(j, null);
        messageRecieved.set(0, null);
      }
    }
  }

  public static void caseParityBitError() {
    System.out.println("\u001B[31mA PARITY BIT HAS FAILED \u001B[37m");
    System.out.println("\u001B[31mTHE POSITION OF THE ERROR IS \u001B[37m" + arrayRandomPosition[0]);
  }

  public static void caseDataBitError() {
    int aux = (parityBit - 1);
    for (int i = 1; i < comparedParityBits.length; i++) {
      if (savedParityBits[i] != comparedParityBits[i]) {
        binaryResult[aux] = 1;
        aux--;
      } else {
        binaryResult[aux] = 0;
        aux--;
      }
    }
    System.out.println(Arrays.toString(binaryResult));
    System.out.println("\u001B[35mCHECK THE WORD BASED ON THE POSITION GIVEN ABOVE\u001B[37m");
  }
}