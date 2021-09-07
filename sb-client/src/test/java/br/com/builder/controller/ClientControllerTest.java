package br.com.builder.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.builder.model.Client;
import br.com.builder.service.ClientService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@WebMvcTest(ClientController.class)
public class ClientControllerTest {
	
	private final String BASE_URL = "/api/v1/client";
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ClientService clientService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	public void deve_retornar_todos_clientes() throws Exception {
		when(clientService.save(Mockito.any())).thenReturn(getClientSaida());
		
		mockMvc.perform(get(BASE_URL))
		.andDo(print())
		.andExpect(status().isOk());
	}
	
	@Test
	public void deve_salvar_cliente() throws Exception {
		
		when(clientService.save(Mockito.any())).thenReturn(getClientSaida());
		
		mockMvc.perform(post(BASE_URL)
		.contentType(MediaType.APPLICATION_JSON)
		.content(getClientEntrada()))
		.andDo(print())
		.andExpect(status().isOk());
			
	}
	
	private String getClientEntrada() {
	return  " {\r\n"
			+ "  \"nome\": \"Carlos Roberto\",\r\n"
			+ "  \"email\": \"carlos_roberto@bol.com.br\",\r\n"
			+ "  \"idade\": \"22\",\r\n"
			+ "  \"dataCadastro\": \"2021-08-02T10:00:00\"\r\n"
			+ "  \r\n"
			+ "}";
	}

	private Client getClientSaida() {
		return Client.builder().id(8L).nome("Fernada").email("fernada@teste.com").dataCadastro(new Date()).build();
	}

}
