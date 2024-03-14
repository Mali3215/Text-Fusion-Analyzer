package com.example.yazlab21.repository;

import com.example.yazlab21.model.Text;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextRepository extends MongoRepository<Text,Integer> {

}