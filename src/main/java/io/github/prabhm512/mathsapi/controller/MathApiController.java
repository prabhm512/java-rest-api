package io.github.prabhm512.mathsapi.controller;

import java.util.Arrays;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.ArrayStack;

import io.github.prabhm512.mathsapi.model.Math;

@RestController
public class MathApiController {

    private int num1;
    private int num2;
    private String operation="";
    private String[][] calculations = {{"1", "1", "plus", "2"}};
    private Object updatedCalcs;

    // Insert new calculation into array
    public static String[][] insertRow(String[][] calculations, int numOfRows, String[] newData) {
        String[][] out = new String[calculations.length + 1][];
        for (int i = 0; i < numOfRows; i++) {
            out[i] = calculations[i];
        }
        out[calculations.length] = newData;
        for (int i = numOfRows + 1; i < out.length; i++) {
            out[i] = calculations[i - 1];
        }
        return out;
    }
    
    // Get calculation numbers and operation
    @RequestMapping(value="/api/maths", method=RequestMethod.GET)
    public Object getMaths() {
        
        // Convert string to object
        Object obj = updatedCalcs;

        return obj;
    }

    // Update calculation numbers and operation
    @RequestMapping(value="/api/maths", method=RequestMethod.POST)
    public void postMath(@RequestParam("num1") String retNum1, @RequestParam("num2") String retNum2, @RequestParam("operation") String retOperation) {
        num1 = Integer.parseInt(retNum1);
        num2 = Integer.parseInt(retNum2);
        switch (retOperation) {
            case "plus":   
                operation = "plus";
                break;
            case "minus": 
                operation = "minus";
                break;
            case "multiply":
                operation = "multiply";
                break;
            case "divide":
                operation = "divide";
                break;
            default: 
                operation = "plus";
                break;
        }    

        // Get result
        Math math = new Math(num1, num2, operation);
        String result = Integer.toString(math.getResult());
        
        // Push new data to array
        String[] newData = {retNum1, retNum2, operation, result};

        updatedCalcs = insertRow(calculations, 1, newData);

        // Get result
        // getMaths();
    }
}
