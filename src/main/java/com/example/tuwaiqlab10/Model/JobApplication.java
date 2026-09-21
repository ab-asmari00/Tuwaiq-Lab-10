package com.example.tuwaiqlab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "User ID is required")
    @Column(nullable = false, columnDefinition = "int not null")
    private Integer userId;

    @NotNull(message = "Job post ID is required")
    @Column(nullable = false, columnDefinition = "int not null")
    private Integer jobPostId;

}
