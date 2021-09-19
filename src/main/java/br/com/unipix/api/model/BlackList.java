package br.com.unipix.api.model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_blacklist")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlackList {
	
	@Column(name = "id")
	@Id
	@NotBlank
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private CentroCusto centroCusto;
	
	@Column(name = "anexo")
	private Blob anexo;
	
	@OneToMany(mappedBy = "blackList_id", fetch = FetchType.LAZY)
	private List<Manual> manual;
	
	@Column(name = "dataCadastro")
	private Date dataCadastro;
	
}
