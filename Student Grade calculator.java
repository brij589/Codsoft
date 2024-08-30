import java.util.Scanner;

public class AcademicPerformanceEvaluator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many subjects are you entering grades for? ");
        int numberOfSubjects = scanner.nextInt();
        System.out.println("Please enter grades (0-100):");

        int[] grades = new int[numberOfSubjects];
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter the grade for subject " + (i + 1) + " (maximum 100): ");
            grades[i] = scanner.nextInt();
        }

        int totalPoints = computeTotalPoints(grades);
        double averagePercentage = calculateAveragePercentage(totalPoints, numberOfSubjects);
        char letterGrade = determineGrade(averagePercentage);

        System.out.println("\nSummary:");
        System.out.println("Total Points: " + totalPoints);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + letterGrade);

        scanner.close();
    }

    private static int computeTotalPoints(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum;
    }

    private static double calculateAveragePercentage(int totalPoints, int numberOfSubjects) {
        return (double) totalPoints / numberOfSubjects;
    }

    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
