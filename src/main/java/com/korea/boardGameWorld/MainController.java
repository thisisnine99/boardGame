package com.korea.boardGameWorld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String mainPage() {
        System.out.println("ㅎㅇ");
        return "main";
    }
}
