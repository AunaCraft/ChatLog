package net.aunacraft.chatlogger.service;

import lombok.Getter;
import net.aunacraft.chatlogger.entities.APIKey;
import net.aunacraft.chatlogger.exceptions.InvalidAPIKeyException;
import net.aunacraft.chatlogger.repository.APIKeyRepository;
import org.springframework.stereotype.Service;

@Service
@Getter
public class APISecurityService {

    private final APIKeyRepository repository;

    public APISecurityService(APIKeyRepository repository) {
        this.repository = repository;
    }

    public void checkAPIKey(String apiKey) {
        APIKey key = repository.findById(apiKey).orElseThrow(InvalidAPIKeyException::new);
        key.use();
        repository.save(key);
    }

    public APIKey createAPIKey() {

        APIKey key = new APIKey();
        repository.saveAndFlush(key);
        return key;
    }

}
