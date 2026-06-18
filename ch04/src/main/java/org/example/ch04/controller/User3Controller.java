package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User3DTO;
import org.example.ch04.service.User3Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User3Controller {
    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor 어노테이션으로 객체 주입(중요!!!)
    private final User3Service service;

    @GetMapping("/user3/list")
    public String list(Model model){

        // 조회 서비스 요청
        List<User3DTO> dtoList = service.getAll();

        // 모델참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user3/list";
    }

    @GetMapping("/user3/register")
    public String register(){

        return "/user3/register";
    }

    @PostMapping("/user3/register")
    public String register(User3DTO dto){
        System.out.println(dto);

        // 등록 서비스 호출
        service.register(dto);

        return "redirect:/user3/list?register=success";
    }

    @GetMapping("/user3/modify")
    public String modify(String userid, Model model){
        User3DTO dto = service.getById(userid);

        model.addAttribute(dto); // 키값 생략하면 해당 객체 소문자로 시작하는 타입명
        // model.addAttribute("user3DTO, dto);

        return "/user3/modify";
    }

    @PostMapping("/user3/modify")
    public String modify(User3DTO dto){
        System.out.println(dto);

        service.modify(dto);

        return "redirect:/user3/list?modify=success";
    }

    @GetMapping("/user3/delete")
    public String remove(String userid){
        service.remove(userid);

        return "redirect:/user3/list?remove=success";
    }
}
