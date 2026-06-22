package org.example.ch06.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.Service.User2Service;
import org.example.ch06.dto.User2DTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class User2Controller {
    private final User2Service service;

    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> dtoList = service.getUserAll();

        model.addAttribute("dtoList", dtoList);
        log.info(dtoList.toString());

        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){

        return "user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO dto){
        service.register(dto);

        return "redirect:/user2/list?register=success";
    }

    @GetMapping("/user2/modify")
    public String modify(Model model, String userid){
        User2DTO dto = service.getUserById(userid);

        model.addAttribute("dto", dto);

        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO dto){
        service.modify(dto);

        return "redirect:/user2/list?modify=succsss";
    }

    @GetMapping("/user2/remove")
    public String remove(String userid){
        log.info(userid);

        service.remove(userid);

        return "redirect:/user2/list?remove=success";
    }

}
