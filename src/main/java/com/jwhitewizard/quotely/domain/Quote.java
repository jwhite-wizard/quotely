package com.jwhitewizard.quotely.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Quote {
    private String quoteText;
    private String quoteAuthor;

}
