package com.example.tuwaiqlab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "[A-Za-z]+", message = "Name must contain letters only")
    @Column(nullable = false, length = 4)
    private String name;

    @Email
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false)
    private String password;

    @Min(21)
    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 10, columnDefinition = "varchar(10) check (role in ('JOB_SEEKER', 'EMPLOYER'))")
    private String role;


}
