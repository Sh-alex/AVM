package ua.AVM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.AVM.simplex.impl.SimplexMethod;


@Controller
public class IndexController {
    @Autowired
    private SimplexMethod simplexMethod;

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String goIndex() {

        return  "index";
    }

    @RequestMapping(value = "/solveSimplex", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public SimplexMethod sendResult(@RequestBody DataSimplex dataSimplex) {

        simplexMethod.createSimplexTable(dataSimplex.getA(), dataSimplex.getB(), dataSimplex.getC(),
                dataSimplex.getOptCriterion(), dataSimplex.getInequalityTypes(), dataSimplex.getC().size(), dataSimplex.getA().size());
        simplexMethod.solve();

        return simplexMethod;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public BadStatus sendNoSolution() {

        return new BadStatus("Задача розв'язку немає");
    }

}
