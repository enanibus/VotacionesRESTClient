package votaciones.views.client;

import upm.jbb.IO;
import votaciones.controllers.client.VotacionesResourceClient;
import votaciones.controllers.client.VotarResourceClient;
import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

public class Main {
	VotarResourceClient vrc = new VotarResourceClient();
	VotacionesResourceClient vrc1 = new VotacionesResourceClient();
	
    public void verVotaciones() {
    	IO.out.println(vrc1.votaciones().toString());
    }
	
	public void votar() {
		Object[] c = { 0, "localhost", Respuesta.SI };
		String[] s = { "id", "ipCliente", "respVoto" };
		Object[] v = IO.in.readForm(c, s);
		Voto voto = new Voto((int) v[0], (String) v[1], (Respuesta) v[2]);
		boolean result = vrc.votar(voto);
		if (result)
			IO.out.setStatusBar("Voto correcto");
		else
			IO.out.setStatusBar("No se ha podido realizar la votación");
	}

	public static void main(String[] args) {
		IO.in.addController(new Main());
		IO.in.println("Pregunta: ¿CREES QUE LA SITUACIÓN ECONÓMICA DE ESPAÑA VA A MEJORAR?");
	}

}
