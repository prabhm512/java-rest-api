package io.github.prabhm512.mathsapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.prabhm512.mathsapi.model.Math;

@RestController
public class MathApiController {

    private int num1;
    private int num2;
    private String operation="";

    
    // Get calculation numbers and operation
    @RequestMapping(value="/api/maths", method=RequestMethod.GET)
    public Math getMaths() {
        
        // Get result from specified numbers and operation
        Math math = new Math(num1, num2, operation);

        return math;
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
        getMaths();
    }
}
