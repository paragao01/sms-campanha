package br.com.unipix.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_layout_cadastro")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LayoutCadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "codigo")
	private Long code;
	
	@OneToOne
	@JoinColumn(name = "centro_de_custo_id", referencedColumnName = "id", nullable = false)
	private CentroCusto centroCusto;
	
	@Column(name = "numero_campos")
	private Long numberFields;
	
	@Column(name = "quantide_telefones")

	private Long amountTelephone;

	@Column(name = "tipo")
	private Integer type;
	
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ignorar_cabecalho")
	private StatusEnum ignoreHeader;
	
	@CreatedDate
	@Column(name = "data_criacao")
	private Date createDate;
}
