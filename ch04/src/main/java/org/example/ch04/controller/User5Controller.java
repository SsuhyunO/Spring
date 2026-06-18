package org.example.ch04.controller;

import lombok.RequiredArgsConstructor;
import org.example.ch04.dto.User5DTO;
import org.example.ch04.service.User5Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class User5Controller {
    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor 어노테이션으로 객체 주입(중요!!!)
    private final User5Service service;

    @GetMapping("/user5/list")
    public String list(Model model){

        // 조회 서비스 요청
        List<User5DTO> dtoList = service.getAll();

        // 모델참조: 뷰(html)에서 컨트롤러 데이터 참조
        model.addAttribute("dtoList", dtoList);

        return "/user5/list";
    }

    @GetMapping("/user5/register")
    public String register(){

        return "/user5/register";
    }

    @PostMapping("/user5/register")
    public String register(User5DTO dto){
        System.out.println(dto);

        // 등록 서비스 호출
        service.register(dto);

        return "redirect:/user5/list?register=success";
    }

    @GetMapping("/user5/modify")
    public String modify(int seq, Model model){
        User5DTO dto = service.getBySeq(seq);

        model.addAttribute(dto); // 키값 생략하면 해당 객체 소문자로 시작하는 타입명
        // model.addAttribute("user5DTO, dto);

        return "/user5/modify";
    }

    @PostMapping("/user5/modify")
    public String modify(User5DTO dto){
        System.out.println(dto);

        service.modify(dto);

        return "redirect:/user5/list?modify=success";
    }

    @GetMapping("/user5/delete")
    public String remove(int seq){
        service.remove(seq);

        return "redirect:/user5/list?remove=success";
    }
}
