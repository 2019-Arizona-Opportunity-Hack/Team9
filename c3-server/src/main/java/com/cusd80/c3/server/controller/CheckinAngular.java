package com.cusd80.c3.server.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckinAngular {

    @RequestMapping("/c3-checkin")
    public String welcome(Map<String, Object> model) {
        return "c3-checkin/index-prod.html";
    }

}
