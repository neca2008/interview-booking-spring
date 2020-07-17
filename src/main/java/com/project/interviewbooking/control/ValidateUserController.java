package com.project.interviewbooking.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/basicAuth")
public class ValidateUserController {

    @RequestMapping("validate")
    public String userIsValid() {
        return "{\"reuslt\" : \"ok\"}";
    }
}
