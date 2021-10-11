package br.com.consomeViaCep.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lista_de_enderecos")
public class Endereco {
	@Id
	String cep;
	String logradouro;
	String complemento;
	String bairro;
	String localidade;
	String uf;
	int ibge; // 7 digitos - Codigos de municipios
	int gia; // 4 digitos - Guia de Informacao e Apuracao do ICMS (Imposto Sobre Circulacao
				// de Mercadorias e Servicos)
	int ddd; // 2 digitos
	int siafi; // 4 digitos - Sistema Integrado de Administracao Financeira do Governo Federal
	

	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public String getUf() {
		return uf;
	}

	public int getIbge() {
		return ibge;
	}

	public int getGia() {
		return gia;
	}

	public int getDdd() {
		return ddd;
	}

	public int getSiafi() {
		return siafi;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento + ", bairro="
				+ bairro + ", localidade=" + localidade + ", uf=" + uf + ", ibge=" + ibge + ", gia=" + gia + ", ddd="
				+ ddd + ", siafi=" + siafi + "]";
	}

}
