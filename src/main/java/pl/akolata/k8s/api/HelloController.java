package pl.akolata.k8s.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @Value("${my-env}")
    private String myEnv;

    @GetMapping(
            value = "/hello",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<HelloResponse> getHello() {
        HelloResponse response = new HelloResponse("Hello from", myEnv);
        return ResponseEntity.ok(response);
    }
}
