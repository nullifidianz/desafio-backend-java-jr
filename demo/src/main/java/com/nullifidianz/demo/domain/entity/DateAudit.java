package com.nullifidianz.demo.domain.entity;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
public abstract class DateAudit {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataInclusao;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime dataAtualizacao;

}
