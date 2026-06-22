package org.example.ch06.dto;

import lombok.*;
import org.example.ch06.entity.User3;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User3DTO {
    private String userid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

    public User3 toEntity(){
        return User3.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
