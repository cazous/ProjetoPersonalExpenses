package validacao;

import javax.swing.JOptionPane;

public class ValidarDados {
	public boolean validarNumero(String _txtFieldValor) {
		boolean validado = false;
		int lenghtI = _txtFieldValor.length();
		
		if(_txtFieldValor.substring(0, lenghtI).matches("^\\d+(\\.|,|\\d+)*$")) {
			validado = true;
		}else {
			JOptionPane.showMessageDialog(null, "Tipo de dado inserido incorretamente em: Campo Valor");
		}
		
		return validado;
	}
	
	/*
	 * public boolean validarData() { boolean validado = false;
	 * return validado; }
	 */
}
