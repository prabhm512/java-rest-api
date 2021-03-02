package io.github.prabhm512.mathsapi.controller;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.ui.Model;
// import org.springframework.web.servlet.ModelAndView;

// import io.github.prabhm512.mathsapi.model.Math;

// import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MathApiController {

    public String num1="1";
    public String num2="1";
    public String operation="plus";

    // Get calculation numbers and operation
    @RequestMapping(value="/api/maths", method=RequestMethod.GET)
    public Map<String, String> getMaths() {
        Map<String, String> mathsObj = new HashMap<String, String>();
        mathsObj.put("num1", num1);
        mathsObj.put("num2", num2);
        mathsObj.put("operation", operation);

        return mathsObj;
    }

    // Update calculation numbers and operation
    @RequestMapping(value="/api/maths", method=RequestMethod.POST)
    public Map<String, String> postMath(@RequestParam("num1") String retNum1, @RequestParam("num2") String retNum2, @RequestParam("operation") String retOperation) {
        // var parsedNum1 = Integer.parseInt(num1);
        // var parsedNum2 = Integer.parseInt(num2);
        
        Map<String, String> mathsObj = new HashMap<String, String>();
        // Populate hashmap
        mathsObj.put("num1", retNum1);
        mathsObj.put("num2", retNum2);
        mathsObj.put("operation", retOperation);

        num1 = retNum1;
        num2 = retNum2;
        operation = retOperation;

        getMaths();
        
        return mathsObj;
    }
}
