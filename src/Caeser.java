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

    private static char symbolShift(char symbol, int shift) {
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
            sb.delete(0, sb.length());
            if (checkForNatureless(result)) {
                break;
            }
        } while (true);
        return result;
    }

    private static boolean checkForNatureless(String text) {
        int positionComma = text.indexOf(",");
        int positionDot = text.indexOf(".");
        int positionDoubleDot = text.indexOf(":");
        int positionExclamationMark = text.indexOf("!");
        int positionQuestionMark = text.indexOf("?");
        if (text.startsWith("!") || text.startsWith("?") || text.startsWith("ы")
                || text.startsWith("ъ") || text.startsWith("ь") || text.endsWith("ъ") || text.startsWith(" ")
                || text.startsWith("-") || text.startsWith(".") || text.startsWith(",") || text.startsWith(":")
                || text.endsWith(" ") || text.endsWith("-") || text.endsWith(":") || text.endsWith(",") || text.startsWith("\"")) {
            return false;
        } else if (text.contains(".") && text.contains(",") && text.contains(":") && text.contains("?") && text.contains("!")
        && !text.endsWith(".") && !text.endsWith("!") && !text.endsWith("?")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDot + 1) == ' '
                    && text.charAt(positionDoubleDot + 1) == ' ' && text.charAt(positionExclamationMark + 1) == ' '
                    && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.contains(".") && text.contains(",") && text.contains(":") && text.contains("!")
                && !text.endsWith(".") && !text.endsWith("!")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDot + 1) == ' '
                    && text.charAt(positionDoubleDot + 1) == ' ' && text.charAt(positionExclamationMark + 1) == ' ';
        } else if (text.contains(".") && text.contains(",") && text.contains(":") && text.contains("?")
                && !text.endsWith(".") && !text.endsWith("?")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDot + 1) == ' '
                    && text.charAt(positionDoubleDot + 1) == ' ' && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.contains(".") && text.contains(",") && text.contains(":") && !text.endsWith(".")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDot + 1) == ' '
                    && text.charAt(positionDoubleDot + 1) == ' ';
        } else if (text.contains(",") && text.contains(":") && text.contains("?") && !text.endsWith("?")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDoubleDot + 1) == ' '
                    && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.contains(",") && text.contains(":") && text.contains("!") && !text.endsWith("!")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDoubleDot + 1) == ' '
                    && text.charAt(positionExclamationMark + 1) == ' ';
        } else if (text.endsWith("?") && text.contains(",") && text.contains(".")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDot + 1) == ' ';
        } else if (text.endsWith("!") && text.contains(".") && text.contains(",")) {
            return text.charAt(positionDot + 1) == ' ' && text.charAt(positionComma + 1) == ' ';
        } else if (text.endsWith(".") && text.contains(",") && text.contains("?")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.endsWith(".") && text.contains(",") && text.contains("!")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionExclamationMark + 1) == ' ';
        } else if (text.endsWith(".") && text.contains(",") && text.contains("!") && text.contains("?")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionExclamationMark + 1) == ' '
                    && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.endsWith("?") && text.contains(".")) {
            return text.charAt(positionDot + 1) == ' ';
        } else if (text.endsWith("!") && text.contains(".")) {
            return text.charAt(positionDot + 1) == ' ';
        } else if (text.endsWith("?") && text.contains(",")) {
            return text.charAt(positionComma + 1) == ' ';
        } else if (text.endsWith("!") && text.contains(",")) {
            return text.charAt(positionComma + 1) == ' ';
        } else if (text.contains(".") && text.contains(",") && !text.endsWith(".")) {
            if (text.charAt(positionDot + 1) == ' ' && text.charAt(positionComma + 1) == ' ' && !text.endsWith("!")) {
                return true;
            }
            return text.charAt(positionDot + 1) == ' ' && text.charAt(positionComma + 1) == ' ' && !text.endsWith("?");

        } else if (text.endsWith(".") && text.contains(",") && text.contains(":")) {
            return text.charAt(positionComma + 1) == ' ' && text.charAt(positionDoubleDot + 1) == ' ';
        } else if (text.endsWith(".") && text.contains(",")) {
            return text.charAt(positionComma + 1) == ' ';
        } else if (text.contains(",")) {
            return text.charAt(positionComma + 1) == ' ';
        } else if (text.contains(":")) {
            return text.charAt(positionDoubleDot + 1) == ' ';
        } else if (text.contains(".") && !text.endsWith(".")) {
            return text.charAt(positionDot + 1) == ' ';
        } else if (text.endsWith("!")) {
            return text.contains(" ");
        } else if (text.endsWith("?")) {
            return text.contains(" ");
        } else if (text.contains(",")) {
            return text.charAt(positionComma + 1) == ' ';
        } else if (text.contains(".") && !text.endsWith(".")) {
            return text.contains(" ") || (!text.contains("?") && !text.contains("!"));
        } else if (text.endsWith(".")) {
            return !text.contains("!") && !text.contains("?");
        } else if (!text.contains(".") && !text.contains(",") && text.contains("?")) {
            return text.contains(" ") && text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.contains("?") && !text.endsWith("!")) {
            return text.charAt(positionQuestionMark + 1) == ' ';
        } else if (text.contains("!") && !text.endsWith("!")) {
            return text.charAt(positionExclamationMark + 1) == ' ';
        } else if (!text.contains("!") && !text.contains("?") && !text.contains(".") && !text.contains(",")
                && !text.contains(":") && !text.contains("'") && !text.contains("-")) {
            if (text.length() < 8 && (text.contains("а") || text.contains("е") || text.contains("и") || text.contains("о"))) {
                return true;
            } else return text.length() > 8 && text.contains(" ") && ((text.contains("а") && text.contains("е"))
                    || (text.contains("и") && text.contains("о")) || (text.contains("a") && text.contains("о"))
                    || (text.contains("а") && text.contains("и")) || (text.contains("е") && text.contains("и"))
                    || (text.contains("е") && text.contains("о")));
        }
        return false;
    }
}