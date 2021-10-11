package br.com.consomeViaCep;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.http.ResponseEntity;

//import br.com.consomeViaCep.controller.form.EnderecoForm;
//import br.com.consomeViaCep.controller.EnderecoController;
import br.com.consomeViaCep.modelo.Endereco;
import br.com.consomeViaCep.service.EnderecoService;
import br.com.consomeViaCep.util.ConsultaCep;

@SpringBootApplication
public class ConsomeViaCepApplication implements CommandLineRunner {

	private final EnderecoService service;

	public ConsomeViaCepApplication(EnderecoService service) {
		this.service = service;
	}

	public static void main(String[] args) {
		SpringApplication.run(ConsomeViaCepApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// executado após a finalização do método main
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		String opt = "";

		do {
			String cep;
			Endereco endereco;
			System.out.print("Informe o CEP do endereco que deseja listar:   ");
			cep = scanner.nextLine();

			try {
				endereco = ConsultaCep.consultaEndereco(cep); // Consulta a API e armazena o resultado

				if (endereco != null) {
					service.salvar(endereco);
				} else {
					System.out.println("Cep inexistente.");
				}
			} catch (Exception e) {
				System.out.println("Cep inválido.");
			}

			System.out.println("Visualização do banco de dados");
			service.visualizar();
			System.out.println();
			
			do {
				System.out.print("Deseja consultar outro endereco pelo cep? [s/n]  ");
				opt = scanner.nextLine();
			} while ((!opt.equalsIgnoreCase("n")) && (!opt.equalsIgnoreCase("s")));

		} while (!opt.equalsIgnoreCase("n"));

		System.out.println("Programa terminado.");

	}

}