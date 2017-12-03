package br.edu.univas.la4.si4.controller;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import br.edu.univas.la4.si4.dao.HospedagemDAO;
import br.edu.univas.la4.si4.listener.CadastrarHospedagemListener;
import br.edu.univas.la4.si4.model.Hospedagem;
import br.edu.univas.la4.si4.view.AddHospedagemPanel;

public class AddHospedagemController {

	private AddHospedagemPanel addHospedagemPanel;
	private Hospedagem hospedagem;
	private HospedagemDAO hospedagemDAO;

	public AddHospedagemController() {
		addHospedagemPanel = new AddHospedagemPanel();
		hospedagemDAO = new HospedagemDAO();
	}

	public Component getComponent() {
		addHospedagemPanel.setBackground(Color.BLACK);
		return addHospedagemPanel;
	}

	public void init() {
		setListener();
	}

	private void setListener() {
		addHospedagemPanel.setListener(new CadastrarHospedagemListener() {

			@Override
			public void cadastrar() {
				addHospedagem();
			}
		});
	}

	private void addHospedagem() {
		hospedagem = new Hospedagem();
		hospedagem.setNome(addHospedagemPanel.getNomeTextField().getText());
		hospedagem.setCpf(addHospedagemPanel.getCpfTextField().getText());

		try {
			hospedagem.setQuarto(Integer.parseInt(addHospedagemPanel.getQuartoTextField().getText()));
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(addHospedagemPanel, "Por favor digite um valor no seguinte formato: 0",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			hospedagem.setDataEntrada(sdf.parse(addHospedagemPanel.getDataEntradaTextField().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(addHospedagemPanel, "Por favor digite a data no seguinte formato: dd/MM/yyyy",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			hospedagem.setDataSaida(sdf.parse(addHospedagemPanel.getDataSaidaTextField().getText()));
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(addHospedagemPanel, "Por favor digite a data no seguinte formato: dd/MM/yyyy",
					"Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		hospedagemDAO.cadastrar(hospedagem);
		JOptionPane.showMessageDialog(addHospedagemPanel, "Hospedagem salva com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		cleanFields();
	}

	private void cleanFields() {
		addHospedagemPanel.getNomeTextField().setText(null);
		addHospedagemPanel.getCpfTextField().setText(null);
		addHospedagemPanel.getDataEntradaTextField().setText(null);
		addHospedagemPanel.getDataSaidaTextField().setText(null);
		addHospedagemPanel.getQuartoTextField().setText(null);
	}

}
