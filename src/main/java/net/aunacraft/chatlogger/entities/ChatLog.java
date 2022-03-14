package net.aunacraft.chatlogger.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chat_logger_logs")
@NoArgsConstructor
public class ChatLog {

    @Id
    @GeneratedValue(generator = ChatLogIDGenerator.generatorName)
    @GenericGenerator(name = ChatLogIDGenerator.generatorName, strategy = "net.aunacraft.chatlogger.entities.ChatLogIDGenerator")
    private String id;


    @ElementCollection
    @CollectionTable(
            name = "chat_logger_messages",
            joinColumns = @JoinColumn(name = "LOG_ID")
    )
    private List<ChatMessage> messages;

    public ChatLog(List<ChatMessage> messages) {
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ChatMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ChatMessage> messages) {
        this.messages = messages;
    }
}
