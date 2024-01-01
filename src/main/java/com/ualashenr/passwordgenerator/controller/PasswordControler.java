package com.ualashenr.passwordgenerator.controller;

import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ualashenr.passwordgenerator.model.Password;
import com.ualashenr.passwordgenerator.service.PasswordService;

@RestController
@RequestMapping(value = "/password")
public class PasswordControler {
	
	@Autowired
	private PasswordService passwordService;
	
	@GetMapping("/create")
	public String createPassword(@RequestBody(required = false) Password password) {
		String newPassword;
		// Caso não seja passado nenhum body na requisição
		if(password == null) {
			char[] allCharacteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ!@$&+-_^()123456789".toCharArray();
			Password defaultPassword = new Password();
			Set<String> passwords = passwordService.carregarSenhas();
			// Checa se a senha já não está sendo utilizada
			do {
	            newPassword = RandomStringUtils.random(defaultPassword.getLength(), allCharacteres);
	        } while (passwords.contains(newPassword));
			passwords.add(newPassword);
			passwordService.salvarSenhas(passwords);
			return newPassword;
		}
		if(password.getLength() == 0) {
			password.setLength(15);
		}
		ArrayList<Character> selectedChars = passwordService.verificarCampos(password);
		char[] selectedCharsArray = new char[selectedChars.size()];
		for(int i=0; i<selectedChars.size();i++) {
			selectedCharsArray[i] = selectedChars.get(i);
		}
		Set<String> passwords = passwordService.carregarSenhas();
		do {
            newPassword = RandomStringUtils.random(password.getLength(), selectedCharsArray);
        } while (passwords.contains(newPassword));
		passwords.add(newPassword);
		passwordService.salvarSenhas(passwords);
		return newPassword;
	}

}
