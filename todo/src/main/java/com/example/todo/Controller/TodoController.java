package com.example.todo.Controller;


import com.example.todo.Controller.dto.TodoRequestDto;
import com.example.todo.Controller.dto.TodoResponeDto;
import com.example.todo.domain.TodoEntity;
import com.example.todo.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/todo/api")
    public Long create(@RequestBody TodoRequestDto requestDto) {
        return todoService.sava(requestDto);
    }

    //전체 리스트 읽기
    @GetMapping("/todo/api")
    public List<TodoResponeDto> readAll() {
        return todoService.findAll();
    }

    //객체 하나에 대해 읽기
    @GetMapping("/todo/api/{id}")
    public TodoResponeDto readOne(@PathVariable Long id) {
        return todoService.findById(id);
    }

    //업데이트
    @PutMapping("/todo/api/{id}")
    public Long update(@PathVariable Long id,
                       @PathVariable TodoRequestDto requestDto) {
        return todoService.update(id, requestDto);
    }
}
