package net.aunacraft.chatlogger.repository;

import net.aunacraft.chatlogger.entities.ChatLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatLogRepository extends JpaRepository<ChatLog, String> {



}
