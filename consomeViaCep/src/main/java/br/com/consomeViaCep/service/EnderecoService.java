package br.com.consomeViaCep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.consomeViaCep.modelo.Endereco;
import br.com.consomeViaCep.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	public void salvar(Endereco endereco) {
		System.out.println(endereco.toString());
		enderecoRepository.save(endereco);
		System.out.println("Savo!");
		System.out.println();
	}

	public void visualizar() {
		Iterable<Endereco> enderecos = enderecoRepository.findAll();
		enderecos.forEach(endereco -> System.out.println(endereco));
	}

}
