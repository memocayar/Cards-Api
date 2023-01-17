package com.example.Cards.Api.servicio;

import com.example.Cards.Api.dto.CardDTO;

import java.util.List;

public interface CardServicio {

    public CardDTO crearCard(CardDTO cardDTO);

    public List<CardDTO> listarCards();

    public CardDTO obtenerPorId(long id);

    public CardDTO actualizarCard(CardDTO cardDTO, long id);

    public void eliminarCard(long id);
}
