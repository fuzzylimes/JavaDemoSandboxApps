package com.fuzzylimes.demo_sandbox.model;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Uuid {
    @JsonProperty("id")
    private String uuid;
}
