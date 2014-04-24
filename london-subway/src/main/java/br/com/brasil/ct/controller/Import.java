package br.com.brasil.ct.controller;

import java.io.File;
import java.net.URISyntaxException;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.brasil.ct.model.FileImport;
import br.com.brasil.ct.service.ImportDataService;

@Controller
@RequestMapping("/import")
@Log4j
public class Import {

	@Autowired
	private ImportDataService importDataService;

	@RequestMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void importData() {
		try {

			FileImport fileImport = new FileImport();

			fileImport.setStationsFile(new File(getClass().getResource("/stations.csv").toURI()));
			fileImport.setRoutesFile(new File(getClass().getResource("/routes.csv").toURI()));
			fileImport.setLinesFile(new File(getClass().getResource("/lines.csv").toURI()));

			importDataService.loadFromCsv(fileImport);

		} catch (URISyntaxException e) {
			log.error("Erro ao obter arquivo, motivo do erro: " + e.getMessage(), e);

		}

	}

}
