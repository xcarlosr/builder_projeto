package br.com.builder.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.builder.exceptions.ObjectNotFoundException;
import br.com.builder.model.Client;
import br.com.builder.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	private static final String MSG_OBJET_NOT_FOUND = "Object not found.";
	
	@Autowired
	private ClientRepository repository;

	@Override
	public Client save(Client client) {
		return repository.save(client);
	}

	@Override
	public Client update(Client client) {
		return repository.save(client);
	}

	@Override
	public void delete(Client client) {
		repository.delete(client);
	}
	
	@Override
	public Page<Client> findAll(PageRequest pageRequest) throws ObjectNotFoundException {
		return repository.findAll(pageRequest);
	}

	@Override
	public Page<Client> findByParameter(String value, PageRequest pageRequest) throws ObjectNotFoundException {
		return repository.findByParameter(value, pageRequest).orElseThrow(() -> new ObjectNotFoundException(MSG_OBJET_NOT_FOUND));
	}

	@Override
	public Client findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(MSG_OBJET_NOT_FOUND));
	
	}

	@Override
	public Page<Client> findByDataCadastro(String dataCadastro, PageRequest pageRequest) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 
		
		LocalDateTime ldt1 = LocalDateTime.parse(dataCadastro, formatter);
		LocalDateTime ldt2 = LocalDateTime.parse(dataCadastro, formatter);
		
		ldt2 = ldt2.withHour(23);
		ldt2 = ldt2.withMinute(59);
		
		return repository.findByDataCadastro(ldt1.format(formatter), ldt2.format(formatter), pageRequest) .orElseThrow(() -> new ObjectNotFoundException(MSG_OBJET_NOT_FOUND));
		
	}
}
