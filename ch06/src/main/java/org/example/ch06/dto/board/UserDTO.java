package org.example.ch06.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDTO {
    private String userid;
    private String name;
    private String birth;
    private String rdate;
}
