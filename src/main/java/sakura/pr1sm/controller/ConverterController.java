package sakura.pr1sm.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sakura.pr1sm.service.APIService; // Make sure this is your service class for currency rates

@Controller
@RequestMapping("/")
public class ConverterController {

    private final APIService apiService;

    public ConverterController(APIService apiService) {
        this.apiService = apiService;
    }

    @PostMapping("/convert")
    public String convert(
            @RequestParam(name = "val1") double val1,
            @RequestParam(name = "currentVal") String currentVal,
            @RequestParam(name = "convertingval") String convertingval,
            Model model) {

        Double currentRate = apiService.getExchangeRate(currentVal);
        Double convertingRate = apiService.getExchangeRate(convertingval);

        if (currentRate != null && convertingRate != null) {
            double result = (val1 / currentRate * convertingRate);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Unable to retrieve exchange rates.");
        }

        return "result";
    }
}