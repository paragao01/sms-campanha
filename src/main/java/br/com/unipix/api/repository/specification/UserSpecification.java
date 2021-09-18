package br.com.unipix.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.unipix.api.model.User;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;


@And({ @Spec(path = "name", params = "name", spec = Like.class),
		@Spec(path = "email", params = "email", spec = Like.class) })
public interface UserSpecification extends Specification<User> {
	
}
