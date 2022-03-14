package net.aunacraft.chatlogger.service;

import net.aunacraft.chatlogger.entities.ChatLog;
import net.aunacraft.chatlogger.entities.ChatMessage;
import net.aunacraft.chatlogger.exceptions.ChatLogNotFoundException;
import net.aunacraft.chatlogger.repository.ChatLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatLogService {

    private final ChatLogRepository repository;

    public ChatLogService(ChatLogRepository repository) {
        this.repository = repository;
    }

    public ChatLog loadChatLog(Long id) {
        return repository.findById(id).orElseThrow(ChatLogNotFoundException::new);
    }

    public ChatLog createChatLog(List<ChatMessage> messages) {
        ChatLog chatLog = new ChatLog(messages);
        this.repository.save(chatLog);
        return chatLog;
    }
}
