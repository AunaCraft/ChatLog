package net.aunacraft.chatlogger.controller;

import com.fasterxml.jackson.core.JsonParseException;
import net.aunacraft.chatlogger.entities.ChatLog;
import net.aunacraft.chatlogger.entities.ChatMessage;
import net.aunacraft.chatlogger.exceptions.ChatLogNotFoundException;
import net.aunacraft.chatlogger.exceptions.InvalidAPIKeyException;
import net.aunacraft.chatlogger.service.APISecurityService;
import net.aunacraft.chatlogger.service.ChatLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("chatlog/v1/")
@CrossOrigin
public class ChatLogController {

    private final ChatLogService service;
    private final APISecurityService securityService;

    public ChatLogController(ChatLogService service, APISecurityService securityService) {
        this.service = service;
        this.securityService = securityService;
    }

    @GetMapping("/get/{logID}")
    public ResponseEntity<ChatLog> getChatLog(@PathVariable String logID) {
        System.out.println("Rewuerst: " + logID);
        return ResponseEntity.ok(service.loadChatLog(logID));
    }

    @PostMapping("/create/{apiKey}")
    public ResponseEntity<?> createChatLog(@RequestBody List<ChatMessage> messages, @PathVariable String apiKey) {
        securityService.checkAPIKey(apiKey);
        return ResponseEntity.ok(this.service.createChatLog(messages));
    }

    @ExceptionHandler(ChatLogNotFoundException.class)
    public ResponseEntity<?> handleNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<?> handleJsonParseError(JsonParseException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidAPIKeyException.class)
    public ResponseEntity<?> handleInvalidAPIKey() {
        return new ResponseEntity<>("Invalid API-Key", HttpStatus.FORBIDDEN);
    }


}
