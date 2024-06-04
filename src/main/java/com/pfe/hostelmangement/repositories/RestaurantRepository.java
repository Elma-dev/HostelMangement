package com.pfe.hostelmangement.repositories;

import com.pfe.hostelmangement.entities.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
}
