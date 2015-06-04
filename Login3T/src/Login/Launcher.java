package Login;

public  class Launcher{
	private Launcher() {
		super();
	}

	private void ejecuta(){
		VistaLogInImpl vistaLI = new VistaLogInImpl();
		VistaSignInImpl vistaSI = new VistaSignInImpl();
		VistaWelcomeImpl vistaWE = new VistaWelcomeImpl();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();
		modelo.setVistaLogInImpl(vistaLI);
		modelo.setVistaSignInImpl(vistaSI);
		modelo.setVistaWelcomeImpl(vistaWE);
		vistaLI.setControlador(controlador);
		vistaSI.setControlador(controlador);
		vistaWE.setControlador(controlador);
		vistaLI.setModelo(modelo);
		vistaSI.setModelo(modelo);
		vistaWE.setModelo(modelo);
		controlador.setModelo(modelo);
		controlador.setVistaLogInImpl(vistaLI);
		controlador.setVistaSignInImpl(vistaSI);
		controlador.setVistaWelcomeImpl(vistaWE);
		vistaLI.setVistaSignIn(vistaSI);
		vistaSI.setVistaLogIn(vistaLI);
		vistaLI.setVisible(true);
		
	}

	public static void main(String[] args){
		new Launcher().ejecuta();
	}
}
