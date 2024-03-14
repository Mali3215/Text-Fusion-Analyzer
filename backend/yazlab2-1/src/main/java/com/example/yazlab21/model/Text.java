package com.example.yazlab21.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Text")
public class Text {

    @Id
    int _id;

    String[] text;
    String conclusion;

    long elapsedTime;



}
