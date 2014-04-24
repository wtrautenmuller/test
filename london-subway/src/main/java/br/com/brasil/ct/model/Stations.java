package br.com.brasil.ct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Stations {
	
	@Id
	private Long id;
	
	private String name;
	
	@Column(name = "display_name")
	private String displayName;
	
	private Double zone;
	
	@Column(name = "total_lines")
	private Integer totalLines;
	
	private Integer rail;
	
	private float longitude;
	
	private float latitude;

}
