package org.example.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User2DTO;

@NoArgsConstructor
@ToString
@AllArgsConstructor
@Getter
@Builder
@Table
@Entity
public class User2 {
    @Id
    private String userid;
    private String name;
    private String birth;
    private String addr;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
