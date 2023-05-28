package com.example.springboot.persistence.repository;

import com.example.springboot.persistence.entity.NoteEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;


@Repository
public interface NoteRepository extends ListCrudRepository<NoteEntity, Integer> {

    List<NoteEntity> findByCreatedAtBetweenOrderByCreatedAt(Date start, Date end);

    List<NoteEntity> findByNameContainingOrContentContaining(String name, String message);

   }

