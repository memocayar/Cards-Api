package com.example.Cards.Api.controlador;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.servicio.CardServicioImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardControlador {

    @Autowired
    CardServicioImp cardServicioImp;

    @PostMapping
    public ResponseEntity<CardDTO> guardarCard(@RequestBody CardDTO cardDTO){
        return new ResponseEntity<>(cardServicioImp.crearCard(cardDTO), HttpStatus.CREATED);
    }

}
