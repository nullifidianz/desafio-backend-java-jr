package com.nullifidianz.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nullifidianz.demo.domain.entity.Matricula;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

}
