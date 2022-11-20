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
                        System.out.print("\n\nВведите путь с текстовым файлом, который нужно зашифровать: ");
                        String path = reader.readLine();
                        System.out.print("\nВведите код: ");
                        String stringPath = "encrypted.txt";
                        Path targetPath = Path.of("encrypted.txt");
                        int key = sc.nextInt();
                        try (FileReader fileReader = new FileReader(path); FileWriter fileWriter = new FileWriter(stringPath)) {
                            int count;
                            StringBuilder sb = new StringBuilder();
                            while ((count = fileReader.read()) != -1) {
                                sb.append((char) count);
                            }
                            String text = sb.toString();
                            if (Files.notExists(targetPath)) { Files.createFile(targetPath); }
                            String result = Caeser.encryptAndDecipher(text, key, false);
                            fileWriter.write(result);
                        }
                        break;
                    } catch (IOException e) {
                        System.err.println("\n\n\nВведите корректный путь к файлу!");
                        throw new RuntimeException(e);
                    }
                } else if (secondAnswer == 2) {
                    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                        System.out.print("\n\nВведите путь с текстовым файлом, который нужно расшифровать: ");
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
                            System.out.println(Caeser.encryptAndDecipher(text, key, true));
                            break;
                        } catch (IOException e) {
                            System.err.println("\n\n\nВведите корректный путь к файлу!");
                            throw new RuntimeException();
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } while (true);
        }


        if (answer == 2) {
            System.out.print("\nВведите путь до файла, который нужно взломать: ");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                String path = reader.readLine();
                try (FileReader fileReader = new FileReader(path)) {
                    int count;
                    StringBuilder sb = new StringBuilder();
                    while ((count = fileReader.read()) != -1) {
                        sb.append((char) count);
                    }
                    String text = sb.toString();
                    System.out.println("\nНачинаем взламывать шифр\n\n");
                    System.out.println("Вероятнее всего, Ваш текст: " + Caeser.brutForce(text));
                }
            } catch (IOException e) {
                System.err.println("\n\n\nВведите корректный путь к файлу");
            }
        }
    }
}
