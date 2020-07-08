package com.company;

import java.util.ArrayList;

public class QuizRunner {

    public static void main(String[] args) {
	// write your code here
    // Correct answer counter
        Integer counter = 0;

        // multiple choice (only 1 correct answer)
        Question sumOfTwoPlusTwo = new Question("What is the sum of 2 + 2?");
        sumOfTwoPlusTwo.addAnswer("3", 0);
        sumOfTwoPlusTwo.addAnswer("5", 0);
        sumOfTwoPlusTwo.addAnswer("4", 1);
        sumOfTwoPlusTwo.addAnswer("0", 0);

        // checkbox type question (multiple correct answers)
        //TODO: need to update method (override in new class) to ask multiple times for input up to the size of the answer set
        Question bestName = new Checkbox("What is the best name?");
        bestName.addAnswer("Salma", 1);
        bestName.addAnswer("Mya", 1);
        bestName.addAnswer("Kaleb", 1);
        bestName.addAnswer("Karen", 0);

        // true false question
        Question trueOrFalse = new TrueFalse("The sun is cold?");
        trueOrFalse.addAnswer("True", 0);
        trueOrFalse.addAnswer("False", 1);
            // won't get added to answers because coded to only accept 2 answers
        trueOrFalse.addAnswer("False", 1);

        // build array that contains the questions we created
        ArrayList<Question> allQuestions = new ArrayList<>();
        allQuestions.add(sumOfTwoPlusTwo);
        allQuestions.add(bestName);
        allQuestions.add(trueOrFalse);

        // iterate through the questions array and prompt the question/get the answers
        for (Question question : allQuestions) {
            counter += question.promptQuestion();
        }

        // give a summary of the results
        System.out.println("***********************");
        System.out.println("You answered " + counter + " out of " + allQuestions.size() + " questions correctly.");
    }
}
