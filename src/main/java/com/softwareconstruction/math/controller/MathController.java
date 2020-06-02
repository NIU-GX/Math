package com.softwareconstruction.math.controller;

import com.google.gson.Gson;
import com.softwareconstruction.math.entity.Calculation;
import com.softwareconstruction.math.utils.Generator;
import com.softwareconstruction.math.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author NGX
 * @Date 2020/5/16 11:14
 */
@RestController
public class MathController {

    @Autowired
    Generator calculation;

    @RequestMapping("/add")
    public Result getAddCals() {
        List<Calculation> addCals = calculation.createAddCals();
        Gson gson = new Gson();
        String s = gson.toJson(addCals);
        System.out.println(s);
        return Result.successWithData(s);
    }

    @RequestMapping("/sub")
    public Result getSubCals() {
        List<Calculation> subCals = calculation.createSubCals();
        Gson gson = new Gson();
        String s = gson.toJson(subCals);
        System.out.println(s);
        return Result.successWithData(s);
    }

    @RequestMapping("/random")
    public Result getRandomCals() {
        List<Calculation> randomCals = calculation.createRandomCals();
        Gson gson = new Gson();
        String s = gson.toJson(randomCals);
        System.out.println(s);
        return Result.successWithData(s);
    }
}
