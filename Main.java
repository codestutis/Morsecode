import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Map<Character, int[]> morseCodeMap = new HashMap<>();

        int unit_length = 50;
        int dot = unit_length ;
        int dash = 3 * unit_length;
        morseCodeMap.put('A', new int[]{dot, dash});
        morseCodeMap.put('B', new int[]{dash, dot, dot, dot});
        morseCodeMap.put('C', new int[]{dash, dot, dash, dot});
        morseCodeMap.put('D', new int[]{dash, dot, dot});
        morseCodeMap.put('E', new int[]{dot});
        morseCodeMap.put('F', new int[]{dot, dot, dash, dot});
        morseCodeMap.put('G', new int[]{dash, dash, dot});
        morseCodeMap.put('H', new int[]{dot, dot, dot, dot});
        morseCodeMap.put('I', new int[]{dot, dot});
        morseCodeMap.put('J', new int[]{dot, dash, dash, dash});
        morseCodeMap.put('K', new int[]{dash, dot, dash});
        morseCodeMap.put('L', new int[]{dot, dash, dot, dot});
        morseCodeMap.put('M', new int[]{dash, dash});
        morseCodeMap.put('N', new int[]{dash, dot});
        morseCodeMap.put('O', new int[]{dash, dash, dash});
        morseCodeMap.put('P', new int[]{dot, dash, dash, dot});
        morseCodeMap.put('Q', new int[]{dash, dash, dot, dash});
        morseCodeMap.put('R', new int[]{dot, dash, dot});
        morseCodeMap.put('S', new int[]{dot, dot, dot});
        morseCodeMap.put('T', new int[]{dash});
        morseCodeMap.put('U', new int[]{dot, dot, dash});
        morseCodeMap.put('V', new int[]{dot, dot, dot, dash});
        morseCodeMap.put('W', new int[]{dot, dash, dash});
        morseCodeMap.put('X', new int[]{dash, dot, dot, dash});
        morseCodeMap.put('Y', new int[]{dash, dot, dash, dash});
        morseCodeMap.put('Z', new int[]{dash, dash, dot, dot});

        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        String[] tokens = tokenize(text);
        for (String token : tokens) {
            for (int i = 0; i < token.length(); i++) {
                char let = Character.toUpperCase(token.charAt(i));
                int[] code = morseCodeMap.get(let);

                for (int num: code) {
                    Beep.beep(num);
                    try {
                        Thread.sleep(unit_length);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(3 * unit_length);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(7 * unit_length);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        input.close();
    }

    /**
     * 
     * @param token any string
     * @return new string with all non-alphabetic characters removed
     */
    public static String formatToken(String token) {
        String ret = "";
        for (int i = 0; i < token.length(); i++) {
            if (Character.isAlphabetic(token.charAt(i))) {
                ret += token.charAt(i);
            }
        }
        return ret;
    }

        /**
     * 
     * @param text text such as a book all as one string
     * @return an array of strings where text has been converted into tokens (separated by spaces)
     */
    public static String[] tokenize(String text) {
        return text.split("\\s+");
    }
    
}
