package com.dh.Clinica.controller;

import com.dh.Clinica.dto.OdontologoDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.hibernate.query.results.Builders.entity;

@RestController
@CrossOrigin
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?>  guardarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.guardarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO buscarOdontologo(@PathVariable Long id){
        return odontologoService.buscarOdontologo(id);
    }


    @GetMapping("/list")
    public Collection<?> listarOdontologos(){
        return odontologoService.buscarOdontologos();
    }

    @PutMapping
    public ResponseEntity<?>  actualizarOdontologo(@RequestBody OdontologoDTO odontologoDTO) throws BadRequestException {
        odontologoService.actualizarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id){
        odontologoService.eliminarOdontologo(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> errores(BadRequestException badRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequest.getMessage());
    }

}
