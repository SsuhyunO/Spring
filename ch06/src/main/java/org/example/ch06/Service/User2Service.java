package org.example.ch06.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User2DTO;
import org.example.ch06.entity.User2;
import org.example.ch06.repository.User2Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class User2Service {
    private final User2Repository repository;

    public void register(User2DTO dto){
        repository.save(dto.toEntity());
    };

    public User2DTO getUserById(String userid){
        Optional<User2> user2 = repository.findById(userid);

        if(user2.isPresent()){
            return user2.get().toDTO();
        }

        return null;
    };

    public List<User2DTO> getUserAll(){
        List<User2> userList = repository.findAll();

        List<User2DTO> dtoList = userList.stream()
                                        .map(user2 -> user2.toDTO())
                                        .toList();

        return dtoList;
    };

    public void modify(User2DTO dto){
        repository.save(dto.toEntity());
    };

    public void remove(String userid){
        log.info(userid);

        repository.deleteById(userid);
    };
}
