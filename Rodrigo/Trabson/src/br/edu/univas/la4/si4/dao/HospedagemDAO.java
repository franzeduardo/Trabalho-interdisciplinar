package br.edu.univas.la4.si4.dao;

import java.util.ArrayList;

import br.edu.univas.la4.si4.model.Hospedagem;

public class HospedagemDAO {

	private static ArrayList<Hospedagem> hospedagens = new ArrayList<Hospedagem>();

	public void cadastrar(Hospedagem hospedagem) {
		hospedagens.add(hospedagem);
	}

	public ArrayList<Hospedagem> listar() {
		return hospedagens;
	}

	public void removerHospede(String cpf) {
		Hospedagem hospRemove = new Hospedagem();
		for (Hospedagem hosp : hospedagens) {
			if (hosp.getCpf().equals(cpf)) {
				hospRemove = hosp;
			}
		}
		
		hospedagens.remove(hospRemove);
	}

}
