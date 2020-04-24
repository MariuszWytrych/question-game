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
        System.out.println("Do wyboru masz dwa sposby gry. Wybeirz jeden z nich. \n 1. Odczyt odpowiedzi z pliku. " +
                "\n 2. Odczyt odpowiedzi z konsoli.");


        BufferedReader brProperties = new BufferedReader(new FileReader("properties.txt"));
        int menu = 0;
        String lineFromProperties;

        lineFromProperties = brProperties.readLine();
            String[] columnsOfProperties = lineFromProperties.split(";");
            menu = Integer.parseInt(columnsOfProperties[1]);
        brProperties.close();

        switch (menu) {
            case 1:
                gameOnFile();
                break;
            case 2:
                gameOnConsole();
                break;
            default: {
                System.out.println("Nie ma takiej opcji. Wybierz ponownie");
            }
        }
    }


    private static void gameOnFile() throws IOException {

        Scanner scannerFileQuestion = new Scanner(new File("question.txt"));
        BufferedReader bRAnswer = new BufferedReader((new FileReader("answers.txt")));
        String lineFromFileQuestion;
        String lineFromFileAnswer;
        BufferedReader brProperties = new BufferedReader(new FileReader("properties.txt"));
        String lineFromProperties;
        int silentOnFromFile;

        lineFromProperties = brProperties.readLine();
        String[] columnsOfProperties = lineFromProperties.split(";");
        silentOnFromFile = Integer.parseInt(columnsOfProperties[5]);

        brProperties.close();
//        System.out.println("Jeśli chcesz zagrać w trybie cichym wcinij 1, jeśli nie wciśnij inny klawisz i potwierdź " +
//                "enterem");
        boolean silentOn = false;
        int option = 0;
        option = silentOnFromFile;
        switch (option) {
            case 1:
                silentOn = true;
                break;
            default: {
            }
        }

        try {
            while ((lineFromFileAnswer = bRAnswer.readLine()) != null) {
                String[] answerFromFile = lineFromFileAnswer.split("");
                for (int i = 0; i < answerFromFile.length; i++) {
                    lineFromFileQuestion = scannerFileQuestion.nextLine();
                    String[] columnForQuestion = lineFromFileQuestion.split(";");
                    String question = columnForQuestion[1];
                    if (!silentOn) {
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
    }

    private static void gameOnConsole() throws FileNotFoundException {
        Scanner scanner1 = new Scanner(System.in);
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
                answer = scanner1.nextLine().toUpperCase();
                switch (answer) {
                    case "T":
                        System.out.println(columnForQuestion[4]);
                        if (idQuestion == idQuestionForT) {
                            System.out.println(columnForQuestion[1]);
                            answer = scanner1.nextLine().toUpperCase();
                            while (answer.equalsIgnoreCase("T")) {
                                System.out.println(columnForQuestion[1]);
                                answer = scanner1.nextLine().toUpperCase();
                            }

                        }
                        break;
                    case "N":
                        System.out.println(columnForQuestion[5]);
                        if (idQuestion == idQuestionForN) {
                            System.out.println(columnForQuestion[1]);
                            answer = scanner1.nextLine().toUpperCase();
                            while (answer.equalsIgnoreCase("N")) {
                                System.out.println(columnForQuestion[1]);
                                answer = scanner1.nextLine().toUpperCase();
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


}
