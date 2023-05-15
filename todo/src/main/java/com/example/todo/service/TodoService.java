package com.example.todo.service;

import com.example.todo.Controller.dto.TodoRequestDto;
import com.example.todo.Controller.dto.TodoResponeDto;
import com.example.todo.Repository.TodoRepository;
import com.example.todo.domain.TodoEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class    TodoService {
    private final TodoRepository todoRepository;

    @Transactional
    public Long sava(TodoRequestDto requestDto) {
        return todoRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<TodoResponeDto> findAll() {
        List<TodoEntity> result = todoRepository.findAll();
        List<TodoResponeDto> responseDtos = new ArrayList<>();

        for(TodoEntity entity : result){
            responseDtos.add(new TodoResponeDto(entity));
        }
        return responseDtos;
    }

    @Transactional
    public TodoResponeDto findById(Long id) {
        Optional<TodoEntity> entity = todoRepository.findById(id);
        return new TodoResponeDto(entity.orElse(new TodoEntity()));//null일때 TOdoEntity로 넘기겠다. 아니면 entity넘김
    }
    @Transactional
    public Long update(Long id, TodoRequestDto requestDto){
        //id값으로 찾기
        TodoEntity entity = todoRepository.findById(id).orElse(new TodoEntity());
        //dto 내용으로 바꾸기
        return entity.updateData(requestDto);
    }
}
