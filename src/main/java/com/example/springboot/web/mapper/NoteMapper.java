package com.example.springboot.web.mapper;


import com.example.springboot.model.NoteDto;
import com.example.springboot.persistence.entity.NoteEntity;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class NoteMapper {
    public NoteEntity map(NoteDto noteDto) {
        return NoteEntity.builder()
                .name(noteDto.getName())
                .content(noteDto.getContent())
                .createdAt((noteDto.getCreatedAt()))
                .build();
    }

    public NoteDto map(NoteEntity noteEntity) {
        return NoteDto.builder()
                .name(noteEntity.getName())
                .content(noteEntity.getContent())
                .createdAt(noteEntity.getCreatedAt())
                .build();
    }
    public Date mapDate(Long date){
        return new Date(date);
    }
}