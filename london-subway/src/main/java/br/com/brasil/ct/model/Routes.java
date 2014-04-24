package br.com.brasil.ct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Routes {

	@Id
	@SequenceGenerator(name = "wseq_routes", sequenceName = "seq_routes", allocationSize = 1)
	@GeneratedValue(generator = "wseq_routes",strategy=GenerationType.AUTO)
	private Integer id;

	private String name;

	private String colour;

	private String stripe;

	private Integer line;

}
