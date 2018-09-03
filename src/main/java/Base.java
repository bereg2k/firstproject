import java.util.Scanner;

/**
 * 1. Basic arithmetic calculator program.
 * User enters 2 numbers with a floating point (4 decimal digits max) and one of the 4 basic arithmetic operations.
 * Task: The program performs a chosen operation on the entered numbers.
 *
 * 2. The longest element in a String Array.
 * User enters the array's length.
 * User enters the array's elements, one by one.
 * Task: find the longest element in array and print it and its length.
 * If there's more than one longest element, the program prints all of them with their length.
 *
 * @author Oleg Berezhnoy
 */
public class Base {
    public static void main(String[] args) {

        //startAgain - variable to let the "while"-cycle below know, whether user wants to exit the program or use it again.
        //exit - additional string variable to exit the program after executing a function (calculator, array...).
        //scanner - basic console input.
        boolean startAgain = true;
        String exit;
        Scanner scanner = new Scanner(System.in);

        while (startAgain) {

            //Main menu of the program. User can choose to open Calculator, Find max element in array or Exit.
            System.out.println();
            System.out.println("Hi there! This is the MAIN MENU. What would you like to work with?");
            System.out.print("Enter '1' for Calculator, '2' for Finding the longest element in array, '3' for Exit: ");
            int mainChoice = scanner.nextInt();

            //This branch is for accessing arithmetic calculator from the main menu.
            if (mainChoice == 1) {

                System.out.println("This is a basic console calculator.");
                System.out.print("Enter the first number: ");
                float n1 = scanner.nextFloat();
                System.out.print("Enter the second number: ");
                float n2 = scanner.nextFloat();
                System.out.println("Choose mathematical operation.");
                System.out.print("Enter '1' for addition, '2' for subtraction, '3' for multiplication, '4' for division: ");
                int oper = scanner.nextInt();

                switch (oper) {
                    case 1:
                        //If user enters "1" as operation, then the program performs ADDITION
                        addAndPrint(n1, n2);
                        break;

                    case 2:
                        //If user enters "2" as operation, then the program performs SUBTRACTION
                        subtractAndPrint(n1, n2);
                        break;

                    case 3:
                        //If user enters "3" as operation, then the program performs MULTIPLICATION
                        multiplyAndPrint(n1, n2);
                        break;

                    case 4:
                        //If user enters "4" as operation, then the program performs DIVISION
                        divideAndPrint(n1, n2);
                        break;

                    default:
                        //If users enters any other number, then the program shows an error message
                        System.err.println("Entered operation is invalid!");
                        break;
                }

                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("Would you like to start again [y/n]?: ");
                exit = scanner.next();
                if (exit.equals("y")) {
                    startAgain = true;
                } else if (exit.equals("n")) {
                    System.out.println("Thank you for using our amazing calculator! Bye!");
                    startAgain = false;
                } else {
                    System.err.println("Invalid input! Program aborted!");
                    startAgain = false;
                }

            }

            //This branch is for finding the longest element in the entered array.
            else if (mainChoice == 2) {
                System.out.println("Finding the longest element in array.");
                System.out.print("Please enter the number of elements in your array: ");

                //User enters the length of the array
                int arrayLength = scanner.nextInt();
                String array[] = new String[arrayLength];

                //User enters elements of array, one by one
                for (int i = 0; i < arrayLength; i++) {
                    System.out.print("Enter the element #" + (i + 1) + ": ");
                    array[i] = scanner.next();
                }

                //maxElement - string variable for cases when there's only ONE longest element
                //maxElementArray - array for cases when there's MORE THAN ONE longest element
                String maxElement = array[0];
                String maxElementArray[] = new String[arrayLength];

                //Going through the array and finding the longest element in it
                for (int j = 1; j < arrayLength; j++)
                    if (array[j].length() > maxElement.length()) {
                        maxElement = array[j];
                    }

                //maxCount - variable for counting a number of the longest elements (if there's more than one)
                //If this cycle finds an element in the array that has the length of the longest - it adds it to maxElementArray
                //In this case it also increments maxCount. This is to measure the number of the "real" elements in the maxElementArray.
                int maxCount = 0;
                for (int k = 0; k < arrayLength; k++) {
                    if (array[k].length() == maxElement.length()) {
                        maxElementArray[maxCount] = array[k];
                        maxCount++;
                    }
                }

                //maxCount should be == 1 if there's only one longest element. This code prints it and its length.
                if (maxCount == 1) {
                    System.out.print("The longest element in your array is '" + maxElement + "'. ");
                    System.out.println("It is " + maxElement.length() + " characters long.");
                }

                //maxCount should be > 1 if there's more than one longest element in array.
                //The cycle excludes printing 'null' elements of maxElementArray (see 'l < maxCount' condition)
                else if (maxCount > 1) {
                    System.out.println("Looks like there're more than 1 longest element in your array.");
                    System.out.print("The longest elements are: ");
                    for (int l = 0; l < maxCount; l++) {
                        System.out.print("'" + maxElementArray[l] + "' ");
                    }
                    System.out.println(". They are " + maxElement.length() + " characters long.");
                }

                /*If user enters "y", then program goes back to main menu.
                If user enters "n", then program ends its execution.
                Otherwise, the program terminates with an error.*/
                System.out.print("Would you like to start again [y/n]?: ");
                exit = scanner.next();
                if (exit.equals("y")) {
                    startAgain = true;
                } else if (exit.equals("n")) {
                    System.out.println("Thank you for using our longest-element-in-array tool! Bye!");
                    startAgain = false;
                } else {
                    System.err.println("Invalid input! Program aborted!");
                    startAgain = false;
                }
            }

            //This branch is for quitting the program from the main menu.
            else if (mainChoice == 3) {
                System.out.println("Thank you! Bye!");
                startAgain = false;
            }

            //This branch is for handling invalid input from the main menu.
            else {
                System.err.println("Invalid number entered! Please try again!");
                startAgain = true;
            }
        }
        scanner.close();
    }

    /**
     * This method performs an addition of n1 and n2 and printing the result to the console
     *
     * @param n1 First entered number
     * @param n2 Second entered number
     */
    private static void addAndPrint(float n1, float n2) {
        float sum = n1 + n2;
        System.out.printf("%.4f + %.4f = %.4f\n", n1, n2, sum);
    }

    /**
     * This method performs a subtraction of n1 and n2 and printing the result to the console
     *
     * @param n1 First entered number
     * @param n2 Second entered number
     */
    private static void subtractAndPrint(float n1, float n2) {
        float sub = n1 - n2;
        System.out.printf("%.4f - %.4f = %.4f\n", n1, n2, sub);
    }

    /**
     * This method performs a multiplication of n1 and n2 and printing the result to the console
     *
     * @param n1 First entered number
     * @param n2 Second entered number
     */
    private static void multiplyAndPrint(float n1, float n2) {
        float mult = n1 * n2;
        System.out.printf("%.4f * %.4f = %.4f\n", n1, n2, mult);
    }

    /**
     * This method performs a division of n1 and n2 and printing the result to the console
     *
     * @param n1 First entered number
     * @param n2 Second entered number
     */
    private static void divideAndPrint(float n1, float n2) {
        float div = n1 / n2;
        System.out.printf("%.4f / %.4f = %.4f\n", n1, n2, div);
    }
}

