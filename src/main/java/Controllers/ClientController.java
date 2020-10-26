package Controllers;

import Entities.Client;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

    private final RestTemplate template = new RestTemplate();
    private final String address = "http://clientserver:8085/client/";

    public ResponseEntity<Client> add(@RequestParam String name, @RequestParam String surname,
                                      @RequestParam double temperature) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name).
                queryParam("surname", surname).
                queryParam("temperature", temperature);
        HttpEntity<Client> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Client.class);
        return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<Object> report(@RequestParam UUID id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }

    public ResponseEntity<Object> delete(@RequestParam String name) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("name", name);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }


}
