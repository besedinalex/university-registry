package com.university.registry.repositories;

import com.university.registry.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupsRepository extends JpaRepository<Group, Long> {

    Optional<Group> findByName(String name);
}