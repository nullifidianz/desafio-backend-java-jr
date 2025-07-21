package com.nullifidianz.demo.domain.entity;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;

    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Matricula> matriculas = new ArrayList<>();
}
