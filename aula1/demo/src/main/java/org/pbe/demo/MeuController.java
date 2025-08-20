package org.pbe.demo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
