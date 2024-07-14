package com.mr3nz1.productManagementSystem.models;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("category")
public class Category {
    @Id
    private UUID id;
    @Field(name = "name")
    @Indexed(unique = true)
    private String categoryName;
}
