package br.com.unipix.api.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_centro_de_custo")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CentroCusto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "status")
	private Boolean status;
	
	@Column(name = "solucao")
	private Boolean solution;
	
	@Column(name = "data_cadastro")
	private Date registrationDate;
	
	@Column(name = "data_alteracao")
	private Date changeDate;
}
