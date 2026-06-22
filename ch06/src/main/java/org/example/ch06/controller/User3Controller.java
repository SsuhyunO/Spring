package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.Service.User3Service;
import org.example.ch06.dto.User3DTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class User3Controller {
    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model){
        List<User3DTO> dtoList = service.getAll();

        model.addAttribute("dtoList", dtoList);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){
        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO dto){
        log.info(dto.toString());

        service.register(dto);

        return "redirect:/user3/list?register=success";
    }

    @GetMapping("/user3/modify")
    public String modify(Model model, String userid) {
        User3DTO dto = service.getUserById(userid);

        model.addAttribute("dto", dto);

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO dto){
        log.info(dto.toString());

        service.modify(dto);

        return "redirect:/user3/list?modify=success";
    }

    @GetMapping("/user3/remove")
    public String remove(String userid){
        log.info(userid);

        service.remove(userid);

        return "redirect:/user3/list?remove=success";
    }
}
