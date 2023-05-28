package com.example.springboot.service;


import com.example.springboot.persistence.entity.NoteEntity;
import com.example.springboot.persistence.repository.NoteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
@RequiredArgsConstructor

public class NoteService {
    private NoteRepository noteRepository;

    public NoteEntity create(NoteEntity noteEntity) {
        return this.noteRepository.save(noteEntity);
    }

    public Optional<NoteEntity> findById(Integer id) {
        return this.noteRepository.findById(id);
    }

    public List<NoteEntity> findAll() {
        return this.noteRepository.findAll();
    }

    public void deleteById(Integer id) {
        this.noteRepository.deleteById(id);
    }

    public void update(NoteEntity noteEntity, NoteEntity newNoteEntity) {
        newNoteEntity.setName(newNoteEntity.getName());
        noteEntity.setContent(newNoteEntity.getContent());
        noteEntity.setCreatedAt(newNoteEntity.getCreatedAt());
        noteRepository.save(noteEntity);
    }

    public List<NoteEntity> searchByDate(Date start, Date end) {
        return noteRepository.findByCreatedAtBetweenOrderByCreatedAt(start, end);
    }

    public List<NoteEntity> search(String name, String message) {
        return this.noteRepository.findByNameContainingOrContentContaining(name, message);
    }
}

