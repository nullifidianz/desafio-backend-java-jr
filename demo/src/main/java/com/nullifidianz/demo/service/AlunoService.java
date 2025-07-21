package com.nullifidianz.demo.service;
import com.nullifidianz.demo.domain.mapper.AlunoMapper;
import com.nullifidianz.demo.repository.AlunoRepository;

import jakarta.persistence.EntityNotFoundException;

import com.nullifidianz.demo.domain.dto.AlunoRequest;
import com.nullifidianz.demo.domain.dto.AlunoResponse;
import com.nullifidianz.demo.domain.dto.MatriculaDTO;
import com.nullifidianz.demo.domain.entity.Aluno;
import com.nullifidianz.demo.domain.entity.Matricula;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AlunoService {
    private final AlunoRepository repository;
    private final AlunoMapper mapper;
    public AlunoService(AlunoRepository repository, AlunoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public AlunoResponse cadastrarAluno(AlunoRequest request){
        Aluno aluno = mapper.toEntity(request);
        repository.save(aluno);
        return mapper.toResponse(aluno);
    }

    public List<AlunoResponse> listarTodos(AlunoResponse response){
        return repository.findAll().stream().map(mapper::toResponse).toList();
    }
    
    public List<MatriculaDTO> listarPorMatricula(Long id){
        Aluno aluno = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id não encontrado"));
        
       
        if (aluno.getMatriculas() != null) {
            return aluno.getMatriculas().stream().map(m-> new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio())).toList();
        } else {
            return List.of();
        }
    }
    
    public AlunoResponse atualizarAluno(Long id, AlunoRequest request){
        Aluno aluno = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Id não encontrado"));
        
        
        aluno.setNome(request.nome());
        aluno.setDataNascimento(request.dataNascimento());
        aluno.setTelefone(request.telefone());

        
        aluno.getMatriculas().clear();
        
        
        if (request.matriculas() != null) {
            for(MatriculaDTO m : request.matriculas()){
                Matricula matricula = new Matricula();
                matricula.setCodigoMatricula(m.codigoMatricula());
                matricula.setDataInicio(m.dataInicio());
                matricula.setNomeCurso(m.nomeCurso());
                matricula.setAluno(aluno);
                aluno.getMatriculas().add(matricula);
            }
        }

        repository.save(aluno);
        return mapper.toResponse(aluno);
    }
    
    public void removerAluno(Long id){
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Id não encontrado");
        }
        repository.deleteById(id);
    }

}
