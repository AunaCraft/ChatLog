package net.aunacraft.chatlogger;

import net.aunacraft.chatlogger.config.ChatLogProperties;
import net.aunacraft.chatlogger.entities.APIKey;
import net.aunacraft.chatlogger.service.APISecurityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ChatLogProperties.class)
public class ChatLoggerApplication {

    public ChatLoggerApplication(APISecurityService securityService) {
        if(securityService.getRepository().count() == 0) {
            APIKey key = securityService.createAPIKey();
            System.out.println("Admin-API-Key: " + key.getApiKey());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ChatLoggerApplication.class, args);
    }

}
