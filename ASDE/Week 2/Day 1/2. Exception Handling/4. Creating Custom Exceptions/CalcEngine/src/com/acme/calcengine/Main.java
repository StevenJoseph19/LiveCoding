package com.acme.calcengine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
/*
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null)
                performOperation(inputLine);*/
            processFile(reader);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + args[0]);
        } catch (IOException e) {
            System.out.println("Error reading file - " + e.getMessage());
        }catch (InvalidStatementException e) {
            System.out.println("Error invalid statement - " + e.getMessage());
            if (e.getCause() != null)
                System.out.println("  caused by " + e.getCause());
        }
        catch (Exception e) {
            System.out.println("Error processing file - " + e.getMessage());
        }
    }

    private static  void  processFile(BufferedReader reader) throws IOException, InvalidStatementException {
        String inputLine = null;
        while ((inputLine = reader.readLine()) != null)
            performOperation(inputLine);
    }
    private static void performOperation(String inputLine) throws InvalidStatementException {

        try {
            String[] parts = inputLine.split(" ");
            if (parts.length !=3)
                throw  new InvalidStatementException(" Statement must have 3 parts : operation leftVal rightVal");
            MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
            int leftVal = valueFromWord(parts[1]);
            int rightVal = valueFromWord(parts[2]);

            int result = execute(operation, leftVal, rightVal);

            System.out.println(inputLine + " = " + result);
        }catch (InvalidStatementException e) {
            throw e;
        }catch (Exception e) {
            throw new InvalidStatementException("Error processing statement",e);
        }
    }

    static int execute(MathOperation operation, int leftVal, int rightVal) {
        int result = 0;
        switch (operation) {
            case ADD:
                result = leftVal + rightVal;
                break;
            case SUBTRACT:
                result = leftVal - rightVal;
                break;
            case MULTIPLY:
                result = leftVal * rightVal;
                break;
            case DIVIDE:
                if (rightVal == 0){
//                    IllegalArgumentException exception =
//                            new IllegalArgumentException("Zero rightVal not permitted with divide operation");
//                            throw exception;

                            throw  new IllegalArgumentException("Zero rightVal not permitted with divide operation");
                }
                result = leftVal / rightVal;
                break;
        }
        return result;
    }

    static int valueFromWord(String word) {
        String[] numberWords = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"
        };
        int value = -1;
        for (int index = 0; index < numberWords.length; index++) {
            if (word.equals(numberWords[index])) {
                value = index;
                break;
            }
        }
        if (value == -1d)
            value = Integer.parseInt(word);

        return value;
    }

}
