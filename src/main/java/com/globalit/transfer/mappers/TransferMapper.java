package com.globalit.transfer.mappers;

import java.util.List;
import java.util.stream.Collectors;

public interface TransferMapper<D, E> {

    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toListDto(List<E> entities) {return entities.stream().map(this::toDto).collect(Collectors.toList()); }

    default List<E> toListEntity(List<D> dtos) {return dtos.stream().map(this::toEntity).collect(Collectors.toList()); }

}
