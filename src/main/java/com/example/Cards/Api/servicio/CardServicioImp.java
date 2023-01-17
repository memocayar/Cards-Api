package com.example.Cards.Api.servicio;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.entidades.Card;
import com.example.Cards.Api.entidades.CardRepository;
import com.example.Cards.Api.excepciones.ResourceNotFoundException;
import com.example.Cards.Api.mapper.CardMapper;
import com.example.Cards.Api.repositorio.CardRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServicioImp implements CardServicio {

    @Autowired
    private CardRepositorio cardRepositorio;

    @Autowired
    private CardMapper cardMapper;
    @Autowired
    private CardRepository cardRepository;

    @Override
    public CardDTO crearCard(CardDTO cardDTO) {
        Card card = cardMapper.DTO2entity(cardDTO);
        cardRepositorio.save(card);

        return cardMapper.entity2DTO(card);
    }

    @Override
    public List<CardDTO> listarCards() {
        List<CardDTO> cardsDTO = cardMapper.listCard2ListDTO(cardRepository.findAll());
        return cardsDTO;
    }

    @Override
    public CardDTO obtenerPorId(long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", id));
        return cardMapper.entity2DTO(card);
    }

    @Override
    public CardDTO actualizarCard(CardDTO cardDTO, long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", id));

        card.setTitulo(cardDTO.getTitulo());
        card.setDescripcion(cardDTO.getDescripcion());
        cardRepository.save(card);

        return cardMapper.entity2DTO(card);
    }

    @Override
    public void eliminarCard(long id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "id", id));
        cardRepository.delete(card);
    }
}
