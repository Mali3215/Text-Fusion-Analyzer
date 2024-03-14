package com.example.yazlab21.controller;

import com.example.yazlab21.model.TempText;
import com.example.yazlab21.model.Text;
import com.example.yazlab21.service.TextMerge;
import com.example.yazlab21.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class TextController {
    float time;
    @Autowired
    private final TextService textService;

    @GetMapping("/all")
    public List<Text> get(){
        return textService.getAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody String[] textArray) {
        Text text = new Text();
        text.setText(textArray);
        text.set_id(textService.getAll().size()+1);
        long startTime = System.nanoTime();
        text.setConclusion(TextMerge.birlestir(text.getText()));
        long endTime = System.nanoTime();
        text.setElapsedTime(endTime-startTime);
        textService.add(text);
    }
    @PostMapping("/update")
    public void update(@RequestBody Text text){

        textService.update(text);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody Text text){

        textService.delete(text);
    }
    @GetMapping("/{id}")
    public Text getById(@PathVariable int id){

        return textService.getById(id);

    }

    @PostMapping("/cumle")
    public TempText getCumle(@RequestBody String[] text) {
        long startTime = System.nanoTime();
        String mergedText = TextMerge.tekillestir(TextMerge.birlestir(text));
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        return new TempText(mergedText, elapsedTime);
    }




}
