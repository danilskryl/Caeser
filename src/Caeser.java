public class Caeser {
    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    public static String encrypt(String text, int key, boolean encryptOrDecipher) {
        if (encryptOrDecipher) {
            key = 41 - key;
        }
        text = text.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char temp = symbolShift(text.charAt(i), key);
            sb.append(temp);
        }
        return sb.toString();
        }
    private static char symbolShift (char symbol, int shift) {
        if (alphabet.indexOf(symbol) != -1) {
            return alphabet.charAt((alphabet.indexOf(symbol) + shift) % alphabet.length());
        } else {
            return symbol;
        }
    }
}