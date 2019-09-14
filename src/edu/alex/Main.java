/**
 * Main class for Logic Solver
 * Created by Alexandre Lavoie
 */
package edu.alex;

// Solver class
import edu.alex.Solver;

// Scanner for input by user
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input equation from terminal.
        System.out.println();
        System.out.println("Boolean Logic Solver - Alexandre Lavoie");
        System.out.println("(& for AND, ^ for XOR, | for OR, (!p|q) for Conditional, == for Biconditional, exit to Exit)");

        while (true) {
            System.out.println();
            System.out.print("Equation: ");
            
            String equation = scanner.nextLine();
            System.out.println();

            if(equation.toLowerCase().equals("exit")){
                scanner.close();
                System.exit(0);
            }

            // Call the solver class and solve.
            Solver solver = new Solver();
            solver.solve(equation);
        }
    }
}