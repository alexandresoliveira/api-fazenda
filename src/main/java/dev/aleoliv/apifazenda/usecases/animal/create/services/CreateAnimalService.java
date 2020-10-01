package dev.aleoliv.apifazenda.usecases.animal.create.services;

import org.springframework.stereotype.Service;

import dev.aleoliv.apifazenda.shared.database.entities.AnimalEntity;
import dev.aleoliv.apifazenda.shared.database.repositories.AnimalRepository;
import dev.aleoliv.apifazenda.usecases.animal.create.dtos.CreateAnimalRequestDTO;
import dev.aleoliv.apifazenda.usecases.animal.create.dtos.CreateAnimalResponseDTO;
import dev.aleoliv.apifazenda.usecases.animal.create.mappers.CreateAnimalMapper;

@Service
public class CreateAnimalService {

	private final AnimalRepository repository;
	private final CreateAnimalMapper mapper;

	public CreateAnimalService(AnimalRepository repository, CreateAnimalMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public CreateAnimalResponseDTO execute(CreateAnimalRequestDTO dto) {
		AnimalEntity animalEntity = mapper.createEntityWith(dto);
		AnimalEntity entity = repository.save(animalEntity);
		return mapper.createDtoWith(entity);
	}
}
