package com.nullifidianz.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nullifidianz.demo.domain.dto.AlunoRequest;
import com.nullifidianz.demo.domain.dto.AlunoResponse;
import com.nullifidianz.demo.service.AlunoService;


@RestController
@RequestMapping("/api/v1")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }
    
    @PostMapping
    @RequestMapping("/alunos")
    public ResponseEntity<AlunoResponse> cadastrarAluno(@RequestBody AlunoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(request));
    }

    @GetMapping
    @RequestMapping("/alunos")
    public ResponseEntity<List<AlunoResponse>> verTodos (){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.listarTodos(null));
    }

    @PutMapping
    @RequestMapping("alunos/{id}")
    public ResponseEntity<AlunoResponse> atualizarAluno (@PathVariable Long id, @RequestBody AlunoRequest request){
        return ResponseEntity.ok(service.atualizarAluno(id, request));

        
    }

    @DeleteMapping
    @RequestMapping("/alunos/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        service.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

}
