package com.jwhitewizard.quotely.application;

import com.jwhitewizard.quotely.client.QuotelyClient;
import com.jwhitewizard.quotely.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class QuotelyApplication {
    private static final Logger log = LoggerFactory.getLogger(QuotelyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(QuotelyApplication.class, args);
        if (args.length == 0 || args.length == 1 && ("English".equalsIgnoreCase(args[0]))) {
            log.info("English language accepted");
            QuotelyClient client = new QuotelyClient();
        } else if (args.length == 1 && ("Russian".equalsIgnoreCase(args[0]))) {
            log.info("Russian language accepted");
            QuotelyClient client = new QuotelyClient("ru");
        }
        System.exit(0);
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
//
//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
//        return args -> {
//            HttpHeaders headers = new HttpHeaders();
//            HttpEntity<String> entity = new HttpEntity<String>(headers);
//            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//            log.info("checking for language");
////            If no argument is input or there's only one arg and it is english
//            if (args.length == 0 || args.length == 1 && ("English".equalsIgnoreCase(args[0]))){
//                log.info("English language accepted");
//                ResponseEntity<String> quote = restTemplate.exchange("https://api.forismatic.com/api/1.0/?method=" +
//                        "getQuote&format=json&lang=en", HttpMethod.GET, entity, String.class);
//                System.out.println(quote);
//            } else if (args.length == 1 && ("Russian".equalsIgnoreCase(args[0]))) {
//                log.info("Russian language accepted");
//                ResponseEntity<String> quote = restTemplate.exchange("https://api.forismatic.com/api/1.0/?method=" +
//                        "getQuote&format=json&lang=ru", HttpMethod.GET, entity, String.class);
//                System.out.println(quote);
//            }
//        };
//    }
}
