package com.example.Cards.Api.mapper;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.entidades.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CardMapper {

    public Card DTO2entity(CardDTO cardDTO){
        Card card = new Card();
        card.setTitulo(cardDTO.getTitulo());
        card.setDescripcion(cardDTO.getDescripcion());

        return card;
    }

    public CardDTO entity2DTO(Card card){
        CardDTO dto = new CardDTO();
        dto.setId(card.getId());
        dto.setTitulo(card.getTitulo());
        dto.setDescripcion(card.getDescripcion());

        return dto;
    }

    public List<CardDTO> listCard2ListDTO(List<Card> cards){
        List<CardDTO> listDTO = new ArrayList<>();

        for(Card card : cards){
            listDTO.add(entity2DTO(card));
        }

        return listDTO;
    }
}
