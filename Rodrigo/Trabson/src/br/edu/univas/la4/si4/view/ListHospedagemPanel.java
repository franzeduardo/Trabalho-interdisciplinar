package br.edu.univas.la4.si4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import br.edu.univas.la4.si4.model.Hospedagem;

public class ListHospedagemPanel extends JPanel{
	
private static final long serialVersionUID = 6806359975034010813L;
	
	private JTable table;
	private List<Hospedagem> hospedagens;
	
	public ListHospedagemPanel(List<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
		addComponents();
	}
	
	private void addComponents() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		Vector<String> columnNames = new Vector<>();
		columnNames.add("Nome");
		columnNames.add("CPF");
		columnNames.add("Data Entrada");
		columnNames.add("Data Saida");
		columnNames.add("Quarto");
  		
  		table = new JTable(null, columnNames);
  		table.setFillsViewportHeight(true);
  		updateContas(hospedagens);
		
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 1.0;
		gbc.insets = new Insets(15, 15, 15, 15);
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(tableScroll, gbc);
		
	}

	public void updateContas(List<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for (Hospedagem hospedagem : hospedagens) {
			dtm.addRow(new Object[] {
					hospedagem.getNome(),
					hospedagem.getCpf(),
					formatDate(hospedagem.getDataEntrada()),
					formatDate(hospedagem.getDataSaida()),					
					hospedagem.getQuarto()
			});
		} 
	}
	
	private String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
	
}
