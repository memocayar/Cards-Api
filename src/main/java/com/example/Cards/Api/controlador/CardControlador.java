package com.example.Cards.Api.controlador;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.servicio.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cards")
public class CardControlador {

    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<CardDTO> guardarCard(@RequestBody CardDTO cardDTO){
        return new ResponseEntity<>(cardService.crearCard(cardDTO), HttpStatus.CREATED);
    }

}
