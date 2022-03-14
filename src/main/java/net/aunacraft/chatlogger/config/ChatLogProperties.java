package net.aunacraft.chatlogger.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("database-config")
@Data
public class ChatLogProperties {

    /**
     * Folder location for storing files
     */
    private String configFileName = "database.properties";
    private String configDir = "config";

}
