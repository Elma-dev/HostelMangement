package com.pfe.hostelmangement.repositories;

import com.pfe.hostelmangement.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
