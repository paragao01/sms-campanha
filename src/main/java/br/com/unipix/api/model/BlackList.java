package br.com.unipix.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private CentroCusto centroCusto;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	private Anexo anexo;
	
	@OneToMany(mappedBy = "blackList_id", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<Manual> manual;
	
	@CreatedDate
	@Column(name = "data_cadastro")
	private Date dateCreated;
	
}
