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

import br.edu.univas.la4.si4.listener.CadastrarHospedagemListener;

public class AddHospedagemPanel extends JPanel{

private static final long serialVersionUID = 4253440926691625229L;
	
	private CadastrarHospedagemListener listener;
	
	private JTextField nomeTextField;
	private JTextField cpfTextField;	
	private JTextField dataEntradaTextField;
	private JTextField dataSaidaTextField;	
	private JTextField quartoTextField;
	
	public AddHospedagemPanel() {
		addComponent();
	}
	
	private void addComponent() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel nameLabel = new JLabel();
		nameLabel.setText("Nome:");
		nameLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.LINE_END;
		gbc.insets = new Insets(15, 15, 10, 15);
		this.add(nameLabel, gbc);
		
		nomeTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(nomeTextField, gbc);
		
		JLabel cpfLabel = new JLabel();
		cpfLabel.setText("CPF:");
		cpfLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(cpfLabel, gbc);
		
		cpfTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(cpfTextField, gbc);
		
		JLabel dataEntradaLabel = new JLabel();
		dataEntradaLabel.setText("Data de Entrada:");
		dataEntradaLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(dataEntradaLabel, gbc);
		
		dataEntradaTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(dataEntradaTextField, gbc);
		
		JLabel dataSaidaLabel = new JLabel();
		dataSaidaLabel.setText("Data de Saida:");
		dataSaidaLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(dataSaidaLabel, gbc);
		
		dataSaidaTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(dataSaidaTextField, gbc);
		
		JLabel quartoLabel = new JLabel();
		quartoLabel.setText("Quarto:");
		quartoLabel.setForeground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.weightx = 0;
		gbc.insets = new Insets(15, 15, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_END;
		this.add(quartoLabel, gbc);
		
		quartoTextField = new JTextField();
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.LINE_START;
		this.add(quartoTextField, gbc);
		
		JButton addButton = new JButton();
		addButton.setText("Hospedar");
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CadastrarHospedagemListener cadastrarContaListener = (CadastrarHospedagemListener) listener;
				cadastrarContaListener.cadastrar();
			}
		});

		addButton.setBackground(Color.WHITE);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(15, 0, 10, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.NONE;
		this.add(addButton, gbc);
	}

	public JTextField getNomeTextField() {
		return nomeTextField;
	}

	public JTextField getDataEntradaTextField() {
		return dataEntradaTextField;
	}

	public JTextField getDataSaidaTextField() {
		return dataSaidaTextField;
	}
	
	public JTextField getCpfTextField() {
		return cpfTextField;
	}

	public JTextField getQuartoTextField() {
		return quartoTextField;
	}
	
	public void setListener(CadastrarHospedagemListener contaButtonListener) {
		listener = contaButtonListener;
	}

	
}
