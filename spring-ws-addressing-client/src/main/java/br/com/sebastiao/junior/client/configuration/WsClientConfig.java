package br.com.sebastiao.junior.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import br.com.sebastiao.junior.client.domain.country.CountryWsClient;

@Configuration
public class WsClientConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("dev.sebastiaojunior.server.domain.country");
        return marshaller;
    }

    @Bean
    public CountryWsClient countryWsClient(Jaxb2Marshaller marshaller) {
        CountryWsClient client = new CountryWsClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
