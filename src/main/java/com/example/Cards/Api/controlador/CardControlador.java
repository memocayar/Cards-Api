package com.example.Cards.Api.controlador;

import com.example.Cards.Api.dto.CardDTO;
import com.example.Cards.Api.servicio.CardServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardControlador {

    @Autowired
    CardServicio cardServicio;

    @PostMapping
    public ResponseEntity<CardDTO> guardarCard(@RequestBody CardDTO cardDTO){
        return new ResponseEntity<>(cardServicio.crearCard(cardDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CardDTO> listarCards(){
        return cardServicio.listarCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDTO> obtenerPorId(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(cardServicio.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardDTO> actualizarCard(@RequestBody CardDTO cardDTO, @PathVariable(name = "id") long id){
        return new ResponseEntity<>(cardServicio.actualizarCard(cardDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCard(@PathVariable(name = "id") long id){
        cardServicio.eliminarCard(id);
        return new ResponseEntity<>("Card eliminada exitosamente", HttpStatus.OK);
    }
}
