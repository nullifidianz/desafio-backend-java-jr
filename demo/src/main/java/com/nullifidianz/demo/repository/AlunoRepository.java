package com.nullifidianz.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nullifidianz.demo.domain.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
