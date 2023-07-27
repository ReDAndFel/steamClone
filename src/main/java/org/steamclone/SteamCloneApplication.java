package org.steamclone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "org.steamclone.repositories")
public class SteamCloneApplication {
    public static void main(String[] args) {
        SpringApplication.run(SteamCloneApplication.class, args);
    }
}
