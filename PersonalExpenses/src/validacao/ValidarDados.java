package validacao;

import javax.swing.JOptionPane;

public class ValidarDados {
	public boolean validarNumero(String _txtFieldValor) {
		boolean validado = false;
		int lenghtI = _txtFieldValor.length();
		
		if(_txtFieldValor.substring(0, lenghtI).matches("-?\\d+")) {
			validado = true;
		}else if(_txtFieldValor.isBlank()){
			
			JOptionPane.showMessageDialog(null, "Tipo de dado inserido incorretamente em: Campo Valor");
		}
		
		return validado;
	}
	
	public boolean validarPreenchimentodosCampos(String _txtFieldNome, String _txtFieldValor, int _categoria) {
		boolean validado = false;
		
		
		
		return validado;
	}
}
