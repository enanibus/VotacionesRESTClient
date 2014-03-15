package votaciones.models.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Voto
 * 
 */

@XmlRootElement
public class Voto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String ipCliente;
	private Respuesta respVoto;

	public Voto(int id, String ipCliente, Respuesta respVoto) {
		super();
		this.setId(id);
		this.setIpCliente(ipCliente);
		this.setRespVoto(respVoto);
	}

	public Voto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpCliente() {
		return ipCliente;
	}

	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}

	public Respuesta getRespVoto() {
		return respVoto;
	}

	public void setRespVoto(Respuesta respVoto) {
		this.respVoto = respVoto;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", ipCliente=" + ipCliente + ", respVoto="
				+ respVoto + "]";
	}

}
