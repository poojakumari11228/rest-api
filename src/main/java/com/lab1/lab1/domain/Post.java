package com.lab1.lab1.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    long id;
    String title;
    String content;
    String author;

}

