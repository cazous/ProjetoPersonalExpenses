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
		frmPersonalExpenses.setSize(662, 556);
		frmPersonalExpenses.setResizable(false);
		frmPersonalExpenses.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPersonalExpenses.getContentPane().setLayout(null);

		JButton btnMensal = new JButton("Mensal");
		btnMensal.setEnabled(false);
		btnMensal.setForeground(new Color(0, 0, 0));
		btnMensal.setBackground(new Color(176, 196, 222));
		btnMensal.setBounds(0, 0, 120, 40);
		frmPersonalExpenses.getContentPane().add(btnMensal);

		Box verticalBoxFiltros = Box.createVerticalBox();
		verticalBoxFiltros.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.setBounds(0, 68, 120, 103);
		frmPersonalExpenses.getContentPane().add(verticalBoxFiltros);

		JCheckBox chkFiltroMaiorValor = new JCheckBox("Maior Valor");
		chkFiltroMaiorValor.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.add(chkFiltroMaiorValor);

		JCheckBox chkFiltroCategoria = new JCheckBox("Categoria");
		chkFiltroCategoria.setBackground(SystemColor.activeCaption);
		verticalBoxFiltros.add(chkFiltroCategoria);

		JCheckBox chkFiltroNome = new JCheckBox("Nome");
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

		JLabel lblNewLabel = new JLabel("Total do mês");
		lblNewLabel.setBounds(10, 175, 120, 23);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frmPersonalExpenses.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(10, 197, 120, 67);
		frmPersonalExpenses.getContentPane().add(panel);

		JLabel lblPrincipalNome = new JLabel("Nome:");
		lblPrincipalNome.setBounds(10, 294, 58, 14);
		lblPrincipalNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalNome);

		JLabel lblPrincipalData = new JLabel("Data:");
		lblPrincipalData.setBounds(10, 328, 58, 14);
		lblPrincipalData.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalData);

		JLabel lblPrincipalCategoria = new JLabel("Categoria:");
		lblPrincipalCategoria.setBounds(10, 362, 58, 14);
		lblPrincipalCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalCategoria);

		JLabel lblPrincipalValor = new JLabel("Valor:");
		lblPrincipalValor.setBounds(10, 396, 58, 14);
		lblPrincipalValor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmPersonalExpenses.getContentPane().add(lblPrincipalValor);

		JComboBox cbCategoria = new JComboBox();
		cbCategoria.setBounds(78, 357, 220, 24);
		cbCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Alimentação", "Transporte", "Recreativos", "Metas", "Fixos" }));
		frmPersonalExpenses.getContentPane().add(cbCategoria);

		txtFieldNome = new JTextField();
		txtFieldNome.setBounds(78, 287, 325, 30);
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
		btnDeletar.setBounds(145, 446, 113, 40);
		frmPersonalExpenses.getContentPane().add(btnDeletar);

		txtFieldValor = new JTextField();
		txtFieldValor.setBounds(78, 394, 86, 20);
		frmPersonalExpenses.getContentPane().add(txtFieldValor);
		txtFieldValor.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("BAIXAR ADDON");
		lblNewLabel_1.setBounds(77, 330, 210, 14);
		frmPersonalExpenses.getContentPane().add(lblNewLabel_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 275, 636, 2);
		frmPersonalExpenses.getContentPane().add(separator);

		JButton btnAtualizarTabela = new JButton("Update");
		btnAtualizarTabela.setBounds(334, 446, 113, 40);
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int categoria = 0;
				if (cbCategoria.getSelectedItem().toString() == "Alimentação") {
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

		scrollPane.setBounds(140, 11, 496, 252);
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
		btnCriar.setBounds(523, 446, 113, 40);
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int categoria = 0;
				if (cbCategoria.getSelectedItem().toString() == "Alimentação") {
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
				
				//vd.validarNumero(txtFieldValor.getText());

				if (txtFieldNome.getText().equals("") || txtFieldValor.getText().equals("")
						|| cbCategoria.getSelectedItem().equals(null)) {
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos obrigatórios.");
				} else {
					id.inserirDAO(txtFieldNome.getText(), Float.parseFloat(txtFieldValor.getText()), categoria);
					row[1] = txtFieldNome.getText();
					row[2] = txtFieldValor.getText();
					row[3] = cbCategoria.getSelectedItem();
					model.addRow(row);

					txtFieldNome.setText("");
					txtFieldValor.setText("");
					txtFieldNome.setText("");
					cbCategoria.setSelectedItem(null);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
					bd.buscarDAO(tableGastos);
				}
			}
		});
		
		frmPersonalExpenses.getContentPane().add(btnCriar);

	}
}
