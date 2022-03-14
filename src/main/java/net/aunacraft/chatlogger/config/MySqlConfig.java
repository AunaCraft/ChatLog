package net.aunacraft.chatlogger.config;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

@Configuration
public class MySqlConfig {

    private final Properties properties = new Properties();
    private final ChatLogProperties chatLogProperties;

    public MySqlConfig(ChatLogProperties chatLogProperties) {
        this.chatLogProperties = chatLogProperties;
    }

    @Bean
    public DataSource getDataSource() {
        File configDir = new File(chatLogProperties.getConfigDir());
        if(!configDir.exists())
            configDir.mkdir();

        File file = new File(configDir, chatLogProperties.getConfigFileName());
        FileReader reader = null;

        String host = "localhost";;
        int port = 3306;
        String userName = "root";
        String password = "";

        try {
            reader = new FileReader(file);
            properties.load(reader);
            host = properties.getProperty("host");
            port = Integer.parseInt(properties.getProperty("port"));
            userName = properties.getProperty("username");
            password = properties.getProperty("password");
        }catch (Exception e) {
            FileWriter writer = null;
            try {
                file.delete();
                file.createNewFile();
                properties.setProperty("host", host);
                properties.setProperty("port", String.valueOf(port));
                properties.setProperty("username", userName);
                properties.setProperty("password", password);
                writer = new FileWriter(file);
                properties.store(writer, "Config");
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }finally {
                if(writer != null)
                    IOUtils.closeQuietly(writer);
            }
        }finally {
            if(reader != null) {
                IOUtils.closeQuietly(reader);
            }
        }


        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://" + host + ":" + port + "/system");
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }
}
