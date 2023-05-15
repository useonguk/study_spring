package com.example.todo.repository;

import com.example.todo.Repository.TodoRepository;
import com.example.todo.domain.TodoEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class todoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;
    @AfterEach
    public void 초기화(){
        todoRepository.deleteAll();
    }
    @Test
    public void 저장확인(){
        //1. 값 저장
        //1-1 엔티티생성
        TodoEntity entity = TodoEntity.builder().
                content("a content").
                completed(false).
                build();
        todoRepository.save(entity);
        //2. 저장된 값 불러오기
        List<TodoEntity> all = todoRepository.findAll();
        //3. 저장할 값과 저장된 값 비교
        assertEquals(all.get(0).getContent(), "a content");
    }
}