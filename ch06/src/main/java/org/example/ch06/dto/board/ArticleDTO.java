package org.example.ch06.dto.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class ArticleDTO {
    private int ano;
    private String title;
    private String content;
    private String writer;
    private int file;
    private String wdate;
}
