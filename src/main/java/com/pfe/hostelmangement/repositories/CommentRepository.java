package com.pfe.hostelmangement.repositories;

import com.pfe.hostelmangement.entities.BookingEntity;
import com.pfe.hostelmangement.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
