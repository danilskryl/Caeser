public class Caeser {
    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    public static String encryptAndDecipher(String text, int key, boolean encryptOrDecipher) {
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

    public static String brutForce(String text) {
        StringBuilder sb = new StringBuilder();
        text = text.toLowerCase();
        int key = 1;
        String result;
        do {
            for (int i = 0; i < text.length(); i++) {
                char temp = symbolShift(text.charAt(i), key);
                sb.append(temp);
            }
            key++;
            result = sb.toString();
            sb.delete(0, sb.length() - 1);
            if (checkForNatureless(result)) {
                result = result.substring(1);
                break;
            }
        } while (true);
        return result;
    }

    private static boolean checkForNatureless (String text) {
        int position1 = text.indexOf(',');
        int position2 = text.indexOf('.');
        int position3 = text.indexOf(':');
        if (text.contains(".") && text.contains(",") && text.contains(":")) {
            if (text.charAt(position1 + 1) == ' ' && text.charAt(position2 + 1) == ' ' && text.contains(" ")
                    && text.charAt(position3 + 1) == ' ' && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(".") && text.contains(",")) {
            if (text.charAt(position1 + 1) == ' ' && text.charAt(position2 + 1) == ' ' && text.contains(" ")
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(",")) {
            if (text.charAt(position1 + 1) == ' ' && text.contains(" ")
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(".")) {
            if (text.charAt(position2 + 1) == ' ' && text.contains(" ")
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(".") && text.contains(":")) {
            if (text.charAt(position2 + 1) == ' ' && text.contains(" ") && text.charAt(position3 + 1) == ' '
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(",") && text.contains(":")) {
            if (text.charAt(position1 + 1) == ' ' && text.contains(" ") && text.charAt(position3 + 1) == ' '
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        } else if (text.contains(":")) {
            if (text.contains(" ") && text.charAt(position3 + 1) == ' '
                    && !text.endsWith("ъ") && !text.startsWith("?") && !text.startsWith(" ")) {
                return true;
            }
        }
        return false;
    }
}