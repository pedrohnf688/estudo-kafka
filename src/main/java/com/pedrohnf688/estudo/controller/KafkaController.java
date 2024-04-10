package com.pedrohnf688.estudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pedrohnf688.estudo.producer.MessageProducer;

@RestController
public class KafkaController {

	@Autowired
	private MessageProducer messageProducer;

	@PostMapping("/enviar")
	public String sendMessage(@RequestParam("mensagem") String mensagem) {
		messageProducer.sendMessage("my-topic", mensagem);
		return "Mensagem enviada: " + mensagem;
	}
}
