package net.aunacraft.chatlogger.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
@Data
public class ChatMessage {

    private Long time;

    private String uuid;

    private String displayName;

    private String message;

}
