package com.example.gestion_de_stock.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant creationDate;
    @LastModifiedDate
    private Instant lastModifiedDate;
//    @PrePersist
//    void prePersist(){
//        creationDate=Instant.now();
//        lastModifiedDate=Instant.now();
//    }
//    @PreUpdate
//    void preUpdate(){
//        lastModifiedDate=Instant.now();
//    }
}
