package com.thp.springmvc.controller;

import com.thp.springmvc.entity.Moussaillon;
import com.thp.springmvc.service.MoussaillonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MoussaillonController {
    @Autowired
    MoussaillonService moussaillonService;

    @GetMapping(value = "/")
    public String welcome(ModelMap modelMap) {
        modelMap.addAttribute("message", "Bienvenue Moussaillon ! ;)");
        return "hello";
    }

    @GetMapping(value = "/moussaillons")
    public String getAllMoussaillon(ModelMap model) {
        Moussaillon[] moussaillonList = moussaillonService.findAllMoussaillons();
        model.addAttribute("moussaillons", moussaillonList);
        return "moussaillons";
    }
}
