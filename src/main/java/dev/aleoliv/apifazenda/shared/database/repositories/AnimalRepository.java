package dev.aleoliv.apifazenda.shared.database.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.aleoliv.apifazenda.shared.database.entities.AnimalEntity;

public interface AnimalRepository extends JpaRepository<AnimalEntity, UUID> {

}
