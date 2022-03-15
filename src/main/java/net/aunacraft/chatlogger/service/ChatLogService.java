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

    /**
        Get an chatlog by chatlog id wich is already in the repo
        <p>
        @throw ChatLogNotFoundException
    **/
    public ChatLog loadChatLog(String id) {
        return repository.findById(id).orElseThrow(ChatLogNotFoundException::new);
    }

    /**
        This method provides you a translation from a list of messages to an chatlog 
        it also gets saved to the repository where you are able to load it out of (ChatLog Cache)
    **/
    public ChatLog createChatLog(List<ChatMessage> messages) {
        ChatLog chatLog = new ChatLog(messages);
        // Put it into repository cache
        this.repository.save(chatLog);
        return chatLog;
    }
}
