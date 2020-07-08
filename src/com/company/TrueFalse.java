package com.company;

public class TrueFalse extends Question {

    public TrueFalse(String question) {
        super(question);
    }

    @Override
    public void addAnswer(String answer, Integer correctFlag) {
        if ((correctFlag == 1 || correctFlag == 0) && answers.size() < 2) {
            this.answers.put(answer, correctFlag);
        } else if (answers.size() == 2){
            System.out.println("Only 2 answers allowed!");
        } else {
            System.out.println("Correct answer flag must be '0' or '1' so " + answer + " was not added.");
        }
    }

}
