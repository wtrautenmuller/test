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
import br.com.brasil.ct.dao.StationsDAO;
import br.com.brasil.ct.model.Stations;
import br.com.brasil.ct.service.StationsService;

@Service
@Transactional(timeout=10)
@Log4j
public class StationsServiceImpl implements StationsService {

	@Autowired
	private StationsDAO stationsDAO;

	@Override
	public void importFrom(File csv) {
		try {
			CSVReader reader = new CSVReader(new FileReader(csv), ',');

			List<Stations> listStations = new ArrayList<Stations>();
			// read all lines at once
			List<String[]> records = reader.readAll();

			Iterator<String[]> iterator = records.iterator();
			// skip header row
			iterator.next();

			while (iterator.hasNext()) {
				String[] record = iterator.next();
				Stations station = new Stations();
				station.setId(Long.parseLong(record[0]));
				station.setLatitude(Float.parseFloat(record[1]));
				station.setLongitude(Float.parseFloat(record[2]));
				station.setName(record[3]);
				station.setDisplayName(record[4]);
				station.setZone(Double.parseDouble(record[5]));
				station.setTotalLines(Integer.parseInt(record[6]));
				station.setRail(Integer.parseInt(record[7]));
				listStations.add(station);
			}

			stationsDAO.save(listStations);
			reader.close();

		} catch (FileNotFoundException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		} catch (IOException e) {
			log.error("Erro ao importar arquivo, motivo do erro: " + e.getMessage(), e);
		}

	}

	@Override
	public void clean() {
		stationsDAO.clean();
		
	}

}
