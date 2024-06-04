package com.pfe.hostelmangement.repositories;

import com.pfe.hostelmangement.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
