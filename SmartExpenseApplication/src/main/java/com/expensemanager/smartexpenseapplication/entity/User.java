package com.expensemanager.smartexpenseapplication.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is Mandatory")
    private String name;

    @NotNull(message = "mobile number is mandatory")
    @Column(unique = true)
    private Long mobile;

}
