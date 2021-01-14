package br.com.sebastiao.junior.client.resource;

import java.net.URISyntaxException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sebastiao.junior.client.domain.country.CountryWsClient;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestResource {
	
	private final CountryWsClient client;

    @RequestMapping("/")
    public String check() throws URISyntaxException {
    	return "It's working!";
    }
    
    @RequestMapping("/default")
    public void kick() throws URISyntaxException {
        String name = "Poland";
        client.getCountry(name);
    }
    
    @RequestMapping("/test")
    public void test(@RequestParam("name") String name) throws URISyntaxException {
        client.getCountry(name);
    }
}
