package br.com.sebastiao.junior.client.domain.country;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.core.EndpointReference;

import dev.sebastiaojunior.server.domain.country.GetCountryRequest;

public class CountryWsClient extends WebServiceGatewaySupport {
	
	@Value("${app.server.uri}")
	private String serverUri;
	
	@Value("${app.server.callback-action}")
	private String serverCallbackAction;
	
	@Value("${app.response-server.uri}")
	private String responseServerUri;
	
    public void getCountry(String name) throws URISyntaxException {
        
    	GetCountryRequest request = new GetCountryRequest();
        
        request.setName(name);
        
        var callback = new ActionCallback(new URI(serverCallbackAction));
        
        var responseEndpoint = new EndpointReference(new URI(responseServerUri));
        
        callback.setReplyTo(responseEndpoint);
        
        callback.setFaultTo(responseEndpoint);
        
        getWebServiceTemplate().marshalSendAndReceive(serverUri, request, callback);
    }
}
