package Login;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaLogInImpl extends JFrame implements VistaLogIn{
	
	private VistaSignIn vistaSI;
	private VistaWelcome vistaWE;
	private Modelo modelo;
	private Controlador controlador;
	
	private JPanel contentPane;
	private JPasswordField passwordFieldPass;
	private JTextField textFieldUsr;
	private JButton btnLogOut;
	private JButton btnLogin;
	private JButton btnSignin;
	private JLabel lblContrasea;
	private JLabel lblUsuario;
		
	public void setVistaSignIn(VistaSignIn vistaSI){
		this.vistaSI = vistaSI;
	}
	public void setVistaWelcome(VistaWelcome vistaWE){
		this.vistaWE = vistaWE;
	}
	public void setModelo(Modelo modelo){
		this.modelo = modelo;
	}
	public void setControlador(Controlador controlador){
		this.controlador = controlador;
	}
	
	public JPasswordField getPass(){
		return passwordFieldPass;
	}
	
	public JTextField getUser(){
		return textFieldUsr;
	}
	public VistaLogInImpl() {
		
		setTitle("LOG IN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblUsuario = new JLabel("Usuario");
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		
		btnLogin = new JButton("LogIn");
						
		btnSignin = new JButton("SignIn");
		
		btnLogOut = new JButton("LogOut");
				
		passwordFieldPass = new JPasswordField();
		
		textFieldUsr = new JTextField();
		
		textFieldUsr.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContrasea)
								.addComponent(lblUsuario))
							.addGap(83)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldUsr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordFieldPass, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(42)
							.addComponent(btnSignin)
							.addGap(40)
							.addComponent(btnLogin)
							.addGap(55)
							.addComponent(btnLogOut)))
					.addGap(381))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsuario)
						.addComponent(textFieldUsr, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordFieldPass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSignin)
						.addComponent(btnLogin)
						.addComponent(btnLogOut))
					.addGap(63))
		);
		getContentPane().setLayout(groupLayout);
	
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.mostrarRegistro();
			}
		});
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.cerrarLogIn();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pulsarLogIn(textFieldUsr, passwordFieldPass);
			}
		});
	}
	
}
