import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
                        System.out.print("Введите путь с текстовым файлом, который нужно зашифровать: ");
                        String path = reader.readLine();
                        System.out.print("\nВведите код: ");
                        String stringPath = "encrypted.txt";
                        Path targetPath = Path.of("encrypted.txt");
                        if (Files.notExists(targetPath)) {
                            Files.createFile(targetPath);
                        }
                        int key = sc.nextInt();
                        try (FileReader fileReader = new FileReader(path); FileWriter fileWriter = new FileWriter(stringPath)) {
                            int count;
                            StringBuilder sb = new StringBuilder();
                            while ((count = fileReader.read()) != -1) {
                                sb.append((char) count);
                            }
                            String text = sb.toString();
                            String result = Caeser.encrypt(text, key, false);
                            fileWriter.write(result);
                        }
                        break;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else if (secondAnswer == 2) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                        System.out.print("Введите путь с текстовым файлом, который нужно расшифровать: ");
                        String path = reader.readLine();
                        System.out.print("\nВведите код: ");
                        int key = sc.nextInt();
                        try (FileReader fileReader = new FileReader(path)) {
                            int count;
                            StringBuilder sb = new StringBuilder();
                            while ((count = fileReader.read()) != -1) {
                                sb.append((char) count);
                            }
                            String text = sb.toString();
                            System.out.println(Caeser.encrypt(text, key, true));
                            break;
                        } catch (IOException e) {
                            throw new RuntimeException();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } while (true);
        }

    }
}
