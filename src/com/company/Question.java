package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Question {
    public String question;
    private static Scanner in = new Scanner(System.in);
    HashMap<String, Integer> answers = new HashMap<>();
    String[] choiceKeys;

    public Question(String question) {
        this.question = question;
    }

    public void addAnswer(String answer, Integer correctFlag) {
        if (correctFlag == 1 || correctFlag == 0) {
            this.answers.put(answer, correctFlag);
        } else {
            System.out.println("Correct answer flag must be '0' or '1' so " + answer + " was not added.");
        }
    }

    public Integer promptQuestion() {
        System.out.println("******************");
        System.out.println(question);
        return this.printAnswers();
    }

    Integer printAnswers() {
        Integer i = 0;
        choiceKeys = new String[answers.size()];

        for (String key : answers.keySet()) {
            choiceKeys[i] = key;
            System.out.println("" + (i + 1) + " - " + key);
            i++;
        }

        return this.getUserInput();
    }

    public Integer getUserInput() {
        Integer choiceIdx;

        System.out.println("Select your answer by entering a number and pressing 'enter': ");

        choiceIdx = in.nextInt();
        in.nextLine();

        while (choiceIdx < 1 || choiceIdx > answers.size()) {
            System.out.println("Enter valid answer, please...: ");
            choiceIdx = in.nextInt();
            in.nextLine();
        }

        return this.validateAnswer(choiceIdx);
    }

    public Integer validateAnswer(Integer answerChoice) {
        if (answers.get(choiceKeys[answerChoice-1]) == 1) {
            System.out.println("You got it! Yer smart :/\n");
            return 1;
        } else {
            System.out.println("WRONG!\n");
            return 0;
        }
    }

}
