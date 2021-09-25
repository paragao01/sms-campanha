package br.com.unipix.api.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_campanha_confirmacao")
public class CampanhaConfirmacao {
	
	@Id
	@NotNull
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "numero")
	private String number;
	
	@Column(name = "codigo_envio")
	private Integer shippingCode;
	
	@Column(name = "mensagem")
	private String message;
	
	@Column(name = "status")
	@Enumerated(EnumType.ORDINAL)
	private StatusEnum status;
	
	@Column(name = "data_criacao")
	private Date createdDate;
	
//	@ManyToOne
//	@JoinColumn(name = "campanha_id", referencedColumnName = "id")
//	private Campanha campanha;

}
