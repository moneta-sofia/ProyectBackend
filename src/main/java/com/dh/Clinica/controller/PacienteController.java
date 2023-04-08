package com.dh.Clinica.controller;

import com.dh.Clinica.dto.PacienteDTO;
import com.dh.Clinica.exceptions.BadRequestException;
import com.dh.Clinica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> guardarPacientes(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.guardarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO buscarPaciente(@PathVariable Long id) {
        return pacienteService.buscarPaciente(id);
    }

    @GetMapping("/list")
    public Collection<?> listarPacientes(){
        return pacienteService.buscarPacientes();
    }

    @PutMapping
    public ResponseEntity<?> actualizarPaciente(@RequestBody PacienteDTO pacienteDTO) throws BadRequestException {
        pacienteService.actualizarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id){
        pacienteService.eliminarPaciente(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<String> errores(BadRequestException badRequest){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequest.getMessage());
    }



}
