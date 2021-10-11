package br.com.consomeViaCep.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import br.com.consomeViaCep.modelo.Endereco;

public class ConsultaCep {
	static String webService = "http://viacep.com.br/ws/";
	static int codigoSucesso = 200;

	public static Endereco consultaEndereco(String cep) throws Exception {
		String urlParaChamada = webService + cep + "/json";

		try {
			URL url = new URL(urlParaChamada);

			HttpURLConnection conexao = (HttpURLConnection) url.openConnection(); // Requisicao para o webservice

			if (conexao.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String jsonEmString = Util.converteJsonEmString(resposta);

			if (jsonEmString.contains("erro")) {
				return null;
			}

			Gson gson = new Gson();
			Endereco endereco = gson.fromJson(jsonEmString, Endereco.class);

			return endereco;
			
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}

	}
}
