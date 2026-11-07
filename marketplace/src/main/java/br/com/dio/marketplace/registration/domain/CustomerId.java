package br.com.dio.marketplace.registration.domain;

import java.util.UUID;

import org.springframework.util.Assert;

public record CustomerId(UUID id) {

    public CustomerId {
        Assert.notNull(id, "id must be not null");
    }

    public CustomerId() {
        this(UUID.randomUUID()); 
    }

}
