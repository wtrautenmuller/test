package br.com.brasil.ct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.brasil.ct.dao.DataFileDAO;
import br.com.brasil.ct.model.DataFile;
import br.com.brasil.ct.model.FileImport;
import br.com.brasil.ct.service.ImportDataService;
import br.com.brasil.ct.service.LinesService;
import br.com.brasil.ct.service.RoutesService;
import br.com.brasil.ct.service.StationsService;

@Service
public class ImportDataServiceImpl implements ImportDataService {

	@Autowired
	private LinesService linesService;

	@Autowired
	private RoutesService routesService;

	@Autowired
	private StationsService stationsService;

	@Autowired
	private DataFileDAO dataFileDAO;

	@Override
	@Transactional
	public void loadFromCsv(FileImport fileImport) {

		if (dataFileDAO.getBy(true) == null) {
			stationsService.importFrom(fileImport.getStationsFile());
			routesService.importFrom(fileImport.getRoutesFile());
			linesService.importFrom(fileImport.getLinesFile());

			DataFile dataFile = new DataFile();
			dataFile.setId(1);
			dataFile.setStatus(true);
			dataFileDAO.save(dataFile);
		}

	}
	@Transactional
	public void clean(){
		stationsService.clean();
		routesService.clean();
		linesService.clean();
		dataFileDAO.clean();
		
	}

}
