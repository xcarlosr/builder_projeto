package br.com.builder.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.builder.exceptions.ObjectNotFoundException;
import br.com.builder.model.Client;

public interface ClientService {
	
	Client save(Client client);
	
	Client update(Client client) throws ObjectNotFoundException;
	
	void delete(Client client);
	
	Page<Client> findByParameter(String nome, PageRequest pageRequest) throws ObjectNotFoundException;

	Page<Client> findAll(PageRequest pageRequest) throws ObjectNotFoundException;

	Client findById(Long id);
	
	Page<Client> findByDataCadastro(String dataCadastro, PageRequest pageRequest) throws Exception;
	

}
