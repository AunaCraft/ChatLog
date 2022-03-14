package net.aunacraft.chatlogger.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat_logger_logs")
@NoArgsConstructor
public class ChatLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ElementCollection
    @CollectionTable(
            name = "chat_logger_messages",
            joinColumns = @JoinColumn(name = "LOG_ID")
    )
    private List<ChatMessage> messages;

    public ChatLog(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
