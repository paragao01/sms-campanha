package br.com.unipix.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.unipix.api.enumaration.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tb_usuario")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "senha")
	private String password;
	
	@Column(name = "status")
	private StatusEnum status;
	
//	@ManyToMany
//	@JoinTable(name = "tb_usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
//			inverseJoinColumns = @JoinColumn(name = "grupo_id"))
//	private Set<Grupo> grupos = new HashSet<>();
	
}
