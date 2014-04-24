package br.com.brasil.ct.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Lines {
	
	@Id
	@SequenceGenerator(name = "wseq_lines", sequenceName = "seq_lines", allocationSize = 1)
	@GeneratedValue(generator = "wseq_lines",strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer station1;
	
	private Integer station2;
	
	private Integer line;

}
