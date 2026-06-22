package org.example.ch06.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.example.ch06.dto.User3DTO;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table
public class User3 {
    @Id
    private String userid;

    private String name;
    private String birth;
    private String hp;
    private String addr;

    public User3DTO toDTO(){
        return User3DTO.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
