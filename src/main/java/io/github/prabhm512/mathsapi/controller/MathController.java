package io.github.prabhm512.mathsapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.prabhm512.mathsapi.model.Math;

import java.util.Scanner;

@RestController
public class MathController {

    int scannedNum1;
    int scannedNum2;
    String operation;

    public void displayMenu() {
        System.out.println("What is the operation?");
        System.out.println ("1) plus \n2) minus \n3) divide \n4) multiply");
        System.out.print ( "Selection: " );
    }

    @GetMapping("/api/maths")
    public Math math() {

        Scanner scan = new Scanner(System.in);
        
        
        System.out.println("What is the first number?");
        if (scan.hasNextInt()) {
            scannedNum1 = scan.nextInt();
        }

        System.out.println("What is the second number?");
        if (scan.hasNextInt()) {
            scannedNum2 = scan.nextInt();
        }

        displayMenu();
        switch (scan.nextInt()) {
            case 1:
                operation = "plus";
                break;
            case 2:
                operation = "minus";
                break;
            case 3:
                operation = "divide";
                break;
            case 4: 
                operation = "multiply";
                break;
            default:
                operation = "plus";
                break;
        }
        scan.close();

        return new Math(scannedNum1, scannedNum2, operation);
    }
}