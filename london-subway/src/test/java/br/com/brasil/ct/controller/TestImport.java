package br.com.brasil.ct.controller;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.brasil.ct.model.FileImport;
import br.com.brasil.ct.service.ImportDataService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/mvc-dispatcher-servlet.xml" })
public class TestImport {

	@Autowired
	private ImportDataService importDataService;
	
	@Before
	public void cleanDatabase(){
		importDataService.clean();
	}

	@Test
	public void importFiles() throws URISyntaxException {
		
		FileImport fileImport = new FileImport();

		fileImport.setStationsFile(new File(getClass().getResource("/stations.csv").toURI()));
		fileImport.setRoutesFile(new File(getClass().getResource("/routes.csv").toURI()));
		fileImport.setLinesFile(new File(getClass().getResource("/lines.csv").toURI()));

		importDataService.loadFromCsv(fileImport);

	}

}
