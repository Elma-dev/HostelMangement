package com.pfe.hostelmangement.repositories;

import com.pfe.hostelmangement.entities.BlogEntity;
import com.pfe.hostelmangement.entities.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity, Long> {
}
