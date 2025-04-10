package com.sai.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@MappedSuperclass    // Telling all atrbutes of class shhould be interhited to its child classes to the ORM layer
@Getter
@Service
public class BaseModel {
    @Id  // Telling this to patricular thing is a id
    @GeneratedValue(generator = "uuidgenerator")        // Name can be anything.
    @GenericGenerator(name = "uuidgenerator", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;
}
