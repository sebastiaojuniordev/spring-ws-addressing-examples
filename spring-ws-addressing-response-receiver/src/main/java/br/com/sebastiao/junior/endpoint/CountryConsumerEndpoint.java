package br.com.sebastiao.junior.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

import dev.sebastiaojunior.consumer.domain.country.ConsumeCountryRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Endpoint
public class CountryConsumerEndpoint {
	
	@Action("http://www.sebastiaojunior.dev/server/domain/country/getCountryResponse")
    @ResponsePayload
    public void consumeCountry(@RequestPayload final ConsumeCountryRequest request) {
        var country = request.getCountry();
        log.info("Country {} with the capital {}, population {}, and currency {}", country.getName(),
                country.getCapital(), country.getPopulation(), country.getCurrency());
    }
}
