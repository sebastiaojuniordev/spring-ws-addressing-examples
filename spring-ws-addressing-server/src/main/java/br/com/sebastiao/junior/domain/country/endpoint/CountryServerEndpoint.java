package br.com.sebastiao.junior.domain.country.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.addressing.server.annotation.Action;

import br.com.sebastiao.junior.domain.country.Countries;
import dev.sebastiaojunior.consumer.domain.country.ConsumeCountryRequest;
import dev.sebastiaojunior.consumer.domain.country.Currency;
import dev.sebastiaojunior.server.domain.country.Country;
import dev.sebastiaojunior.server.domain.country.GetCountryRequest;

@Endpoint
public class CountryServerEndpoint {

    private final Countries countries;

    public CountryServerEndpoint(Countries countries) {
        this.countries = countries;
    }

    @Action("http://www.sebastiaojunior.dev/server/domain/country/getCountry")
    @ResponsePayload
    public ConsumeCountryRequest getCountry(@RequestPayload final GetCountryRequest request) {
        var consumerResponse = new ConsumeCountryRequest();
        consumerResponse.setCountry(convertFrom(this.countries.findCountry(request.getName())));
        return consumerResponse;
    }

    private static dev.sebastiaojunior.consumer.domain.country.Country convertFrom(Country country) {
        var converted = new dev.sebastiaojunior.consumer.domain.country.Country();
        converted.setName(country.getName());
        converted.setPopulation(country.getPopulation());
        converted.setCapital(country.getCapital());
        converted.setCurrency(Currency.valueOf(country.getCurrency().name()));
        return converted;
    }
}
