//Zakwan Berlin (with web help)
//BinaryFormatException
//Created 11/12/23
//Last Modified 11/12/23
//This program will throw a BinaryFormatException if the binary string is not 8 bits long.

import java.util.Scanner;

// Custom exception class for handling invalid binary strings
class BinaryFormatException extends Exception {
    public BinaryFormatException(String message) {
        super(message);
    }
}

public class BinaryConverter {

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a binary number
        System.out.print("Enter a binary number: ");
        String binaryString = scanner.nextLine();

        try {
            // Convert the binary string to decimal and display the result
            int decimalValue = bin2Dec(binaryString);
            System.out.println("Decimal equivalent: " + decimalValue);
        } catch (BinaryFormatException e) {
            // Handle the custom exception if the input is not a binary string
            System.out.println("Not a binary number: " + e.getMessage());
        }
    }

    // Modified bin2Dec method to throw BinaryFormatException
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        // Check if the string is a valid binary string
        if (!binaryString.matches("[01]+")) {
            throw new BinaryFormatException("Invalid binary string: " + binaryString);
        }

        // Convert the binary string to decimal
        int decimalValue = 0;
        int length = binaryString.length();

        for (int i = 0; i < length; i++) {
            char binaryDigit = binaryString.charAt(i);
            int power = length - i - 1;

            // Check if the character is '1', add 2^power to the result
            if (binaryDigit == '1') {
                decimalValue += Math.pow(2, power);
            }
        }

        return decimalValue;
    }
}
