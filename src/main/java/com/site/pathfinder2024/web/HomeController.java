package com.site.pathfinder2024.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

/**
 *  DOc
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        double sofiatemp = new Random().nextDouble();

//
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("sofiatemp",sofiatemp);

        model.addAttribute("sofiatemp", sofiatemp);
        return "index";
    }

}
