package com.ualashenr.passwordgenerator.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ualashenr.passwordgenerator.model.Password;

@Service
public class PasswordService {

	public ArrayList<Character> verificarCampos(Password password) {
		ArrayList<Character> selectedChars = new ArrayList<>();
		if (password.isIncludeSmallCase()) {
			adicionarStringAoArrayList("abcdefghijklmnopqrstuvwxyz", selectedChars);
		}
		if (password.isIncludeUpperCase()) {
			adicionarStringAoArrayList("ABCDEFGHIJKLMNOPQRSTUVWXYZ", selectedChars);
		}
		if (password.isIncludeNumbers()) {
			adicionarStringAoArrayList("123456789", selectedChars);
		}
		if (password.isIncludeSpecialCharacters()) {
			adicionarStringAoArrayList("!@$&+-_^()", selectedChars);
		}
		return selectedChars;
	}

	private static void adicionarStringAoArrayList(String str, ArrayList<Character> arrayList) {
		char[] chars = str.toCharArray();

		for (char c : chars) {
			arrayList.add(c);
		}
	}

	public Set<String> carregarSenhas() {
		Set<String> senhas = new HashSet<>();
		String nome_arquivo = "src/main/resources/static/password.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(nome_arquivo))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				senhas.add(linha);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return senhas;
	}

	public void salvarSenhas(Set<String> senhas) {
		String nome_arquivo = "src/main/resources/static/password.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nome_arquivo))) {
			for (String senha : senhas) {
				writer.write(senha);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
