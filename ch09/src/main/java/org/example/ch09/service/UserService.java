package org.example.ch09.service;

import lombok.RequiredArgsConstructor;
import org.example.ch09.dto.UserDTO;
import org.example.ch09.entity.User;
import org.example.ch09.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO getUser(String userid){
        Optional<User> optUser = repository.findById(userid);

        if(optUser.isPresent()){
            return optUser.get().toDTO();
        }

        return null;
    };

    public List<UserDTO> getUserAll(){
        List<User> userList = repository.findAll();
        return userList.stream().map(user -> user.toDTO()).toList();

    };

    public UserDTO register(UserDTO dto){
        // 비밀번호 암호화
        String encoded = passwordEncoder.encode(dto.getPass());
        dto.setPass(encoded);

        User savedUser = repository.save(dto.toEntity());
        return savedUser.toDTO();
    };

    public UserDTO modify(UserDTO dto){
        if(repository.existsById(dto.getUserid())){
            User modifiedUser = repository.save(dto.toEntity());
            return modifiedUser.toDTO();
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