package com.example.yazlab21.service;

import com.example.yazlab21.model.Text;
import com.example.yazlab21.repository.TextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {



    // mongodbVSCodePlaygroundDB
    @Autowired
    private final TextRepository textRepository;
    @Override
    public List<Text> getAll() {
        return textRepository.findAll();
    }

    @Override
    public Text getById(int id) {
        return textRepository.findAll().get(id);
    }

    @Override
    public Text add(Text text) {

        return textRepository.save(text);
    }

    @Override
    public Text update(Text text) {
        return textRepository.save(text);
    }

    @Override
    public void delete(Text text) {
            textRepository.delete(text);
    }

    @Override
    public String sonucCumle(String[] cumleler) {
        TextMerge textMerge = new TextMerge();
        return textMerge.toString();
    }
}
