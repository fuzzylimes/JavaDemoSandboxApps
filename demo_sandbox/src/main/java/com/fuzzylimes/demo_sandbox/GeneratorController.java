package com.fuzzylimes.demo_sandbox;

import com.fuzzylimes.demo_sandbox.model.Uuid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/generator")
public class GeneratorController {

    private Logger logger = LoggerFactory.getLogger(GeneratorController.class);

    @GetMapping("/uuid")
    public Uuid getUuid() {
        Uuid uuid = new Uuid();
        uuid.setUuid(UUID.randomUUID().toString());
        logger.info(String.format("New UUID generated: %s", uuid));
        return uuid;
    }

    @GetMapping("/uuid/{seed}")
    public Uuid getUuidSeed(@PathVariable("seed") String seed) {
        Uuid uuid = new Uuid();
        uuid.setUuid(UUID.nameUUIDFromBytes(seed.getBytes()).toString());
        logger.info(String.format("New UUID generated from %s: %s", seed, uuid));
        return uuid;
    }
}
