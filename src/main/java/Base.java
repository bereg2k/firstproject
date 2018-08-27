import java.util.Scanner;

/**
 * Basic arithmetic calculator program.
 * User enters 2 numbers with a floating point (4 decimal digits max) and one of the 4 basic arithmetic operations.
 * The program performs a chosen operation on the entered numbers.
 *
 * @author Oleg Berezhnoy
 */
public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hi there! This is a basic console calculator.");

        System.out.print("Enter the first number: ");
        float n1 = scanner.nextFloat();
        System.out.print("Enter the second number: ");
        float n2 = scanner.nextFloat();
        System.out.println("Choose mathematical operation.");
        System.out.print("Enter '1' for addition, '2' for subtraction, '3' for multiplication, '4' for division: ");
        int oper = scanner.nextInt();

        //If user enters "1" as operation, then the program performs ADDITION
        if (oper == 1) {
            addAndPrint(n1, n2);
        }

        //If user enters "2" as operation, then the program performs SUBTRACTION
        else if (oper == 2) {
            subtractAndPrint(n1, n2);
        }

        //If user enters "3" as operation, then the program performs MULTIPLICATION
        else if (oper == 3) {
            multiplyAndPrint(n1, n2);
        }

        //If user enters "4" as operation, then the program performs DIVISION
        else if (oper == 4) {
            divideAndPrint(n1, n2);
        }

        //If users enters any other number, then the program shows an error message
        else {
            System.err.println("Entered operation is invalid!");
        }

        scanner.close();
        System.out.println("Thank you for using our amazing calculator! Bye!");
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

