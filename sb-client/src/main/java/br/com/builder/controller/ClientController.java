package br.com.builder.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.builder.model.Client;
import br.com.builder.reponses.ReponseDataPage;
import br.com.builder.service.ClientService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
	
	private static final String MSG_SUCCESS = "Request successfully";

	private static final Sort SORT_BY_NOME = Sort.by(Sort.Direction.ASC, "nome");
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public ReponseDataPage findAll (
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "size", defaultValue = "5", required = false) int size) {
		
		Page<Client> pageResult = clientService.findAll(PageRequest.of(page, size, SORT_BY_NOME));
		return ReponseDataPage.builder().data(pageResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
	@GetMapping(path = "/find")
	public ReponseDataPage findByParametter(
			@RequestParam(value = "param", required = false) String param,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "size", defaultValue = "5", required = false) int size
			) {
		
		Page<Client> pageResult =  clientService.findByParameter(param, PageRequest.of(page, size, SORT_BY_NOME));
		return ReponseDataPage.builder().data(pageResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
	@GetMapping(path = "/{id}")
	public ReponseDataPage findById(
			@PathVariable(value = "id") Long id) {
		Client clientResult = clientService.findById(id);
		return ReponseDataPage.builder().data(clientResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
	@GetMapping(path = "/find/data")
	public ReponseDataPage findByDataCadastro(
			@RequestParam(value = "data") String data,
			@RequestParam(value = "page", defaultValue = "0", required = false) int page,
			@RequestParam(value = "size", defaultValue = "5", required = false) int size) throws Exception
	{
		Page<Client> pageResult = clientService.findByDataCadastro(data, PageRequest.of(page, size, SORT_BY_NOME));
		return ReponseDataPage.builder().data(pageResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
	@PostMapping
	public ReponseDataPage save(@RequestBody Client client) {
		Client clientResult = clientService.save(client);
		return ReponseDataPage.builder().data(clientResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}

	@PutMapping(path = "/{id}")
	public ReponseDataPage update(@PathVariable("id") long id, @RequestBody Client client) {
		Client clientModel = modelMapper.map(client, Client.class);
		clientModel.setId(id);
		Client clientResult = clientService.update(clientModel);
		return ReponseDataPage.builder().data(clientResult).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ReponseDataPage delete(@PathVariable(value = "id") Long id) {
		Client clientDB = clientService.findById(id);
		clientService.delete(clientDB);
		return ReponseDataPage.builder().data(clientDB).message(MSG_SUCCESS).status(HttpStatus.OK.toString()).build();
	}
	
}
