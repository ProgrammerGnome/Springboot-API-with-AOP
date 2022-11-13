package com.jetbrains.kmark7.storages.clone.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainPage_fakeController {
    @GetMapping("/")
    public ModelAndView MainPage_fakeController_func() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("MainPage.html");
        return modelAndView;
    }
}
