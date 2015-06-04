package Login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorImpl extends JFrame implements Controlador {
	private Modelo modelo;
	private VistaLogInImpl vistaLI;
	private VistaSignInImpl vistaSI;
	private VistaWelcomeImpl vistaWE;

	public ControladorImpl() {
		super();
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setVistaLogInImpl(VistaLogInImpl vistaLI) {
		this.vistaLI = vistaLI;
	}

	public void setVistaSignInImpl(VistaSignInImpl vistaSI) {
		this.vistaSI = vistaSI;
	}

	public void setVistaWelcomeImpl(VistaWelcomeImpl vistaWE) {
		this.vistaWE = vistaWE;
	}

	public void mostrarRegistro() {
		vistaSI.setVisible(true);
		vistaLI.setVisible(false);
	}

	public void abrirLogIn() {
		vistaLI.setVisible(true);
		vistaSI.setVisible(false);
	}

	public void cerrarLogIn() {
		System.exit(0);
	}

	public void pulsarLogIn(JTextField lblUsuario, JPasswordField lblContrasea) {
		modelo.passCheck(lblUsuario, lblContrasea);
	}

	public void registrarse(JTextField lblNick, JPasswordField lblContrasea, JPasswordField lblRepetirContrasea, JTextField textFieldEmail) {
		modelo.comprobarRegistro(lblNick, lblContrasea, lblRepetirContrasea, textFieldEmail);
	}
	
	public void pulsarAlta(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText){
		modelo.alta(cod_MatText,nom_MatText,cod_SubfText);
	}
	
	public void pulsarBaja(){
		modelo.baja();
	}

	public void pulsarModificar(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText) {
		modelo.modificar(cod_MatText,nom_MatText,cod_SubfText);
		
	}

}
