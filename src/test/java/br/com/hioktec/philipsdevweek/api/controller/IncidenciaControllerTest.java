package br.com.hioktec.philipsdevweek.api.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.hioktec.philipsdevweek.domain.entity.Incidencia;

@SpringBootTest
@AutoConfigureMockMvc
public class IncidenciaControllerTest {
	
	private final String URL = "/api/incidencias";

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getControllerTest() throws Exception {
		mockMvc.perform(get(URL))
			.andExpect(status().isOk());
	}
	
	@Test
	public void getByIdControllerTest() throws Exception {
		mockMvc.perform(get(URL + "/2"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void getByIdWithInvalidIDControllerTest() throws Exception {
		mockMvc.perform(get(URL + "/99"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void createControllerTest() throws Exception {
		Incidencia newIncidencia = new Incidencia(2l, 7, 8l, 1234);
			
		mockMvc.perform(post(URL + "/novo")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(newIncidencia)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void deleteControllerTest() throws Exception {
		mockMvc.perform(delete(URL + "/remover/4"))
				.andExpect(status().isNoContent());
	}
	
	@Test
	public void deleteWithInvalidIDControllerTest() throws Exception {
		mockMvc.perform(delete(URL + "/remover/99"))
				.andExpect(status().isNotFound());
	}
	
	private String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
