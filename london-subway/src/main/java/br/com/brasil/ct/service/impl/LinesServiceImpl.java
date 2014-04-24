package br.com.brasil.ct.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.bytecode.opencsv.CSVReader;
import br.com.brasil.ct.dao.LineDAO;
import br.com.brasil.ct.model.Lines;
import br.com.brasil.ct.service.LinesService;

@Service
@Transactional
@Log4j
public class LinesServiceImpl implements LinesService {

	@Autowired
	private LineDAO lineDAO;

	@Override
	public void importFrom(File csv) {
		try {
			log.info("Iniciando import dos arquivos");
			CSVReader reader = new CSVReader(new FileReader(csv), ',');

			List<Lines> listLine = new ArrayList<Lines>();
			// read all lines at once
			List<String[]> records = reader.readAll();

			Iterator<String[]> iterator = records.iterator();
			// skip header row
			iterator.next();

			while (iterator.hasNext()) {
				String[] record = iterator.next();
				Lines line = new Lines();

				line.setStation1(Integer.parseInt(record[0]));
				line.setStation2(Integer.parseInt(record[1]));
				line.setLine(Integer.parseInt(record[2]));
				listLine.add(line);
			}

			lineDAO.save(listLine);
			reader.close();

		} catch (FileNotFoundException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		} catch (IOException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		}

	}

	@Override
	public void clean() {
		lineDAO.clean();

	}

}
