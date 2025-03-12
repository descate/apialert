package com.monitoreodeforestacion.repository;

import com.monitoreodeforestacion.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActionRepository extends JpaRepository<Action, Long> {
    Optional<Action> findByAlertCode(String actionAlertCode);
}
