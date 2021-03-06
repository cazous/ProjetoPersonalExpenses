package forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import crud.BuscarDados;
import crud.DeletarDados;
import crud.EditarDados;
import crud.InserirDados;
import validacao.ValidarDados;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ViewPrincipal {

	private JFrame frmPersonalExpenses;
	private JTextField txtFieldNome;
	private JTextField txtFieldValor;

	// GLOBAIS
	DefaultTableModel model = new DefaultTableModel();
	InserirDados id = new InserirDados();
	DeletarDados deldata = new DeletarDados();
	BuscarDados bd = new BuscarDados();
	EditarDados editData = new EditarDados();
	ValidarDados vd = new ValidarDados();
	private JTable tableGastos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPrincipal window = new ViewPrincipal();
					window.frmPersonalExpenses.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewPrincipal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPersonalExpenses = new JFrame();
		
		frmPersonalExpenses.getContentPane().setBackground(SystemColor.activeCaption);
		frmPersonalExpenses.setTitle("Personal Expenses");
		frmPersonalExpenses.setSize(660, 660);
		frmPersonalExpenses.setResizable(false);
		frmPersonalExpenses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonalExpenses.getContentPane().setLayout(null);
		JComboBox cbFiltroCategoria = new JComboBox();
		JButton btnMensal = new JButton("Mensal");
		btnMensal.setEnabled(false);
		btnMensal.setForeground(new Color(0, 0, 0));
		btnMensal.setBackground(new Color(176, 196, 222));
		btnMensal.setBounds(0, 0, 120, 40);
		frmPersonalExpenses.getContentPane().add(btnMensal);

		Box verticalBoxFiltros = Box.createVerticalBox();
		verticalBoxFiltros.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.setBounds(0, 114, 130, 91);
		frmPersonalExpenses.getContentPane().add(verticalBoxFiltros);

		JCheckBox chkFiltroMaiorValor = new JCheckBox("Maior Valor");
		chkFiltroMaiorValor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int categoria = 0;
				if (chkFiltroMaiorValor.isSelected()) {
					if (cbFiltroCategoria.getSelectedItem().toString() == "Alimenta??o") {
						categoria = 1;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Transporte") {
						categoria = 2;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Recreativos") {
						categoria = 3;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Metas") {
						categoria = 4;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Fixos") {
						categoria = 5;
					}
					bd.buscarMaiorPreco(tableGastos, categoria, chkFiltroMaiorValor);
				}else {
					if (cbFiltroCategoria.getSelectedItem().toString() == "Alimenta??o") {
						categoria = 1;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Transporte") {
						categoria = 2;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Recreativos") {
						categoria = 3;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Metas") {
						categoria = 4;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Fixos") {
						categoria = 5;
					}
					bd.buscarMaiorPreco(tableGastos, categoria, chkFiltroMaiorValor);
				}
			}
		});
		chkFiltroMaiorValor.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.add(chkFiltroMaiorValor);

		JCheckBox chkFiltroNome = new JCheckBox("Nome");
		chkFiltroNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int categoria = 0;
				if (chkFiltroNome.isSelected()) {
					if (cbFiltroCategoria.getSelectedItem().toString() == "Alimenta??o") {
						categoria = 1;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Transporte") {
						categoria = 2;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Recreativos") {
						categoria = 3;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Metas") {
						categoria = 4;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Fixos") {
						categoria = 5;
					}
					bd.buscarNome(tableGastos, categoria, chkFiltroNome);
				}else {
					if (cbFiltroCategoria.getSelectedItem().toString() == "Alimenta??o") {
						categoria = 1;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Transporte") {
						categoria = 2;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Recreativos") {
						categoria = 3;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Metas") {
						categoria = 4;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Fixos") {
						categoria = 5;
					}
					bd.buscarNome(tableGastos, categoria, chkFiltroNome);
				}
			}
		});
		chkFiltroNome.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.add(chkFiltroNome);

		JCheckBox chkFiltroData = new JCheckBox("Data");
		chkFiltroData.setBackground(SystemColor.activeCaption);
		chkFiltroData.setEnabled(false);
		verticalBoxFiltros.add(chkFiltroData);

		JLabel lblFiltro = new JLabel("FILTRAR POR: ");
		lblFiltro.setBounds(0, 39, 120, 25);
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		frmPersonalExpenses.getContentPane().add(lblFiltro);

		JLabel lblNewLabel = new JLabel("Total do m?s");
		lblNewLabel.setBounds(10, 295, 120, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmPersonalExpenses.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 317, 120, 67);
		frmPersonalExpenses.getContentPane().add(panel);

		JLabel lblPrincipalNome = new JLabel("Nome:");
		lblPrincipalNome.setBounds(10, 414, 58, 14);
		lblPrincipalNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalNome);

		JLabel lblPrincipalData = new JLabel("Data:");
		lblPrincipalData.setBounds(10, 448, 58, 14);
		lblPrincipalData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalData);

		JLabel lblPrincipalCategoria = new JLabel("Categoria:");
		lblPrincipalCategoria.setBounds(10, 482, 58, 14);
		lblPrincipalCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalCategoria);

		JLabel lblPrincipalValor = new JLabel("Valor:");
		lblPrincipalValor.setBounds(10, 516, 58, 14);
		lblPrincipalValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalValor);

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(78, 477, 220, 24);
		cbCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Alimenta??o", "Transporte", "Recreativos", "Metas", "Fixos" }));
		frmPersonalExpenses.getContentPane().add(cbCategoria);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(78, 407, 325, 30);
		frmPersonalExpenses.getContentPane().add(txtFieldNome);
		txtFieldNome.setColumns(10);

		JButton btnDeletar = new JButton("Del");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deseja deletar esta linha?", "Aviso",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					int i = tableGastos.getSelectedRow();
					deldata.deletarDAO(tableGastos);
					model.removeRow(i);
					JOptionPane.showMessageDialog(null, "Item deletado com sucesso.");
				}
			}
		});
		btnDeletar.setBounds(145, 570, 113, 40);
		frmPersonalExpenses.getContentPane().add(btnDeletar);

		txtFieldValor = new JTextField();
		txtFieldValor.setBounds(78, 514, 86, 20);
		frmPersonalExpenses.getContentPane().add(txtFieldValor);
		txtFieldValor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("BAIXAR ADDON");
		lblNewLabel_1.setBounds(77, 450, 210, 14);
		frmPersonalExpenses.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 395, 636, 2);
		frmPersonalExpenses.getContentPane().add(separator);

		JButton btnAtualizarTabela = new JButton("Update");
		btnAtualizarTabela.setBounds(334, 570, 113, 40);
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoria = 0;
				if (cbCategoria.getSelectedItem().toString() == "Alimenta??o") {
					categoria = 1;
				} else if (cbCategoria.getSelectedItem().toString() == "Transporte") {
					categoria = 2;
				} else if (cbCategoria.getSelectedItem().toString() == "Recreativos") {
					categoria = 3;
				} else if (cbCategoria.getSelectedItem().toString() == "Metas") {
					categoria = 4;
				} else if (cbCategoria.getSelectedItem().toString() == "Fixos") {
					categoria = 5;
				}
				int row = tableGastos.getSelectedRow();
				int cellId = Integer.parseInt(tableGastos.getModel().getValueAt(row, 0).toString());
				editData.editarDAO(cellId, txtFieldNome.getText(), Float.parseFloat(txtFieldValor.getText()),
						categoria);
				bd.buscarDAO(tableGastos);
				JOptionPane.showMessageDialog(null, "Item editado com sucesso.");
			}
		});
		frmPersonalExpenses.getContentPane().add(btnAtualizarTabela);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(140, 11, 496, 373);
		frmPersonalExpenses.getContentPane().add(scrollPane);

		tableGastos = new JTable();
		tableGastos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tableGastos.getSelectedRow();
				txtFieldNome.setText(tableGastos.getModel().getValueAt(row, 1).toString());
				txtFieldValor.setText(tableGastos.getModel().getValueAt(row, 2).toString());
				cbCategoria.setSelectedItem(tableGastos.getModel().getValueAt(row, 3));
			}
		});

		Object[] column = { "ID", "Nome", "Valor", "Categoria" };
		Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		tableGastos.setModel(model);
		bd.buscarDAO(tableGastos);

		scrollPane.setViewportView(tableGastos);

		JButton btnCriar = new JButton("New");
		btnCriar.setBounds(523, 570, 113, 40);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int categoria = 0;
				if (cbCategoria.getSelectedItem().toString() == "Alimenta??o") {
					categoria = 1;
				} else if (cbCategoria.getSelectedItem().toString() == "Transporte") {
					categoria = 2;
				} else if (cbCategoria.getSelectedItem().toString() == "Recreativos") {
					categoria = 3;
				} else if (cbCategoria.getSelectedItem().toString() == "Metas") {
					categoria = 4;
				} else if (cbCategoria.getSelectedItem().toString() == "Fixos") {
					categoria = 5;
				}

				if (txtFieldNome.getText().equals("") || txtFieldValor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos obrigat?rios.");
				} else {
					String stringValor = txtFieldValor.getText().replace(",", ".");

					if (vd.validarNumero(txtFieldValor.getText()) == true) {

						id.inserirDAO(txtFieldNome.getText(), Float.parseFloat(stringValor), categoria);
						row[1] = txtFieldNome.getText();
						row[2] = txtFieldValor.getText();
						row[3] = cbCategoria.getSelectedItem();
						model.addRow(row);

						txtFieldNome.setText("");
						txtFieldValor.setText("");
						txtFieldNome.setText("");
						JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
						bd.buscarDAO(tableGastos);
					}

				}
			}
		});

		frmPersonalExpenses.getContentPane().add(btnCriar);

		
		
		cbFiltroCategoria.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (cbFiltroCategoria.getSelectedItem() == null) {

				} else {
					int categoria = 0;
					if (cbFiltroCategoria.getSelectedItem().toString() == "Alimenta??o") {
						categoria = 1;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Transporte") {
						categoria = 2;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Recreativos") {
						categoria = 3;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Metas") {
						categoria = 4;
					} else if (cbFiltroCategoria.getSelectedItem().toString() == "Fixos") {
						categoria = 5;
					}
					bd.buscarCategoria(tableGastos, categoria);
				}
			}
		});

		cbFiltroCategoria.setEditable(false);
		cbFiltroCategoria.setBounds(10, 81, 120, 25);
		cbFiltroCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Alimenta??o", "Transporte", "Recreativos", "Metas", "Fixos" }));
		frmPersonalExpenses.getContentPane().add(cbFiltroCategoria);

		JLabel lblNewLabel_2 = new JLabel("Categoria:");
		lblNewLabel_2.setBounds(10, 64, 76, 14);
		frmPersonalExpenses.getContentPane().add(lblNewLabel_2);

		JButton btnResetTable = new JButton("Reset Table");
		btnResetTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbFiltroCategoria.setSelectedItem(null);
				chkFiltroMaiorValor.setSelected(false);
				chkFiltroNome.setSelected(false);
				chkFiltroData.setSelected(false);
				bd.buscarDAO(tableGastos);
			}
		});

		btnResetTable.setBounds(15, 216, 105, 23);
		frmPersonalExpenses.getContentPane().add(btnResetTable);

	}
}
