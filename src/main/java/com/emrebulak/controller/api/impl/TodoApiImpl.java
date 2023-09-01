package com.emrebulak.controller.api.impl;

import com.emrebulak.assist.FrontEnd;
import com.emrebulak.business.dto.TodoDto;
import com.emrebulak.business.services.ICommonServices;
import com.emrebulak.controller.api.ICommonApi;
import com.emrebulak.data.entity.TodoEntity;
import com.emrebulak.error.ApiResult;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Log4j2

@RestController
@RequestMapping("/todo/api/v1")
@CrossOrigin(origins = FrontEnd.URL)

public class TodoApiImpl implements ICommonApi<TodoDto> {

    private final ICommonServices<TodoDto, TodoEntity> iCommonServices;
    private ApiResult apiResult;

    @PostConstruct
    public void todoPostConstruct() {
        apiResult = new ApiResult();
    }

    @Override
    @PostMapping(value = "/create")
    public ResponseEntity<TodoDto> todoApiCreate(@Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iCommonServices.todoServiceCreate(todoDto));
    }

    @Override
    @GetMapping(value = "/list")
    public ResponseEntity<List<TodoDto>> todoApiList() {
        return ResponseEntity.ok(iCommonServices.todoServiceList());
    }

    @Override
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<TodoDto> todoApiFind(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iCommonServices.todoServiceFind(id));
    }

    @Override
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<TodoDto> todoApiDelete(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iCommonServices.todoServiceDelete(id));
    }

    @Override

    @GetMapping(value = "/all/delete")
    public ResponseEntity<Integer> todoApiAllDelete() {
        return ResponseEntity.ok(iCommonServices.todoServiceAllDelete());
    }

    @Override

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<TodoDto> todoApiUpdate(@PathVariable(name = "id") Long id, @Valid @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(iCommonServices.todoServiceUpdate(id, todoDto));
    }
}
