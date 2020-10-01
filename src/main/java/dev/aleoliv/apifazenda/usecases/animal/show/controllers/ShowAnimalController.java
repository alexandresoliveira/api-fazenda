package dev.aleoliv.apifazenda.usecases.animal.show.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.aleoliv.apifazenda.shared.exceptions.ServiceException;
import dev.aleoliv.apifazenda.usecases.animal.show.dtos.ShowAnimalResponseDTO;
import dev.aleoliv.apifazenda.usecases.animal.show.services.ShowAnimalService;

@RestController
@RequestMapping(value = "animal")
public class ShowAnimalController {

	private final ShowAnimalService service;

	public ShowAnimalController(ShowAnimalService service) {
		this.service = service;
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<ShowAnimalResponseDTO> handle() {
		return service.execute();
	}

	@GetMapping(value = "{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public ShowAnimalResponseDTO handle(@PathVariable("id") UUID id) throws ServiceException {
		return service.execute(id);
	}
}
