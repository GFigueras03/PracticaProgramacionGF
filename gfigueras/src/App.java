import java.util.Arrays;

public class App {
    private static final String ORANGE = "\u001B[33m";
    private static final String WHITE = "\u001B[37m";
    private static final String RANDOM_MSG = "RANDOM WORD HAS BEEN GENERATED";
    private static final String HAMMINGCODE_MSG = "==HAMMING CODE SENT==";

    public static void main(String[] args) throws Exception {
        // APARTADO-1
        System.out.println(Arrays.toString(HammingCodeSystemGF.createWord()) + ORANGE + RANDOM_MSG + WHITE);
        // APARTADO-2
        HammingCodeSystemGF.calculateParitySize();
        HammingCodeSystemGF.fillArray();
        HammingCodeSystemGF.fillParities(HammingCodeSystemGF.getHammingCode());
        HammingCodeSystemGF.calculateParityBits(HammingCodeSystemGF.getHammingCode(),
                HammingCodeSystemGF.getSavedParityBits());

        System.out.println(HammingCodeSystemGF.calculateGlobalParityBit(HammingCodeSystemGF.getHammingCode(),
                HammingCodeSystemGF.getSavedParityBits()) + ORANGE + HAMMINGCODE_MSG + WHITE);
        // APARTADO-3
        HammingCodeSystemGF.randomNoise();
        HammingCodeSystemGF.makeNoise();
        // APARTADO-4
        HammingCodeSystemGF.reciever();
    }
}//