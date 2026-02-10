package com.learning.BookStore.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Book name is required")
    @Size(min = 2, max = 100, message = "Book name must be 2-100 chars")
    private String name;

    @NotBlank(message = "Author is required")
    @Size(min = 2, max = 100, message = "Author must be 2-100 chars")
    private String author;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must be >= 1")
    private String price;
}