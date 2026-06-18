package org.example.ch05.service;

import lombok.RequiredArgsConstructor;
import org.example.ch05.dao.User4DAO;
import org.example.ch05.dto.User4DTO;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class User4Service {
    // 주입 대상 속성에 final 선언해서 RequiredArgsConstructor 어노테이션으로 객체 주입(중요!!!)
    private final User4DAO dao;

    // DAO 호출 메서드
    public void register(User4DTO dto){
        dao.insert(dto);
    }

    public User4DTO getById(String userid){
        return dao.select(userid);
    }

    public List<User4DTO> getAll(){
        return dao.selectAll();
    }

    public void modify(User4DTO dto){
        dao.update(dto);
    }

    public void remove(String userid){
        dao.delete(userid);
    }

}
