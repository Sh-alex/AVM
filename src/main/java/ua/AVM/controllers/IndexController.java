package ua.AVM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.AVM.simplex.impl.SimplexMethod;


@Controller
public class IndexController {
    @Autowired
    private SimplexMethod simplexMethod;

    @RequestMapping(value = "/solveSimplex", method = RequestMethod.POST, headers = "Accept=application/json", produces = "application/json")
    @ResponseBody
    public SimplexMethod sendResult() {

        simplexMethod.createSimplexTable(4, 4);
        simplexMethod.solve();

        return simplexMethod;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public BadStatus sendNoSolution() {

        return new BadStatus("Задача розв'язку немає");
    }

}
