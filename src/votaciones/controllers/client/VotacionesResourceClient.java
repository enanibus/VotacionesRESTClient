package votaciones.controllers.client;

import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import votaciones.models.entities.Voto;

public class VotacionesResourceClient {
    private String uri = "http://miw18.calamar.eui.upm.es:8080/VotacionesRESTServer/rest/votaciones";

    public List<Voto> votaciones() {
    	
    	Client client = Client.create(new DefaultClientConfig());
		WebResource wr = client.resource(UriBuilder.fromUri(uri).build());
    	
		List<Voto> list = wr.accept(MediaType.APPLICATION_JSON)
				.get(new GenericType<List<Voto>>() {});

        ClientResponse response = wr.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        Logger.getLogger(VotacionesResourceClient.class).info("GET/" + response.getStatus());
        return list;
    }

    public static void main(String[] args) {
        VotacionesResourceClient vrc = new VotacionesResourceClient();
        vrc.votaciones();
    }
}
