package atsea;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

    @RequestMapping("/health")
    @ResponseBody
    public String greeting(Model model) {
        //TODO: query database
        return "OK";
    }

}