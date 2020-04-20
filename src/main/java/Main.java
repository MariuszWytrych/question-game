import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
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
                        }
                        break;
                    case "N":
                        System.out.println(columnForQuestion[5]);
                        if (idQuestion == idQuestionForN) {
                            System.out.println(columnForQuestion[1]);
                            answer = scanner.nextLine().toUpperCase();
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
}
