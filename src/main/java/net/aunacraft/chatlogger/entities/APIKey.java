package net.aunacraft.chatlogger.entities;

import com.sun.istack.NotNull;
import net.aunacraft.chatlogger.entities.generators.APIKeyGenerator;
import net.aunacraft.chatlogger.entities.generators.ChatLogIDGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "chat_logger_api_keys")
public class APIKey {

    public APIKey() {
        this.accesses = 0L;
    }

    @Id
    @GeneratedValue(generator = APIKeyGenerator.generatorName)
    @GenericGenerator(name = APIKeyGenerator.generatorName, strategy = "net.aunacraft.chatlogger.entities.generators.APIKeyGenerator")
    private String apiKey;

    @NotNull
    private Long accesses;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getAccesses() {
        return accesses;
    }

    public void setAccesses(Long accesses) {
        this.accesses = accesses;
    }

    public void use() {
        accesses++;
    }
}
