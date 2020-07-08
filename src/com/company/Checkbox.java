package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Checkbox extends Question {
    private static Scanner in = new Scanner(System.in);

    public Checkbox(String question) {
        super(question);
    }

    //TODO: add a string at end of question that states "select all that apply"

    @Override
    public Integer getUserInput() {
        Integer choiceIdx;
        Integer correctlyAnsweredCount = 0;
        Integer totalCorrectAnswers = 0;
        ArrayList<Integer> enteredAnswerTracker = new ArrayList<>();
        Boolean wrongAnswerFlag = false;

        // get total num of correct answers for the question
        for (Integer answer : answers.values()) {
            totalCorrectAnswers += answer;

        }
        System.out.println("correct answers " + totalCorrectAnswers);

        for (Integer i = 0; i < answers.size(); i++) {
            System.out.println("Enter a correct answer, if all correct answers have been chosen then enter '0' to move onto the next question : ");
            choiceIdx = in.nextInt();
            in.nextLine();

            if (choiceIdx == 0) {
                break;
            }

            while (choiceIdx < 1 || choiceIdx > answers.size() || enteredAnswerTracker.contains(choiceIdx)) {
                System.out.println("Enter valid answer, please...: ");
                choiceIdx = in.nextInt();
                in.nextLine();
            }

            enteredAnswerTracker.add(choiceIdx);

            if (validateAnswer(choiceIdx) == 0) {
                wrongAnswerFlag = true;
            }

            correctlyAnsweredCount += validateAnswer(choiceIdx);
        }

        if (wrongAnswerFlag || correctlyAnsweredCount < totalCorrectAnswers) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public Integer validateAnswer(Integer answerChoice) {
        if (answers.get(choiceKeys[answerChoice - 1]) == 1) {
            return 1;
        } else {
            return 0;
        }
    }

}
