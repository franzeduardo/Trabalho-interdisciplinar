package br.edu.univas.la4.si4.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.univas.la4.si4.listener.RemoverHospedagemListener;

public class RemoveHospedagemPanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1724131133058569495L;

	private RemoverHospedagemListener listener;

	private JTextField cpfTextField;

	public RemoveHospedagemPanel() {
		addComponent();
	}

	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF:");
		cpfLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 10, 15);
		this.add(cpfLabel, gbc);

		cpfTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(cpfTextField, gbc);

		JButton removeButton = new JButton();
		removeButton.setText("Remover");
		removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RemoverHospedagemListener removeHospedagemListener = (RemoverHospedagemListener) listener;
				removeHospedagemListener.remover();
			}
		});

		removeButton.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(removeButton, gbc);
	}

	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	public void setListener(RemoverHospedagemListener removerButtonListener) {
		listener = removerButtonListener;
	}

}
