package org.example.ch08.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.example.ch08.dto.User1DTO;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
public class User1 {
    @Id
    private String userid;
    private String name;
    private String hp;
    private String birth;
    private int age;

    public User1DTO toDTO(){
        return User1DTO.builder()
                .userid(userid)
                .name(name)
                .hp(hp)
                .birth(birth)
                .age(age)
                .build();
    }
}
