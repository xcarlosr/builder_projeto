package br.com.builder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.builder.model.Client;
import br.com.builder.repository.ClientRepository;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ClientServiceImplTest {

	private static final Sort SORT_BY_NOME = Sort.by(Sort.Direction.ASC, "nome");
	
	@Autowired
	private ClientService service;

	@MockBean
	private ClientRepository clientRepository;

	@Test
	public void deve_savar_um_client() {

		when(clientRepository.save(Mockito.any())).thenReturn(getClientSaida());

		Client client = service.save(getClientEntrada());

		assertEquals(client.getId(), getClientSaida().getId());

	}
	
	@Test
	public void deve_altera_um_client() {

		when(clientRepository.save(Mockito.any())).thenReturn(getClientAlterar());

		Client client = service.update(getClientAlterar());

		assertEquals(client.getId(), getClientSaida().getId());

	}
	
	@Test
	public void deve_deletar_um_client() {

		doNothing().when(clientRepository).delete(Mockito.any());

		service.delete(getClientAlterar());      

		verify(clientRepository, times(1)).delete(Mockito.any());

	}
	
	@Test
	public void deve_retornar_todos_clients() {
		
		when(clientRepository.findAll(PageRequest.of(0, 5, SORT_BY_NOME))).thenReturn(getList());
		
		Page<Client> pageResult = service.findAll(PageRequest.of(0, 5, SORT_BY_NOME));
		
		assertEquals(pageResult.getContent().get(0).getId(), getList().getContent().get(0).getId());
	}
	
	

	private Client getClientEntrada() {
		return Client.builder().nome("Fernada").email("fernada@teste.com").dataCadastro(new Date()).build();
	}

	private Client getClientSaida() {
		return Client.builder().id(8L).nome("Fernada").email("fernada@teste.com").dataCadastro(new Date()).build();
	}
	
	private Client getClientAlterar() {
		return Client.builder().id(8L).nome("Alberto").email("alberto@teste.com").dataCadastro(new Date()).build();
	}
	
	private Page<Client> getList () {
		Client c1 = Client.builder().id(2L).nome("Rafael").build();
		Client c2 = Client.builder().id(3L).nome("Mateus").build();
		List<Client> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);
		Page<Client> result = new PageImpl<Client>(lista);
		return result; 
		
	}
	
}
