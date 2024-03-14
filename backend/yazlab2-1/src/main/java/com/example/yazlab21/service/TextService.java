package com.example.yazlab21.service;

import com.example.yazlab21.model.Text;
import com.example.yazlab21.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TextService {



    List<Text> getAll();

    Text getById(int id);
    Text add(Text text);

    Text update(Text text);

    void delete(Text text );

    String sonucCumle(String[] cumleler);
}
