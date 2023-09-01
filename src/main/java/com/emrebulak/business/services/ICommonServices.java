package com.emrebulak.business.services;

import java.util.List;

public interface ICommonServices<D, E> {

    public D entityToDto(E e);

    public E dtoToEntity(D d);

    public D todoServiceCreate(D d);

    public List<D> todoServiceList();

    public D todoServiceFind(Long id);

    public D todoServiceDelete(Long id);

    public Integer todoServiceAllDelete();

    public D todoServiceUpdate(Long id, D d);
}
