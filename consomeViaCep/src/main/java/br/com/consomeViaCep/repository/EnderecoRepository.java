package br.com.consomeViaCep.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.consomeViaCep.modelo.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
