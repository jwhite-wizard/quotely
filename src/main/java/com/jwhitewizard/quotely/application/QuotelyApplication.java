package com.jwhitewizard.quotely.application;

import com.jwhitewizard.quotely.client.QuotelyClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
}
