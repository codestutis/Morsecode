import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Map<Character, int[]> morseCodeMap = new HashMap<>();

        morseCodeMap.put('A', new int[]{50, 150});
        morseCodeMap.put('B', new int[]{150, 50, 50, 50});
        morseCodeMap.put('C', new int[]{150, 50, 150, 50});
        morseCodeMap.put('D', new int[]{150, 50, 50});
        morseCodeMap.put('E', new int[]{50});
        morseCodeMap.put('F', new int[]{50, 50, 150, 50});
        morseCodeMap.put('G', new int[]{150, 150, 50});
        morseCodeMap.put('H', new int[]{50, 50, 50, 50});
        morseCodeMap.put('I', new int[]{50, 50});
        morseCodeMap.put('J', new int[]{50, 150, 150, 150});
        morseCodeMap.put('K', new int[]{150, 50, 150});
        morseCodeMap.put('L', new int[]{50, 150, 50, 50});
        morseCodeMap.put('M', new int[]{150, 150});
        morseCodeMap.put('N', new int[]{150, 50});
        morseCodeMap.put('O', new int[]{150, 150, 150});
        morseCodeMap.put('P', new int[]{50, 150, 150, 50});
        morseCodeMap.put('Q', new int[]{150, 150, 50, 150});
        morseCodeMap.put('R', new int[]{50, 150, 50});
        morseCodeMap.put('S', new int[]{50, 50, 50});
        morseCodeMap.put('T', new int[]{150});
        morseCodeMap.put('U', new int[]{50, 50, 150});
        morseCodeMap.put('V', new int[]{50, 50, 50, 150});
        morseCodeMap.put('W', new int[]{50, 150, 150});
        morseCodeMap.put('X', new int[]{150, 50, 50, 150});
        morseCodeMap.put('Y', new int[]{150, 50, 150, 150});
        morseCodeMap.put('Z', new int[]{150, 150, 50, 50});

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
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(350);
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
