package votaciones.controllers.client;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import votaciones.models.entities.Respuesta;
import votaciones.models.entities.Voto;

public class VotarResourceClient {
    private String uri = "http://miw18.calamar.eui.upm.es:8080/VotacionesRESTServer/rest/voto";

    /**
     * @param voto
     * @return true si se puede crear el voto, false si el idVoto está ocupado
     */
    public boolean votar(Voto voto) {
        Client client = Client.create(new DefaultClientConfig());
        WebResource wr = client.resource(UriBuilder.fromUri(uri).build());
        ClientResponse response = wr.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,
                voto);
        Logger.getLogger(VotarResourceClient.class).info("POST/" + response.getStatus());
        return response.getStatus() == 201;
    }

    public static void main(String[] args) {
        VotarResourceClient vrc = new VotarResourceClient();
        Voto v = new Voto(0, "localhost", Respuesta.SI);
        vrc.votar(v);

    }
}
