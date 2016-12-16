package com.vsu.dsrproject.controller;

import com.vsu.dsrproject.dto.TrainingNameDto;
import com.vsu.dsrproject.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Pavel on 14.12.2016.
 */
@Controller
@RequestMapping("/training")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "/random", method = GET)
    public String trainingRandom(ModelMap modelMap) {
        return "training/training";
    }

    @RequestMapping(value = "/hard", method = GET)
    public String trainingHard(ModelMap modelMap) {
        return "training/training";
    }

    @RequestMapping(value = "/new", method = GET)
    public String newTraining(ModelMap modelMap) {
        return "training/new";
    }

    @RequestMapping(value = "/choose", method = GET)
    public String chooseTraining(ModelMap modelMap) {
        return "training/choose";
    }

    @RequestMapping(value = "/custom", method = GET)
    public String startTraining(@RequestParam String trainingSelect) {
        System.out.println(trainingSelect);
        return "training/training";
    }

//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    public String createTraining(@RequestBody TrainingNameDto dto) {
//        System.out.println(trainingService.create(dto));
//        return "training/choose";
//    }
}
