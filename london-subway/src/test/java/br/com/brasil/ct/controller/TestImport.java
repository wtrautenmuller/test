package br.com.brasil.ct.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.brasil.ct.service.ImportDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/mvc-dispatcher-servlet.xml" })
@WebAppConfiguration
public class TestImport {

	private MockMvc mockMvc;

	@Autowired
	private ImportDataService importDataService;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void cleanDatabase() {
		importDataService.clean();
	}

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void importFiles() throws Exception {

		mockMvc.perform(post("/import").contentType(MediaType.ALL));
		importDataService.clean();

	}

}
