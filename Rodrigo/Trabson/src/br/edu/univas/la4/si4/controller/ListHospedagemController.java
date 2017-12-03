package br.edu.univas.la4.si4.controller;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import br.edu.univas.la4.si4.dao.HospedagemDAO;
import br.edu.univas.la4.si4.model.Hospedagem;
import br.edu.univas.la4.si4.view.ListHospedagemPanel;

public class ListHospedagemController {

	private ListHospedagemPanel listContaPanel;
	private HospedagemDAO hospedagemDAO;

	public ListHospedagemController() {
		hospedagemDAO = new HospedagemDAO();
		ArrayList<Hospedagem> hospedagens = hospedagemDAO.listar();
		listContaPanel = new ListHospedagemPanel(hospedagens);
	}

	public Component getComponent() {
		ArrayList<Hospedagem> hospedagens = hospedagemDAO.listar();
		listContaPanel.updateContas(hospedagens);
		listContaPanel.setBackground(Color.BLACK);
		return listContaPanel;
	}

}
