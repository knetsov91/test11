package com.site.pathfinder2024;

import com.site.pathfinder2024.model.UserRoles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pathfinder2024Application {

    public static void main(String[] args) {
        SpringApplication.run(Pathfinder2024Application.class, args);

        UserRoles.ADMIN.ordinal();
    }

}
