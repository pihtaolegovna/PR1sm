package sakura.pr1sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {


    @PostMapping("/calculate")
    public String calculate(
            @RequestParam(name = "num1") double num1,
            @RequestParam(name = "num2") double num2,
            @RequestParam(name = "operation") String operation,
            Model model) {

        double result = 0;

        switch (operation) {
            case "add":
                result = num1 + num2;
                break;
            case "subtract":
                result = num1 - num2;
                break;
            case "multiply":
                result = num1 * num2;
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    model.addAttribute("result", "Division by zero is not allowed.");
                    return "calculator";
                }
                break;
            default:
                model.addAttribute("result", "Invalid operation.");
                return "calculator";
        }

        model.addAttribute("result", result);
        return "result";
    }
}