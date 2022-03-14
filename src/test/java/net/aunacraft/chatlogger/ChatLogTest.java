package net.aunacraft.chatlogger;

import net.aunacraft.chatlogger.entities.ChatLog;
import net.aunacraft.chatlogger.entities.ChatMessage;
import net.aunacraft.chatlogger.repository.ChatLogRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@DataJpaTest
public class ChatLogTest {

    @Autowired
    private ChatLogRepository repository;

    @Test
    public void save() {
        ChatLog chatLog = new ChatLog();

        ChatMessage chatMessage1 = new ChatMessage();
        chatMessage1.setMessage("Test1");
        chatMessage1.setTime(System.currentTimeMillis());
        chatMessage1.setDisplayName("FebanHD");
        chatMessage1.setUuid("dsad-dsadf-dsadsa-dsadas");

        ChatMessage chatMessage2 = new ChatMessage();
        chatMessage2.setMessage("Test2");
        chatMessage2.setTime(System.currentTimeMillis());
        chatMessage2.setDisplayName("ytendx");
        chatMessage2.setUuid("dsad-dsadf-dsadsa-dsadas");

        chatLog.setMessages(Arrays.asList(
                chatMessage1,
                chatMessage2
        ));
        this.repository.save(chatLog);

    }

    @Test
    public void get() {
        ChatLog log = this.repository.findById("dsa").orElseThrow(() -> new NullPointerException("Chat log is null"));
        System.out.println(log.getId());
        System.out.println("Messages:");
        for (ChatMessage message : log.getMessages()) {
            System.out.println(message.getDisplayName() + ": " + message.getMessage());
        }
    }
}
