package pl.koneckimarcin.mybodymanagement.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstPageController {

    @GetMapping("/")
    public String goToFirstPage(){

        return "firstPage";
    }
}
