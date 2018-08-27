import java.util.Scanner;

/**
 * Basic arithmetic calculator program.
 * User enters 2 numbers with a floating point (4 decimal digits max) and one of the 4 basic arithmetic operations.
 * The program performs a chosen operation on entered numbers.
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
        System.out.println("Choose your mathematical function.");
        System.out.print("Enter '1' for addition, '2' for subtraction, '3' for multipication, '4' for division: ");
        int oper = scanner.nextInt();

        //If user enters "1" as operation, then the program performs ADDITION
        if (oper == 1) {
            float sum = n1 + n2;
            System.out.printf("%.4f + %.4f = %.4f\n", n1, n2, sum);
        }
        //If user enters "2" as operation, then the program performs SUBTRACTION
        if (oper == 2) {
            float sub = n1 - n2;
            System.out.printf("%.4f - %.4f = %.4f\n", n1, n2, sub);
        }
        //If user enters "3" as operation, then the program performs MULTIPLICATION
        if (oper == 3) {
            float mult = n1 * n2;
            System.out.printf("%.4f * %.4f = %.4f\n", n1, n2, mult);
        }
        //If user enters "4" as operation, then the program performs DIVISION
        if (oper == 4) {
            float div = n1 / n2;
            System.out.printf("%.4f / %.4f = %.4f\n", n1, n2, div);
        }
        System.out.println("Thank you for using our amazing calculator! Bye!");
    }
}