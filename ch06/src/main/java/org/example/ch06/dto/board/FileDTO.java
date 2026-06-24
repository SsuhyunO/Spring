package org.example.ch06.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FileDTO {
    private int fno;
    private int ano;
    private String ofname;
    private String sfname;
}
