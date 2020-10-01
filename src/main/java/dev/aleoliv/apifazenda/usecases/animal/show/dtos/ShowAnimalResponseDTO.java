package dev.aleoliv.apifazenda.usecases.animal.show.dtos;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ShowAnimalResponseDTO {

	private UUID id;
	private String tag;
	private String fazenda;
}
