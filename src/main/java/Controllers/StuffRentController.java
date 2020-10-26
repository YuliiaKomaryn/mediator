package Controllers;

import Entities.Stuff;
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
@RequestMapping(value = "/stuff")
public class StuffRentController {


    private final RestTemplate template = new RestTemplate();
    private final String address = "http://stuffrentserver:8087/pass/";


    public ResponseEntity<Stuff> add(@RequestParam String type, @RequestParam int price) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("type", type).
                queryParam("price", price);
        HttpEntity<Stuff> response = template.exchange(builder.toUriString(), HttpMethod.POST, null, Stuff.class);
        return ResponseEntity.ok(response.getBody());
    }


    public ResponseEntity<Object> report(@RequestParam UUID id) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("id", id);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.GET, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }



    public ResponseEntity<Object> delete(@RequestParam String type) {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(address).
                queryParam("type", type);
        HttpEntity<Object> response = template.exchange(builder.toUriString(), HttpMethod.DELETE, null, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
}
