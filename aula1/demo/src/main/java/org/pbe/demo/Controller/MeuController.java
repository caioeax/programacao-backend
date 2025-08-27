package org.pbe.demo.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.pbe.demo.Model.Usuario;
import org.pbe.demo.Service.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MeuController {

	record Data(String data) {}
	record Time(String horario) {}


	@RequestMapping("/data")
	public Data data() {
		LocalDate dias = LocalDate.now();
		return new Data(dias.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}	
	
	@RequestMapping("/horario")
	public Time horario() {
		LocalTime horas = LocalTime.now();;
		return new Time(horas.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
	}

	@Autowired
	ServicoUsuario serv;

	@GetMapping("/busca/{nome}")
	List<Usuario> lista(@PathVariable String nome) {
		return serv.buscaTodosComNome(nome);
	}

	@PostMapping("/adiciona") 
	long adiciona(@RequestParam String nome, @RequestParam String sobrenome) {
		return serv.cria(nome, sobrenome);
	}
}
