package com.example.springboot.persistence.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity {
    @Id
    private Integer id;
    private String name;
    private String content;
    @Column("createdAt")
    private Date createdAt;
}