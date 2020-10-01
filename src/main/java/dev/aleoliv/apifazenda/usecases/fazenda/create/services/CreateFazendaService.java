package dev.aleoliv.apifazenda.usecases.fazenda.create.services;

import org.springframework.stereotype.Service;

import dev.aleoliv.apifazenda.shared.database.entities.FazendaEntity;
import dev.aleoliv.apifazenda.shared.database.repositories.FazendaRepository;
import dev.aleoliv.apifazenda.usecases.fazenda.create.dtos.CreateFazendaRequestDTO;
import dev.aleoliv.apifazenda.usecases.fazenda.create.dtos.CreateFazendaResponseDTO;
import dev.aleoliv.apifazenda.usecases.fazenda.create.mappers.CreateFazendaMapper;

@Service
public class CreateFazendaService {

	private final FazendaRepository repository;
	private final CreateFazendaMapper mapper;

	public CreateFazendaService(FazendaRepository repository, CreateFazendaMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;		
	}
	
	public CreateFazendaResponseDTO execute(CreateFazendaRequestDTO dto) {
		FazendaEntity entity = mapper.createFazendaEntityWith(dto);
		FazendaEntity fazendaEntity = repository.save(entity);
		return mapper.createDtoWith(fazendaEntity);
	}
}
