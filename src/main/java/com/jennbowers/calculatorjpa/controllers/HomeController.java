package com.jennbowers.calculatorjpa.controllers;

import com.jennbowers.calculatorjpa.helpers.CalculationsHelper;
import com.jennbowers.calculatorjpa.models.Operations;
import com.jennbowers.calculatorjpa.repositories.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    OperationsRepository repo;

    @RequestMapping("/")
    public String index(@RequestParam(value = "firstOperand", required = false) String                              firstOperandString,
                        @RequestParam(value = "operatorSelect", required = false) String operatorSelect,
                        @RequestParam(value = "secondOperand", required = false) String secondOperandString,
                        @RequestParam(value = "name", required = false) String name,
                        ModelMap model){

            System.out.println(name);
            System.out.println(firstOperandString);
            System.out.println(operatorSelect);
            System.out.println(secondOperandString);

        try {
            Double firstOperand = Double.parseDouble(firstOperandString);
            Double secondOperand = Double.parseDouble(secondOperandString);
            double result = CalculationsHelper.calculator(firstOperand, operatorSelect, secondOperand);

            Operations newOperations = new Operations(name, firstOperand, operatorSelect, secondOperand, result);
            repo.save(newOperations);

            model.addAttribute("fullEquation", firstOperand + " " + operatorSelect + " " + secondOperand);
            model.addAttribute("result", result);
        } catch (NullPointerException e) {
            System.out.println("Please enter a valid number");
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a number");
            return "index";
        }

        return "index";


    }

    @RequestMapping(value = "/history", method = RequestMethod.GET)
    public String history(Model model) {
        Iterable<Operations> operations = repo.findAll();
        model.addAttribute("operations", operations);
        return "userHistory";
    }

    @RequestMapping(value = "/history", method = RequestMethod.POST)
    public String history(@RequestParam("name") String name,
                          Model model){
        Iterable<Operations> operations = repo.findAll();
        List<Operations> userOperations = new ArrayList<>();

        for (Operations operation : operations) {
            if (operation.getName().equals(name)) {
                userOperations.add(operation);
            }
        }

        operations = userOperations;
        System.out.println("working");
        model.addAttribute("operations", operations);
        return "userHistory";
    }



}

