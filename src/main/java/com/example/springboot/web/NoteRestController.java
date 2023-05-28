package com.example.springboot.web;

import com.example.springboot.model.NoteDto;
import com.example.springboot.persistence.entity.NoteEntity;
import com.example.springboot.service.NoteService;
import com.example.springboot.web.mapper.NoteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/note")
@RequiredArgsConstructor

public class NoteRestController {
    private final NoteMapper noteMapper;
    private final NoteService noteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NoteEntity insert(@RequestBody NoteDto dto) {
        NoteEntity noteEntity = noteMapper.map(dto);
        return noteService.create(noteEntity);
    }

    @GetMapping("/test")
    public String getAll() {
        return "test";
    }

    @GetMapping("/{id}")
    public NoteDto getById(@PathVariable Integer id) {
        NoteEntity noteEntity = noteService.findById(id).orElseThrow();
        return noteMapper.map(noteEntity);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        noteService.deleteById(id);
    }

    @GetMapping("/allnotes")
    public List<NoteEntity> findALL() {
        return noteService.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody NoteDto noteDto) {
        NoteEntity noteEntity = noteService.findById(id).orElseThrow();
        noteService.update(noteEntity, noteMapper.map(noteDto));
    }

    @GetMapping("/searchDate")
    public List<NoteDto> searchByDates(@RequestParam(value = "st") Long start,
                                       @RequestParam(value = "en") Long end) {
        Date st = noteMapper.mapDate(start);
        Date en = noteMapper.mapDate(end);
        return noteService.searchByDate(st, en)
                .stream().map(noteMapper::map).toList();
    }

    @GetMapping("/search")
    public List<NoteDto> search(@RequestParam(value = "name") String name,
                                @RequestParam(value = "message") String message) {
        return noteService.search(name, message).stream().map(this.noteMapper::map).toList();
    }
}