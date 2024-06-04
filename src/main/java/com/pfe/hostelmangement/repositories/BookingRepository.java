package com.pfe.hostelmangement.repositories;
import com.pfe.hostelmangement.entities.BookingEntity;
import com.pfe.hostelmangement.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
    List<BookingEntity> findByUser(UserEntity user);
}
