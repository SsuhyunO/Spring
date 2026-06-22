package org.example.ch06.dto;

import lombok.*;
import org.example.ch06.entity.User2;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User2DTO {
    private String userid;
    private String name;
    private String birth;
    private String addr;

    // Entity 변환 메서드
    public User2 toEntity(){
        return User2.builder()
                .userid(userid)
                .name(name)
                .birth(birth)
                .addr(addr)
                .build();
    }
}
