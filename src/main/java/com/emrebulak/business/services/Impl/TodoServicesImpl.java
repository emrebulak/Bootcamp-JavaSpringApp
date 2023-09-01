package com.emrebulak.business.services.Impl;

import com.emrebulak.bean.ModelMapperBean;
import com.emrebulak.business.dto.TodoDto;
import com.emrebulak.business.services.ICommonServices;
import com.emrebulak.data.entity.TodoEntity;
import com.emrebulak.data.repository.ITodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log4j2
@Service
public class TodoServicesImpl implements ICommonServices<TodoDto, TodoEntity> {

    private final ITodoRepository iTodoRepository;
    private final ModelMapperBean modelMapperBean;

    @Override
    public TodoDto entityToDto(TodoEntity todoEntity) {
        return modelMapperBean.modelMapperMethod().map(todoEntity, TodoDto.class);
    }

    @Override
    public TodoEntity dtoToEntity(TodoDto todoDto) {
        return modelMapperBean.modelMapperMethod().map(todoDto, TodoEntity.class);
    }

    @Override
    @Transactional
    public TodoDto todoServiceCreate(TodoDto todoDto) {

        if (todoDto != null) {
            TodoEntity todoEntity = iTodoRepository.save(dtoToEntity(todoDto));
            todoDto.setId(todoEntity.getId());
            todoDto.setSystemDate(todoEntity.getSystemDate());
        } else {
            throw new NullPointerException("Todo Dto null");
        }
        return todoDto;
    }

    @Override
    public List<TodoDto> todoServiceList() {
        Iterable<TodoEntity> todoEntitiesList = iTodoRepository.findAll();
        List<TodoDto> todoDtoList = new ArrayList<>();
        for (TodoEntity entity : todoEntitiesList) {
            TodoDto todoDto = entityToDto(entity);
            todoDtoList.add(todoDto);
        }
        return todoDtoList;
    }

    @Override
    public TodoDto todoServiceFind(Long id) {
        Optional<TodoEntity> todoFindEntity = iTodoRepository.findById(id);
        TodoDto todoDto = entityToDto(todoFindEntity.get());
        if (todoFindEntity.isPresent()) {
            return todoDto;
        }
        return null;
    }

    @Override
    @Transactional
    public TodoDto todoServiceDelete(Long id) {
        TodoDto todoFindDto = todoServiceFind(id);
        if (todoFindDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoFindDto);
            iTodoRepository.delete(todoEntity);
        }
        return todoFindDto;
    }

    @Override
    public Integer todoServiceAllDelete() {
        iTodoRepository.deleteAll();
        return todoServiceList().size();
    }

    @Override
    @Transactional
    public TodoDto todoServiceUpdate(Long id, TodoDto todoDto) {
        TodoDto todoFindDto = todoServiceFind(id);
        if (todoFindDto != null) {
            TodoEntity todoEntity = dtoToEntity(todoFindDto);
            todoEntity.setTitle(todoDto.getTitle());
            todoEntity.setDone(todoDto.getDone());
            iTodoRepository.save(todoEntity);
        }
        return todoDto;
    }
}
