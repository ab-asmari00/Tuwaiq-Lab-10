package com.example.tuwaiqlab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name is required")
    @Size(max = 4, message = "Name must not exceed 4 characters")
    @Pattern(regexp = "[A-Za-z]+", message = "Name must contain letters only")
    @Column(nullable = false, length = 4,
            columnDefinition = "varchar(4) not null check (name regexp '^[A-Za-z]+$')")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    @Size(max = 50, message = "Email must not exceed 50 characters")
    @Column(nullable = false, unique = true, length = 50,
            columnDefinition = "varchar(50) not null check (email regexp '^[^@[:space:]]+@[^@[:space:]]+\\.[^@[:space:]]+$')")
    private String email;

    @NotBlank(message = "Password is required")
    @Column(nullable = false, columnDefinition = "varchar(255) not null check (char_length(trim(password)) > 0)")
    private String password;

    @NotNull(message = "Age is required")
    @Min(value = 21, message = "Age must be at least 21")
    @Column(nullable = false, columnDefinition = "int not null check (age >= 21)")
    private Integer age;

    @NotBlank(message = "Role is required")
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$",
            message = "Role must be JOB_SEEKER or EMPLOYER")
    @Column(nullable = false, length = 10,
            columnDefinition = "varchar(10) not null check (role in ('JOB_SEEKER', 'EMPLOYER'))")
    private String role;


}
