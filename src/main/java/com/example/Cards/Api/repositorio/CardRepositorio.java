package com.example.Cards.Api.repositorio;

import com.example.Cards.Api.entidades.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepositorio extends JpaRepository<Card, Long> {
}
