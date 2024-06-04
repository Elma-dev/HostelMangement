package com.pfe.hostelmangement.repositories;
import com.pfe.hostelmangement.entities.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {
}
