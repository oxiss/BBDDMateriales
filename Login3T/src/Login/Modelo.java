package Login;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public interface Modelo {
	public void setVistaLogInImpl(VistaLogInImpl vistaLI);

	public void setVistaSignInImpl(VistaSignInImpl vistaSI);

	public void setVistaWelcomeImpl(VistaWelcomeImpl vistaWE);
	
	public void passCheck(JTextField usr, JPasswordField pss);
	
	public void comprobarRegistro(JTextField usrReg, JPasswordField pss1Reg, JPasswordField pss2Reg, JTextField textFieldEmail);
	
	public void alta(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText);
	
	public void baja();

	public void modificar(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText);
}
