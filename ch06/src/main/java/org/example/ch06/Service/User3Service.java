package org.example.ch06.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.ch06.dto.User3DTO;
import org.example.ch06.entity.User3;
import org.example.ch06.repository.User3Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class User3Service {
    private final User3Repository repository;

    public void register(User3DTO dto){
        repository.save(dto.toEntity());
    };

    public User3DTO getUserById(String userid){
        Optional<User3> optEntity = repository.findById(userid);

        if(optEntity.isPresent()){
            return optEntity.get().toDTO();
        }

        return null;
    };

    public List<User3DTO> getAll(){
        List<User3> entityList = repository.findAll();

        return entityList.stream()
                .map(user3 -> user3.toDTO())
                .toList();

    };

    public void modify(User3DTO dto){
        repository.save(dto.toEntity());
    };

    public void remove(String userid){
        repository.deleteById(userid);
    };

}
