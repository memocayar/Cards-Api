package com.example.Cards.Api.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cards", uniqueConstraints = {@UniqueConstraint(columnNames = {"titulo"})})
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}
