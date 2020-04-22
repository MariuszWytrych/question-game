import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) throws IOException {
//        LinkedList<Questions> questionsList = new LinkedList<Questions>();
//        questionsList.add(new Questions("1", "Czy w klasie Object znajduje się metoda toString()?",
//                "2",
//                "1", "", " Zła odpowiedź. Spróbuj jeszcze raz."));
//        questionsList.add(new Questions("2", "Czy w Javie istnieje wielodziedziczenie (klas)?",
//                "2", "3"," Niedobrze. Spróbuj jeszcze raz.", "Dobrze"));
//        questionsList.add(new Questions("3", "Czy BigDecimal dodaje się za pomocą operatora \"+\" ?",
//                "3", "4"," Uuu. Spróbuj jeszcze raz."," Bardzo dobrze "));
//        questionsList.add(new Questions("4", "Czy ArrayList to to samo, co LinkedList?",
//                "4", "3",  " Niestety błędna odpowidź. Spróbuj jeszcze raz.",
//                " Bardzo dobrze"));
//        questionsList.add(new Questions("5", "Czy int ma większy zakres niż long?",
//                "6", "5"," Gratulacje",
//                " Niedobrze. Spróbuj jeszcze raz."));
//        BufferedWriter bw = null;
//
//            try {
//                bw = new BufferedWriter(new FileWriter("question.txt"));
//                for (Questions writeQuestion : questionsList) {
//                    bw.write(writeQuestion.toString());
//                    bw.newLine();
//                }
//            }catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            bw.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("WItaj w grze słownej. Za chwilę otrzymasz 5 pytań, na każde z nich idziel odowiedzi T lub N.\n" +
                "Gdzie T oznacza Tak, a N oznacza Nie");
        System.out.println("Zaczynamy!");

        System.out.println("Wybierz tryb odpowiedzi\n 1 - tryb cichy\n 2 - tryb głośny");

        int optionMode;
        Scanner scanner = new Scanner(System.in);
        optionMode = scanner.nextInt();
        typeMode(optionMode);


        Scanner scannerFileQuestion = new Scanner(new File("question.txt"));
        BufferedReader bRAnswer = new BufferedReader((new FileReader("answers.txt")));
        String lineFromFileQuestion;
        String lineFromFileAnswer;

        try {
            while ((lineFromFileAnswer = bRAnswer.readLine()) != null) {
                String[] answerFromFile = lineFromFileAnswer.split("");
                for (int i = 0; i < answerFromFile.length; i++) {
                    lineFromFileQuestion = scannerFileQuestion.nextLine();
                    String[] columnForQuestion = lineFromFileQuestion.split(";");
                    String question = columnForQuestion[1];
                    if (typeMode(optionMode) == false) {
                        System.out.println(question);
                        System.out.println(answerFromFile[i]);
                    }

                }
                if (scannerFileQuestion.hasNext()) {
                    System.out.println("Failed");
                } else {
                    System.out.println("Passed");
                }
            }
            bRAnswer.close();
            scannerFileQuestion.close();

        } catch (Exception fail) {
            System.err.println("Wystąpił błąd wczytywania pliku.");
            fail.printStackTrace();
        }


//        gameOnConsole(scanner);


//        String answer;
//        int scores = 0;
//
//        for (Questions newQuestion : questionsList) {
//            System.out.println(newQuestion.question);
//            answer = scanner.nextLine();
//            while (!answer.equalsIgnoreCase(newQuestion.rightAnswer)) {
//                System.out.println(newQuestion.badInfo);
//                scores--;
//                answer = scanner.nextLine();
//            }
//            scores++;
//            System.out.println(newQuestion.goodInfo);
//
//        }
//        System.out.println("Passed! Twój wynik to: " + scores + " pkt.");
//
//
    }

    private static void gameOnConsole(Scanner scanner) throws FileNotFoundException {
        String answer;
        BufferedReader br = new BufferedReader(new FileReader("question.txt"));
        String line;
        try {
            while ((line = br.readLine()) != null) {
                String[] columnForQuestion = line.split(";");
                System.out.println(columnForQuestion[1]);
                int idQuestion = Integer.parseInt(columnForQuestion[0]);
                int idQuestionForT = Integer.parseInt(columnForQuestion[2]);
                int idQuestionForN = Integer.parseInt(columnForQuestion[3]);
                answer = scanner.nextLine().toUpperCase();
                switch (answer) {
                    case "T":
                        System.out.println(columnForQuestion[4]);
                        if (idQuestion == idQuestionForT) {
                            System.out.println(columnForQuestion[1]);
                            answer = scanner.nextLine().toUpperCase();
                            while (answer.equalsIgnoreCase("T")) {
                                System.out.println(columnForQuestion[1]);
                                answer = scanner.nextLine().toUpperCase();
                            }

                        }
                        break;
                    case "N":
                        System.out.println(columnForQuestion[5]);
                        if (idQuestion == idQuestionForN) {
                            System.out.println(columnForQuestion[1]);
                            answer = scanner.nextLine().toUpperCase();
                            while (answer.equalsIgnoreCase("N")) {
                                System.out.println(columnForQuestion[1]);
                                answer = scanner.nextLine().toUpperCase();
                            }
                        }
                        break;
                    default:
                        System.out.println("no match");

                }
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Wystapil blad przy wczytywaniu danych");
            e.printStackTrace();
        }
        System.out.println("Koniec gry!");
    }

    public static boolean typeMode(int optionMode) {
        if (optionMode == 1) {
            return true;
        } else {
            return false;
        }
    }


}
