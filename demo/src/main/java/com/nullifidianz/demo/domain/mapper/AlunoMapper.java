package com.nullifidianz.demo.domain.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import com.nullifidianz.demo.domain.dto.AlunoRequest;
import com.nullifidianz.demo.domain.dto.MatriculaDTO;
import com.nullifidianz.demo.domain.entity.Matricula;
import com.nullifidianz.demo.domain.entity.Aluno;
import com.nullifidianz.demo.domain.dto.AlunoResponse;

@Component
public class AlunoMapper {
    public Aluno toEntity(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setNome(request.nome());
        aluno.setTelefone(request.telefone());
        aluno.setDataNascimento(request.dataNascimento());
        List<Matricula> matriculas = request.matriculas().stream().map(m->{
            Matricula matricula = new Matricula();
            matricula.setCodigoMatricula(m.codigoMatricula());
            matricula.setNomeCurso(m.nomeCurso());
            matricula.setDataInicio(m.dataInicio());
            matricula.setAluno(aluno);
            return matricula;}).toList();
        aluno.setMatriculas(matriculas);
        return aluno;
    }


    public AlunoResponse toResponse(Aluno aluno){
        List<MatriculaDTO> matriculas = aluno.getMatriculas().stream().map(m->{
            MatriculaDTO matriculaDTO = new MatriculaDTO(m.getCodigoMatricula(), m.getNomeCurso(), m.getDataInicio());
            return matriculaDTO;
        }).toList();
        return new AlunoResponse(aluno.getId(), aluno.getNome(), aluno.getTelefone(), aluno.getDataNascimento(), matriculas);
    }
}
