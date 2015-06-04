package Login;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class VistaSignInImpl extends JFrame implements VistaSignIn {
	
	private VistaLogIn vistaLI;
	private Modelo modelo;
	private Controlador controlador;
	private JTextField textFieldNom;
	private JTextField textFieldApe;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldPass1;
	private JPasswordField passwordFieldPass2;
	private JTextField textFieldNick;
	private JButton btnNewButtonReg;
	private JButton btnNewButtonCancel;
	private JLabel lblNick;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblEmail;
	private JLabel lblContrasea;
	private JLabel lblRepetirContrasea;

	public void setVistaLogIn(VistaLogIn vistaLI) {
		this.vistaLI = vistaLI;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	public JTextField getNick(){
		return textFieldNick;
	}
	
	public JPasswordField getPass1(){
		return passwordFieldPass1;
	}
	
	public JPasswordField getPass2(){
		return passwordFieldPass2;
	}
	
	public VistaSignInImpl() {
		
		setTitle("SIGN IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		lblNick = new JLabel("Usuario");
		
		lblNombre = new JLabel("Nombre");
		
		lblApellidos = new JLabel("Apellidos");
		
		lblEmail = new JLabel("Email");
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		
		lblRepetirContrasea = new JLabel("Repetir Contrase\u00F1a");
		
		textFieldNick = new JTextField();
		textFieldNick.setColumns(10);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		
		textFieldApe = new JTextField();
		textFieldApe.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		
		passwordFieldPass1 = new JPasswordField();
		
		passwordFieldPass2 = new JPasswordField();
		
		btnNewButtonReg = new JButton("Register");
		
		btnNewButtonCancel = new JButton("Cancel");
		
	
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNick)
						.addComponent(lblNombre)
						.addComponent(lblApellidos)
						.addComponent(lblEmail)
						.addComponent(lblContrasea)
						.addComponent(lblRepetirContrasea))
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordFieldPass2)
						.addComponent(textFieldEmail)
						.addComponent(textFieldApe)
						.addComponent(textFieldNom)
						.addComponent(textFieldNick)
						.addComponent(passwordFieldPass1))
					.addPreferredGap(ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButtonReg)
						.addComponent(btnNewButtonCancel))
					.addGap(34))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNick)
						.addComponent(textFieldNick, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(textFieldNom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblApellidos)
						.addComponent(textFieldApe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButtonReg))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasea)
								.addComponent(passwordFieldPass1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRepetirContrasea)
								.addComponent(passwordFieldPass2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnNewButtonCancel)))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		btnNewButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.abrirLogIn();
			}
		});
		btnNewButtonReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.registrarse(textFieldNick, passwordFieldPass1, passwordFieldPass2, textFieldEmail);
			}
		});
		
	}
}
