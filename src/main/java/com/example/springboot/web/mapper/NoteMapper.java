package com.example.springboot.web.mapper;


import com.example.springboot.model.NoteDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity map(NoteDto dto) {
        return UserEntity.builder()
                .fio(dto.getFio())
                .login(dto.getLogin())
                .role(dto.getRole())
                .phone(dto.getPhone())
                .birthday(dto.getBirthday())
                .createdAt(dto.getCreatedAt())
                .build();

    }

    public NoteDto map(UserEntity entity) {
        return NoteDto.builder()
                .id(entity.getId())
                .fio(entity.getFio())
                .login(entity.getLogin())
                .role(entity.getRole())
                .phone(entity.getPhone())
                .birthday(entity.getBirthday())
                .createdAt(entity.getCreatedAt())
                .build();

    }


}
