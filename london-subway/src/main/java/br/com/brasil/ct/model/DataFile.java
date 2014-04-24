package br.com.brasil.ct.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class DataFile {
	
	@Id
	private int id;
	
	private boolean status;

}
