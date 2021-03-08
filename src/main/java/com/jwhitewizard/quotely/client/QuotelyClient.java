package com.jwhitewizard.quotely.client;

import com.jwhitewizard.quotely.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class QuotelyClient {
    private WebClient client;
    private String language;
    private Mono<Quote> result;
    private static final Logger log = LoggerFactory.getLogger(QuotelyClient.class);

    public QuotelyClient() {
        new QuotelyClient("en");
    }

    public QuotelyClient(String language){
        log.info("preparing to retrieve a quote in " + ((language.equals("en")) ? "English" : "Russian"));
        client = WebClient.create("https://api.forismatic.com");
        result = client.get().uri(uriBuilder -> uriBuilder.path("/api/1.0/")
                .queryParam("method", "getQuote")
                .queryParam("format", "json")
                .queryParam("lang", language)
                .build()
        ).retrieve().bodyToMono(Quote.class);
        log.info("completed the call");
        Quote quote = result.block();
        System.out.println("\'" + quote.getQuoteText() + "\'");
        System.out.println("- " + quote.getQuoteAuthor());
    }
}
