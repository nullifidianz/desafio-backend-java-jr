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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/v1")
@Tag(name = "Alunos", description = "API para gerenciamento de alunos")
public class AlunoController {
    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }
    
    @PostMapping
    @RequestMapping("/alunos")
    @Operation(summary = "Cadastrar novo aluno", description = "Cria um novo registro de aluno no sistema")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Aluno criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<AlunoResponse> cadastrarAluno(@RequestBody AlunoRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarAluno(request));
    }

    @GetMapping
    @RequestMapping("/alunos")
    @Operation(summary = "Listar todos os alunos", description = "Retorna uma lista com todos os alunos cadastrados")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso"),
        @ApiResponse(responseCode = "204", description = "Nenhum aluno encontrado")
    })
    public ResponseEntity<List<AlunoResponse>> verTodos (){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.listarTodos(null));
    }

    @PutMapping
    @RequestMapping("alunos/{id}")
    @Operation(summary = "Atualizar aluno", description = "Atualiza os dados de um aluno existente pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Aluno atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    public ResponseEntity<AlunoResponse> atualizarAluno (@PathVariable Long id, @RequestBody AlunoRequest request){
        return ResponseEntity.ok(service.atualizarAluno(id, request));
    }

    @DeleteMapping
    @RequestMapping("/alunos/{id}")
    @Operation(summary = "Deletar aluno", description = "Remove um aluno do sistema pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Aluno removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Aluno não encontrado")
    })
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        service.removerAluno(id);
        return ResponseEntity.noContent().build();
    }

}
