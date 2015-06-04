package Login;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface Controlador {
	public void setModelo(Modelo modelo);

	public void setVistaLogInImpl(VistaLogInImpl vistaLI);

	public void setVistaSignInImpl(VistaSignInImpl vistaSI);

	public void setVistaWelcomeImpl(VistaWelcomeImpl vistaWE);

	public void mostrarRegistro();
	
	public void abrirLogIn();
	
	public void cerrarLogIn();
	
	public void registrarse(JTextField lblNick, JPasswordField lblContrasea, JPasswordField lblRepetirContrasea, JTextField textFieldEmail);
	
	public void pulsarAlta(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText);
	
	public void pulsarBaja();

	public void pulsarModificar(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText);

	public void pulsarLogIn(JTextField textFieldUsr, JPasswordField lblContrasea);

}
