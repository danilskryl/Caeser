import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short answer;
        short secondAnswer;
        do {
            System.out.print("\nВыберите вид шифра: \n1 - Шифр Цезаря \n2 - Brut Force \n\nВведите: ");
            answer = sc.nextShort();
            if (answer == 1 || answer == 2) {
                break;
            }
        } while (true);

        if (answer == 1) {
            do {
                System.out.print("\nВыберите режим шифровщика: \n1 - Зашифровать текст \n2 - Расшифровать текст \nВыбранный режим: ");
                secondAnswer = sc.nextShort();
                if (secondAnswer == 1) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                        System.out.print("Введите текст, который нужно зашифровать: ");
                        String text = reader.readLine();
                        System.out.print("\nВведите код: ");
                        int key = sc.nextInt();
                        System.out.println(Caeser.encrypt(text, key, false));
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (secondAnswer == 2) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                        System.out.print("Введите текст, который нужно расшифровать: ");
                        String text = reader.readLine();
                        System.out.print("\nВведите код: ");
                        int key = sc.nextInt();
                        System.out.println(Caeser.encrypt(text, key, true));
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } while (true);
        }

    }
}
