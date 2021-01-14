package br.com.sebastiao.junior.client.domain.country;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.core.EndpointReference;

import dev.sebastiaojunior.server.domain.country.GetCountryRequest;

public class CountryWsClient extends WebServiceGatewaySupport {
	
    public void getCountry(String name) throws URISyntaxException {
        
    	GetCountryRequest request = new GetCountryRequest();
        
        request.setName(name);
        
        var callback = new ActionCallback(new URI("http://www.sebastiaojunior.dev/server/domain/country/getCountry"));
        
        var responseEndpoint = new EndpointReference(new URI("http://localhost:8282/ws"));
        
        callback.setReplyTo(responseEndpoint);
        
        callback.setFaultTo(responseEndpoint);
        
        getWebServiceTemplate().marshalSendAndReceive("http://localhost:8181/ws", request, callback);
    }
}
