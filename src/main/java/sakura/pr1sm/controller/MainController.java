package sakura.pr1sm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String homePage() {
        return "main";
    }

    @GetMapping("/converter")
    public String getPage1() {
        return "converter";
    }

    @GetMapping("/calculator")
    public String getPage2() {
        return "calculator";
    }
}