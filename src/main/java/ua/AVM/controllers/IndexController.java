package ua.AVM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView goIndex() {
        String start = "Start!";

        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("start", start);
        modelAndView.setViewName("index");
        return modelAndView;*/
        return new ModelAndView("index", "start", start);
    }

}
