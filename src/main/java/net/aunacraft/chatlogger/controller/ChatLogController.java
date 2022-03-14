package net.aunacraft.chatlogger.controller;

import net.aunacraft.chatlogger.entities.ChatLog;
import net.aunacraft.chatlogger.entities.ChatMessage;
import net.aunacraft.chatlogger.exceptions.ChatLogNotFoundException;
import net.aunacraft.chatlogger.service.ChatLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chatlog/v1/")
public class ChatLogController {

    private final ChatLogService service;

    public ChatLogController(ChatLogService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ChatLog getChatLog(@RequestParam("id") Long id) {
        return service.loadChatLog(id);
    }

    @PostMapping("/create")
    public ResponseEntity<ChatLog> createChatLog(@RequestBody List<ChatMessage> messages) {
        return ResponseEntity.ok(this.service.createChatLog(messages));
    }

    @ExceptionHandler(ChatLogNotFoundException.class)
    public ResponseEntity<?> handleNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
