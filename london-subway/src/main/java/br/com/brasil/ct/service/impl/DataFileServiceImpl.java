package br.com.brasil.ct.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasil.ct.dao.DataFileDAO;
import br.com.brasil.ct.service.DataFileService;

@Service
public class DataFileServiceImpl implements DataFileService {

	@Autowired
	private DataFileDAO dataFileDAO;

}
