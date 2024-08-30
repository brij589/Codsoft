import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizGame {
    private static String[] quizQuestions = {
            "1. What is the capital of France?",
            "2. What is the chemical symbol for water?",
            "3. Who wrote 'To Kill a Mockingbird'?"
    };
    private static String[][] choices = {
            { "A. Berlin", "B. Madrid", "C. Paris", "D. Rome" },
            { "A. H2O", "B. CO2", "C. O2", "D. NaCl" },
            { "A. Harper Lee", "B. J.K. Rowling", "C. Mark Twain", "D. Ernest Hemingway" }
    };
    private static char[] correctAnswers = { 'C', 'A', 'A' };
    private static int currentQuestion = 0;
    private static int userScore = 0;
    private static boolean isAnswered = false;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("\n<---------You have 10 seconds to answer each question.---------->\n");
        for (currentQuestion = 0; currentQuestion < quizQuestions.length; currentQuestion++) {
            poseQuestion(inputScanner);
        }
        System.out.println("Quiz has ended.");

        displayResults();
        inputScanner.close();
    }

    private static void poseQuestion(Scanner inputScanner) {
        System.out.println(quizQuestions[currentQuestion]);
        for (String option : choices[currentQuestion]) {
            System.out.println(option);
        }

        isAnswered = false;
        Timer questionTimer = new Timer();
        questionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isAnswered) {
                    System.out.println("Time's up!");
                    validateAnswer(' ');
                }
            }
        }, 10000);

        String userAnswer = inputScanner.nextLine().toUpperCase();
        if (!isAnswered) {
            questionTimer.cancel();
            validateAnswer(userAnswer.length() > 0 ? userAnswer.charAt(0) : ' ');
        }
    }

    private static void validateAnswer(char userAnswer) {
        isAnswered = true;
        if (userAnswer == correctAnswers[currentQuestion]) {
            userScore++;
        }
    }

    private static void displayResults() {
        System.out.println("\nQuiz Complete!");
        System.out.println("Your Total Score: " + userScore + "/" + quizQuestions.length);
        for (int i = 0; i < quizQuestions.length; i++) {
            System.out.println(quizQuestions[i] + " - Correct Answer: " + correctAnswers[i]);
        }
    }
    }
