package br.com.unipix.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.unipix.api.model.BlackList;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@Spec(path = "centroCusto.id", params = "centroCusto", spec = Equal.class)
public interface BlackListSpecification extends Specification<BlackList>{

}
