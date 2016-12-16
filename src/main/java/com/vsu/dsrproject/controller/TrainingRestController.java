package com.vsu.dsrproject.controller;


import com.vsu.dsrproject.dto.TrainingDto;
import com.vsu.dsrproject.dto.TrainingNameDto;
import com.vsu.dsrproject.entity.Training;
import com.vsu.dsrproject.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class TrainingRestController {


    @Autowired
    private TrainingService trainingService;

    @RequestMapping(value = "/random", method = RequestMethod.POST)
    @ResponseBody
    public Training randomTraining() {
        return trainingService.getRandomTraining();
    }

    @RequestMapping(value = "/hard", method = RequestMethod.POST)
    @ResponseBody
    public Training hardTraining() {
        return trainingService.getHardTraining();
    }


    @RequestMapping(value = "/update",
            method = RequestMethod.PUT)
    @ResponseBody
    public Training updateTraining(@RequestBody TrainingDto training) {
        return trainingService.update(training);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Training createTraining(@RequestBody TrainingNameDto dto) {
        return trainingService.create(dto);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.POST)
    @ResponseBody
    public List<Training> getAllTrainings() {
        return trainingService.getAll();
    }

    @RequestMapping(value = "/getlist", method = RequestMethod.POST)
    @ResponseBody
    public List<Training> getListTrainings() {
        return trainingService.getAllCustomTrainings();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Training getCustomTraining(@PathVariable Long id) {
        return trainingService.getOneCustomTraining(id);
    }
}
