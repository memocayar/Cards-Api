package com.example.Cards.Api.servicio;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.entidades.Card;
import com.example.Cards.Api.mapper.CardMapper;
import com.example.Cards.Api.repositorio.CardRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class CardServiceImp implements CardService {

    @Autowired
    private CardRepositorio cardRepositorio;

    @Autowired
    private CardMapper cardMapper;

    @Override
    public CardDTO crearCard(CardDTO cardDTO) {
        Card card = cardMapper.DTO2entity(cardDTO);
        cardRepositorio.save(card);

        return cardMapper.entity2DTO(card);
    }
}
