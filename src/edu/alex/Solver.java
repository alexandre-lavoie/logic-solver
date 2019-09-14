/**
 * Logic Solver for String Equations
 * Created by Alexandre Lavoie
 */

package edu.alex;

// Java Utils
import java.util.Map;
import java.util.HashMap;

// JavaScript Engine
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Solver {

    // Javascript Engine Solver
    ScriptEngineManager stringEngineManager = new ScriptEngineManager();
    ScriptEngine stringEngine = stringEngineManager.getEngineByName("JavaScript");

    /**
     * Solves a logic equation using programming notation.
     * ? Allowed symbols (& for AND, ^ for XOR, | for OR, (!p|q) for Conditional, !(p^q) for Bidirectional)
     * @param equation Logic equation to solve
     */
    public void solve(String equation) {
        // Converts equation to uppercase to prevent issues with String replaceAll "true" and "false".
        equation = equation.toUpperCase();
        // Removes logic operators and splits remaining characters. This gets the variables.
        String equationVariableTokens[] = equation.replaceAll("[^a-zA-Z\\d\\s]", " ").replaceAll("  ", " ").split(" ");

        // Fill Map with equation variable tokens. Prevents doubles and whitespace.
        Map<String, String> variables = new HashMap<String, String>();

        for (String vToken : equationVariableTokens) {
            if (!vToken.equals("") && !variables.containsKey(vToken)) {
                System.out.print(vToken + "\t");
                variables.put(vToken, vToken);
            }
        }

        System.out.println();

        // For the number of state of the equation: 2^(n variables)
        for (int t = 0; t < Math.pow(2, variables.size()); t++) {
            // Get binary representation of current state.
            String binary = intToBinary(t, variables.size());
            // Set a copy of the equation.
            String tempEquation = equation;
            // Set index of current binary location.
            int binaryIndex = 0;
            // Fpr each variable in equaiton.
            for(String variable : variables.keySet()){
                // Get boolean state from binary representation of step in String.
                String booleanState = (binary.substring(binaryIndex, binaryIndex + 1).equals("1")) ? "true" : "false";
                // Replace all occurences of variables in equation.
                tempEquation = tempEquation.replaceAll(variable, booleanState);
                // Print current variable state.
                System.out.print(booleanState + "\t");
                // Increase binary index.
                binaryIndex++;
            }

            // Try to print solved equation using Javascript.
            try {
                Object solution = stringEngine.eval(tempEquation);
                System.out.println("=> " + ((solution.equals(1) || solution.equals(true)) ? "true" : "false"));
                
            } catch (ScriptException e) {
                System.out.println("=> " + e);
            }
        }
    }

    /**
     * Coverts a integer to binary string with desired length.
     * @param i Integer
     * @param size Size of binary
     * @return Binary string
     */
    private String intToBinary(int i, int length) {
        String binary = Integer.toBinaryString(i);

        while (binary.length() < length) {
            binary = "0" + binary;
        }

        return binary;
    }
}