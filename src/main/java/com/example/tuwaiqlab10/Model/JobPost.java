package com.example.tuwaiqlab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 100, message = "Title must be between 5 and 100 characters")
    @Column(nullable = false, length = 100,
            columnDefinition = "varchar(100) not null check (char_length(trim(title)) >= 5)")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Column(nullable = false, length = 1000,
            columnDefinition = "varchar(1000) not null check (char_length(trim(description)) > 0)")
    private String description;

    @NotBlank(message = "Location is required")
    @Size(max = 255, message = "Location must not exceed 255 characters")
    @Column(nullable = false, length = 255,
            columnDefinition = "varchar(255) not null check (char_length(trim(location)) > 0)")
    private String location;

    @NotNull(message = "Salary is required")
    @PositiveOrZero(message = "Salary must be zero or greater")
    @Column(nullable = false, columnDefinition = "int not null check (salary >= 0)")
    private Integer salary;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date postingDate;
}
