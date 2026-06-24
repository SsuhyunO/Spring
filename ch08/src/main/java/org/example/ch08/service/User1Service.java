package org.example.ch08.service;

import lombok.RequiredArgsConstructor;
import org.example.ch08.dto.User1DTO;
import org.example.ch08.entity.User1;
import org.example.ch08.repository.User1Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {
    private final User1Repository repository;

    public User1DTO getUser(String userid){
        Optional<User1> optUser1 = repository.findById(userid);

        if(optUser1.isPresent()){
            return optUser1.get().toDTO();
        }

        return null;
    };

    public List<User1DTO> getUserAll(){
        List<User1> user1List = repository.findAll();
        return user1List.stream().map(user1 -> user1.toDTO()).toList();

    };

    public User1DTO register(User1DTO dto){
        User1 savedEntity = repository.save(dto.toEntity());
        return savedEntity.toDTO();
    };

    public User1DTO modify(User1DTO dto){
        if(repository.existsById(dto.getUserid())){
            User1 modifiedUser1 = repository.save(dto.toEntity());
            return modifiedUser1.toDTO();
        }
        return null;
    };

    public boolean remove(String userid){
        if(repository.existsById(userid)){
            repository.deleteById(userid);
            return true;
        }
        return false;
    };

}