package com.example.todo.Controller.dto;

import com.example.todo.domain.TodoEntity;
import lombok.Getter;

@Getter
public class TodoResponeDto {
    private String content;
    private Boolean completed;

    public TodoResponeDto(TodoEntity entity){
        this.content = entity.getContent();
        this.completed = entity.getCompleted();
    }
}
