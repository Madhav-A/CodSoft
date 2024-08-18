import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the number of Subjects: ");
            int numberOfsubjects = sc.nextInt();

            int[] marks = new int[numberOfsubjects];

            int totalMarks = 0;
            for (int i = 0; i < numberOfsubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + ": ");
                marks[i] = sc.nextInt();
                totalMarks += marks[i];
            }

            double avgPercentage = (double) totalMarks / numberOfsubjects;

            char grade;
            if (avgPercentage >= 90) {
                grade = 'A';
            }
            else if (avgPercentage >= 80) {
                grade = 'B';
            }
            else if (avgPercentage >= 70) {
                grade = 'C';
            }
            else if (avgPercentage >= 60) {
                grade = 'D';
            }
            else {
                grade = 'F';
            }

            System.out.println("Total Marks: " + totalMarks);
            System.out.println("Average Percentage: " + avgPercentage + "%");
            System.out.println("Grade: " + grade);
        }
    }
}
