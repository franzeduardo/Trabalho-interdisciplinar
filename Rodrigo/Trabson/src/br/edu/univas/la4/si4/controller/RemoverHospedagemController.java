package br.edu.univas.la4.si4.controller;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;

import br.edu.univas.la4.si4.dao.HospedagemDAO;
import br.edu.univas.la4.si4.listener.RemoverHospedagemListener;
import br.edu.univas.la4.si4.view.RemoveHospedagemPanel;

public class RemoverHospedagemController {

	private RemoveHospedagemPanel revomeHospedagemPanel;
	private HospedagemDAO hospedagemDAO;

	public RemoverHospedagemController() {
		revomeHospedagemPanel = new RemoveHospedagemPanel();
		hospedagemDAO = new HospedagemDAO();
	}

	public Component getComponent() {
		revomeHospedagemPanel.setBackground(Color.BLACK);
		return revomeHospedagemPanel;
	}

	public void init() {
		setListener();
	}

	private void setListener() {
		revomeHospedagemPanel.setListener(new RemoverHospedagemListener() {

			@Override
			public void remover() {
				removerHospedagem();
			}
		});
	}

	private void removerHospedagem() {

		String cpf = revomeHospedagemPanel.getCpfTextField().getText();
		hospedagemDAO.removerHospede(cpf);
		JOptionPane.showMessageDialog(revomeHospedagemPanel, "Hospedagem removida com sucesso!", "Sucesso",
				JOptionPane.INFORMATION_MESSAGE);
		cleanFields();
	}

	private void cleanFields() {
		revomeHospedagemPanel.getCpfTextField().setText(null);
	}

}
