package com.emrebulak.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICommonApi<D> {

    public ResponseEntity<D> todoApiCreate(D d);

    public ResponseEntity<List<D>> todoApiList();

    public ResponseEntity<D> todoApiFind(Long id);

    public ResponseEntity<D> todoApiDelete(Long id);

    public ResponseEntity<Integer> todoApiAllDelete();

    public ResponseEntity<D> todoApiUpdate(Long id, D d);
}
