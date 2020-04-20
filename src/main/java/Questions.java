public class Questions {
    String idQuestion;
    String question;
    String idQuestionWhenAnswerT;
    String idQuestionsWhenAnswerN;
    String infoForT;
    String infoForN;

    public Questions(String idQuestion, String question, String idQuestionWhenAnswerT, String idQuestionsWhenAnswerN, String infoForT, String infoForN) {
        this.idQuestion = idQuestion;
        this.question = question;
        this.idQuestionWhenAnswerT = idQuestionWhenAnswerT;
        this.idQuestionsWhenAnswerN = idQuestionsWhenAnswerN;
        this.infoForT = infoForT;
        this.infoForN = infoForN;
    }

    @Override
    public String toString() {
        return idQuestion + ";" + question + ";" + idQuestionWhenAnswerT + ";" + idQuestionsWhenAnswerN + ";" +
                infoForT + ";" + infoForN
                ;
    }
}
