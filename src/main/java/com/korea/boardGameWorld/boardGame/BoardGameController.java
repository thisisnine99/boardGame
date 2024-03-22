package com.korea.boardGameWorld.boardGame;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boardGame")
@RequiredArgsConstructor
public class BoardGameController {

    private final BoardGameService boardGameService;

    @GetMapping("/list")
    public String list() {
        boardGameService.gogo(1);
        return "redirect:/";
    }
}
