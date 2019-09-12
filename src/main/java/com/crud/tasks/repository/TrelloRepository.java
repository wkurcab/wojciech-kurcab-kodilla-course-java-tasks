package com.crud.tasks.repository;

import com.crud.tasks.domain.Trello;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrelloRepository extends CrudRepository<Trello, Long> {
    @Override
    Optional<Trello> findById(Long id);
}
