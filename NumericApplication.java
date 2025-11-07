// Module 1 - Numeric Application 
// Author: Gabriela Rivera
// Date: 05/11/2025
// Description:
// The program will ask me to enter some numbers, several, 
// one by one, until I enter 0, and then it will calculate 
// and display the total, the average, and the highest number.

// Import Java utilities for Scanner and ArrayList
import java.io.PrintWriter;
import java.util.*;

public class NumericApplication {

    // main method: program entry point
    public static void main(String[] args) {
        // Create Scanner to read user input
        Scanner input = new Scanner(System.in);

        // Call a helper method to display the welcome message
        showWelcomeMessage();

        // Call method that reads numbers from the user
        List<Double> numbers = readNumbers(input);

        // If no numbers were entered, exit gracefully
        if (numbers.isEmpty()) {
            System.out.println("No numbers entered. Exiting program.");
            input.close();
            return;
        }

        // Calculate result: sum, average, highest
        double sum = calculateSum(numbers);
        double average = calculateAverage(numbers);
        double highest = findHighest(numbers);

        // Display results using another helper method
        showResults(numbers, sum, average, highest);

        // Close the Scanner to free memory
        input.close();

        // Goodbye message
        System.out.println("Program finished successfully!");
    }

    // Prints a greeting and instructions
    public static void showWelcomeMessage() {
        System.out.println("=== Modulo 1 ===");
        System.out.println("Welcome to the Numeric Application!");
        System.out.println("Enter numbers one by one. Type 0 to stop.\n");
    }

    // readNumbers: Reads input numbers until the user types 0.
    public static List<Double> readNumbers(Scanner input) {
        List<Double> numbers = new ArrayList<>();
        double num;

        while (true) {
            System.out.print("Enter a number (0 to stop): ");
            num = input.nextDouble();

            // Check if user wants to stop
            if (num == 0) {
                System.out.println("Input finished.\n");
                break;
            }

            // Add number to the list
            numbers.add(num);
        }

        // Display confirmation message
        System.out.println("You entered " + numbers.size() + " numbers.");
        System.out.println("Numbers collected successfully.\n");

        return numbers;
    }

    // Computes the total sum of all numbers.
    public static double calculateSum(List<Double> numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum;
    }

    // Computes the average of the numbers.
    public static double calculateAverage(List<Double> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        double sum = calculateSum(numbers);
        return sum / numbers.size();
    }

    // Finds the largest number in the list.
    public static double findHighest(List<Double> numbers) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double n : numbers) {
            if (n > highest) {
                highest = n;
            }
        }
        return highest;
    }

    // Displays total, average, and highest values.
    public static void showResults(List<Double> numbers, double sum, double average, double highest) {
        System.out.println("=== RESULTS ===");
        System.out.println("Numbers entered: " + numbers.size());
        System.out.println("Total: " + sum);
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Highest number: " + highest);
        System.out.println("================\n");

        // Additional print for clarity
        System.out.println("This simple project demonstrates:");
        System.out.println("- Reading user input using Scanner");
        System.out.println("- Storing numbers in a List");
        System.out.println("- Using loops and conditionals");
        System.out.println("- Creating and calling custom methods");
        System.out.println();

        // Save results to a file
        try {
            PrintWriter writer = new PrintWriter("results.txt");
            writer.println("=== NUMERIC APPLICATION RESULTS ===");
            writer.println("Numbers entered: " + numbers.size());
            writer.println("Total: " + sum);
            writer.printf("Average: %.2f\n", average);
            writer.println("Highest number: " + highest);
            writer.close();
            System.out.println("Results have been saved to results.txt successfully!");
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

}