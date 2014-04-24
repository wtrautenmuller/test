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
import br.com.brasil.ct.dao.RoutesDAO;
import br.com.brasil.ct.model.Routes;
import br.com.brasil.ct.service.RoutesService;

@Service
@Transactional
@Log4j
public class RoutesServiceImpl implements RoutesService {
	
	@Autowired
	private RoutesDAO routesDAO;

	@Override
	public void importFrom(File csv) {
		try {
			CSVReader reader = new CSVReader(new FileReader(csv), ',');

			List<Routes> listRoute = new ArrayList<Routes>();
			// read all lines at once
			List<String[]> records = reader.readAll();

			Iterator<String[]> iterator = records.iterator();
			// skip header row
			iterator.next();

			while (iterator.hasNext()) {
				String[] record = iterator.next();
				Routes route = new Routes();
				route.setLine(Integer.parseInt(record[0]));
				route.setName(record[1]);
				route.setColour(record[2]);
				route.setStripe(record[3]);
				listRoute.add(route);
			}

			routesDAO.save(listRoute);
			reader.close();

		} catch (FileNotFoundException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		} catch (IOException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		}

	}

	@Override
	public void clean() {
		routesDAO.clean();
		
	}

}
