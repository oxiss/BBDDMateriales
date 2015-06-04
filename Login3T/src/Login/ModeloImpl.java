package Login;

import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class ModeloImpl extends JFrame implements Modelo {
	private VistaLogInImpl vistaLI;
	private VistaSignInImpl vistaSI;
	private VistaWelcomeImpl vistaWE;
	private String usr2 = "System";
	private String pwd2 = "";
	private Connection conexion;
	private int counter = 0;
	private PreparedStatement pstmt;
	private Statement stmt;

	public ModeloImpl() {
		super();
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		try {
			conexion = DriverManager.getConnection(url, usr2, pwd2);
			System.out.println(" - Conexión con ORACLE establecida -");
		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	// Actualiza la tabla cada vez que se da de alta, borra ó modifica.
	public void ActualizaTabla() {
		
		
		System.out.println("vamos a escribir una linea nueva");
		
		String Actuact = "SELECT * FROM LOGIN.MATER";
		try {
			pstmt = conexion.prepareStatement(Actuact);
			ResultSet rset = pstmt.executeQuery();
			vistaWE.getTable().setModel(DbUtils.resultSetToTableModel(rset));
		} catch (SQLException e) {
			System.out.println("Error en ActualizaTabla.");
			e.printStackTrace();
		}
	}

	public void passCheck(JTextField usr, JPasswordField pss) {

		char[] pwd = pss.getPassword();
		String user = usr.getText();
		String newpss = new String(pwd);

		try {
			pstmt = conexion
					.prepareStatement("SELECT * FROM LOGIN.USUARIO where usuario=? AND Password=?");
			pstmt.setString(1, user);
			pstmt.setString(2, newpss);
			ResultSet rset = pstmt.executeQuery();

			if (rset.next()) {
				vistaWE.setVisible(true);
				ActualizaTabla();
				vistaLI.setVisible(false);
			} else if (counter == 2) {
				JOptionPane.showMessageDialog(null,
						"Has agotado el nº de intentos disponibles.", "El programa se cerrará",
						JOptionPane.WARNING_MESSAGE);
				System.exit(0);
			} else {
				counter++;
				JOptionPane.showMessageDialog(null,
						"Contraseña incorrecta, oportunidad " + counter
								+ "/3. Quedan " + (3 - counter) + " intentos.",
						"Error.", JOptionPane.WARNING_MESSAGE);
			}

			pstmt.close();
			rset.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void comprobarRegistro(JTextField usrReg, JPasswordField pss1Reg,
			JPasswordField pss2Reg, JTextField eml) {

		String nick = usrReg.getText();
		char[] pwd1 = pss1Reg.getPassword();
		char[] pwd2 = pss2Reg.getPassword();
		String pss1 = new String(pwd1);
		String pss2 = new String(pwd2);
		String email = eml.getText();
		int aux = 0;

		// Comprobacion de que el email es valido
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern
				.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		mat = pat.matcher(email);
		if (mat.find()) {
			aux++;
		} else {

		}
		// comprobacion de que el usuario no está vacío, que los password coinciden y que el email es valido
		if (nick.length() > 0 && pss1.equals(pss2) && pss1.length() > 0
				&& aux > 0) {
			try {
				pstmt = conexion
						.prepareStatement("SELECT * FROM LOGIN.USUARIO where usuario=? AND Password=?");
				pstmt.setString(1, nick);
				pstmt.setString(2, pss1);
				ResultSet rset = pstmt.executeQuery();

				if (!rset.next()) {
					String cadSQL = "INSERT INTO LOGIN.USUARIO VALUES ('"
							+ nick + "', '" + pss1 + "')";
					int insert = pstmt.executeUpdate(cadSQL);
				} 
				pstmt.close();
				rset.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			vistaLI.setVisible(true);
			vistaSI.setVisible(false);
			JOptionPane.showMessageDialog(null, "Usuario registrado.",
					"Correcto", JOptionPane.WARNING_MESSAGE);
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"Comprueba que el usuario no esta vacío, que las contraseñas coinciden y que ha escrito correctamente el Email",
							"Error.", JOptionPane.WARNING_MESSAGE);
		}

	}

	public void alta(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText) {
		String altact = "INSERT INTO LOGIN.MATER  VALUES (?,?,?)";
		

		if (cod_MatText.getText().equals("")) {
			JOptionPane.showMessageDialog(null,
					"No puedes dejar el campo de COD_MAT vacío.", "Error.",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				pstmt = conexion.prepareStatement(altact);
				pstmt.setString(2,cod_MatText.getText());
				pstmt.setString(1, nom_MatText.getText());
				pstmt.setString(3, cod_SubfText.getText());
				ResultSet rset = pstmt.executeQuery();
				ActualizaTabla();
				pstmt.close();
				rset.close();

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"No puede haber 2 COD_MAT iguales. ",
						"Error de tipo SQL.", JOptionPane.WARNING_MESSAGE);
				e.printStackTrace();
			}
		}

	}

	public void baja() {
		try {
			String bajact = "DELETE FROM LOGIN.MATER WHERE COD_MAT=?";
			pstmt = conexion.prepareStatement(bajact);
			String cod = (String) vistaWE.getTable().getModel().getValueAt(vistaWE.getTable().getSelectedRow(), 0);
			pstmt.setString(1, cod);
			ResultSet rset = pstmt.executeQuery();
			ActualizaTabla();
			pstmt.close();
			rset.close();

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Selecciona una fila que borrar.", "Error.",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void modificar(JTextField cod_MatText, JTextField nom_MatText, JTextField cod_SubfText) {
		try {
			
			String modact = "Update LOGIN.MATER set COD_MAT=?, NOM_MAT=?, COD_SUBF =? WHERE COD_MAT=? ";
			pstmt = conexion.prepareStatement(modact);
			pstmt.setString(2, cod_MatText.getText());
			pstmt.setString(1, nom_MatText.getText());
			pstmt.setString(3, cod_SubfText.getText());
			pstmt.setString(4, (String) vistaWE.getTable().getModel()
					.getValueAt(vistaWE.getTable().getSelectedRow(), 0));
			ResultSet rset = pstmt.executeQuery();
			ActualizaTabla();

			rset.close();
			pstmt.close();
		
			
		} catch (SQLException eX) {
			JOptionPane.showMessageDialog(null,
					"Selecciona una fila que modificar.", "Error.",
					JOptionPane.WARNING_MESSAGE);
		}

	}

}
