package org.pbe.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;

    // Getters and Setters
    // mas não precisa, porque o Lombok já gerou !
}
