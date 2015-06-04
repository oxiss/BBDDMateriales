package Login;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaWelcomeImpl extends JFrame {

	private Modelo modelo;
	private Controlador controlador;
	private JTable table;
	private JButton AltaButton;
	private JButton btnBaja;
	private JButton btnSalir;
	private JButton btnModificacin;
	private JTextField cod_MatText;
	private JTextField nom_MatText;
	private JTextField cod_SubfText;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public JTextField getCod_Mat() {
		return nom_MatText;
	}

	public JTextField getNom_Mat() {
		return cod_MatText;
	}

	public JTextField getCod_Subf() {
		return cod_SubfText;
	}

	public DefaultTableModel getMod() {
		return model;
	}

	public JTable getTable() {
		return table;
	}

	public VistaWelcomeImpl() {
		super("Materiales.");
		setTitle(" ");
		initialize();
	}

	public void initialize() {

		setBounds(100, 100, 450, 351);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cod_MatText = new JTextField("");
		cod_MatText.setColumns(10);

		nom_MatText = new JTextField("");
		nom_MatText.setColumns(10);

		cod_SubfText = new JTextField("");
		cod_SubfText.setColumns(10);

		scrollPane = new JScrollPane();

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"COD_MAT:", "NOM_MAT:", "COD_SUBF:" }));

		model = (DefaultTableModel) table.getModel();

		// Provide us to add a column to the table.
		AltaButton = new JButton("Alta.");
		AltaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.pulsarAlta(cod_MatText, nom_MatText, cod_SubfText);

			}
		});

		btnBaja = new JButton("Baja.");
		btnBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.pulsarBaja();

			}
		});

		btnModificacin = new JButton("Modificacion.");
		btnModificacin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				controlador.pulsarModificar(cod_MatText, nom_MatText, cod_SubfText);

			}
		});

		btnSalir = new JButton("Salir.");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(43)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPane,
																GroupLayout.PREFERRED_SIZE,
																360,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(5)
																		.addComponent(
																				cod_MatText,
																				GroupLayout.PREFERRED_SIZE,
																				113,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				nom_MatText,
																				GroupLayout.PREFERRED_SIZE,
																				112,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				cod_SubfText,
																				GroupLayout.PREFERRED_SIZE,
																				107,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				AltaButton)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				btnBaja)
																		.addGap(59)
																		.addComponent(
																				btnModificacin)
																		.addGap(18)
																		.addComponent(
																				btnSalir)))
										.addGap(31)));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(27)
										.addComponent(scrollPane,
												GroupLayout.PREFERRED_SIZE,
												103, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																cod_MatText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																nom_MatText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																cod_SubfText,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED,
												134, Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																AltaButton)
														.addComponent(btnBaja)
														.addComponent(
																btnModificacin)
														.addComponent(btnSalir))));

		scrollPane.setViewportView(table);
		getContentPane().setLayout(groupLayout);

	}

}