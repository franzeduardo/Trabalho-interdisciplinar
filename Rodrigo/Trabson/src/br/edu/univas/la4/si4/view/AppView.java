package br.edu.univas.la4.si4.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.univas.la4.si4.listener.ListenerButtons;

public class AppView extends JFrame {

	private static final long serialVersionUID = -8972781220322077793L;

	private JPanel centerPanel;
	private ListenerButtons listener;

	public AppView() {
		this.setTitle("Gerenciar Hotel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(530, 530));
		addComponents();
	}

	public void addComponents() {
		this.getContentPane().setLayout(new BorderLayout());

		JPanel southPanel = new JPanel();
		southPanel.setBackground(Color.BLACK);
		createButtons(southPanel);
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.BLACK);

		this.getContentPane().add(southPanel, BorderLayout.SOUTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	private void createButtons(JPanel panel) {
		JButton addButton = new JButton();
		addButton.setText("Cadastrar Hospedagem");
		addButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.cadastrar();
			}
		});
		addButton.setBackground(Color.WHITE);
		panel.add(addButton);

		JButton removeButton = new JButton();
		removeButton.setText("Remover Hospedagem");
		removeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.remover();
			}
		});
		removeButton.setBackground(Color.WHITE);
		panel.add(removeButton);

		JButton listButton = new JButton();
		listButton.setText("Listar Hospedagens");
		listButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listener.listar();
			}
		});
		listButton.setBackground(Color.WHITE);
		panel.add(listButton);
	}

	public void setListener(ListenerButtons listener) {
		this.listener = listener;
	}

}
