package com.emrebulak.data.repository;

import com.emrebulak.data.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoRepository extends CrudRepository<TodoEntity, Long> {
}
