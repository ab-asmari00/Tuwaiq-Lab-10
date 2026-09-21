package com.example.tuwaiqlab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "Title is required")
    @Size(min = 5, message = "Title must contain more than 4 characters")
    @Column(nullable = false, columnDefinition = "varchar(100) check (char_length(title) > 4)")
    private String title;

    @NotEmpty
    @Column(nullable = false)
    private String description;

    @NotEmpty
    @Column(nullable = false)
    private String location;

    @PositiveOrZero
    @Column(nullable = false)
    private Integer salary;

    @CreationTimestamp
    private Date postingDate;
}
