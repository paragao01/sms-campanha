package br.com.unipix.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "manual_blacklist")
public class Manual {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "manual")
	private String manual;
	
	@JsonIgnore
	@ManyToOne
	private BlackList blackList_id;
	
}
