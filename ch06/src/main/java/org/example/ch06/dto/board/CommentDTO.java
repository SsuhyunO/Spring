package org.example.ch06.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class CommentDTO {
    private int cno;
    private int parent;
    private String content;
    private String writer;
    private String wdate;
}
