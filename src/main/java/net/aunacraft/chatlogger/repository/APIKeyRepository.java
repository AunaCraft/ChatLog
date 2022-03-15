package net.aunacraft.chatlogger.repository;

import net.aunacraft.chatlogger.entities.APIKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface APIKeyRepository extends JpaRepository<APIKey, String> {
}
