package com.javatechie.crud.example.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.javatechie.crud.example.TestH2Repository;
import com.javatechie.crud.example.entity.Product;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TestH2Repository repository;
	
	@Test
	public void givenProduct_whenGetProducts_thenStatus200() throws Exception{
		repository.save(new Product("test", 33, 203));
		
		mvc.perform(get("/products")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(jsonPath("$[0].name", is("test")))
				.andExpect(jsonPath("$", hasSize(1)));
		
	}
	
}
