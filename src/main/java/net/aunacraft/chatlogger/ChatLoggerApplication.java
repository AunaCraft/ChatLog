package net.aunacraft.chatlogger;

import net.aunacraft.chatlogger.config.ChatLogProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ChatLogProperties.class)
public class ChatLoggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatLoggerApplication.class, args);
    }

}
