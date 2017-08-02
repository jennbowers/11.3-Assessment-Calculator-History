package com.jennbowers.calculatorjpa.controllers;

import com.jennbowers.calculatorjpa.helpers.Calculations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(@RequestParam(value = "firstOperand", required = false) Double firstOperand,
                        @RequestParam(value = "operatorSelect", required = false) String operatorSelect,
                        @RequestParam(value = "secondOperand", required = false) Double secondOperand,
                        ModelMap model){
        try {
            System.out.println(firstOperand);
            System.out.println(operatorSelect);
            System.out.println(secondOperand);

            double result = Calculations.calculator(firstOperand, operatorSelect, secondOperand);

            model.addAttribute("fullEquation", firstOperand + " " + operatorSelect + " " + secondOperand);
            model.addAttribute("result", result);
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid number");
        }
        return "index";
    }

}

