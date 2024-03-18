package com.slime.websockets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents a message with a sender and text content.
 */
@Data
@AllArgsConstructor
public class Message {
    /**
     * The sender of the message.
     */
    private String from;

    /**
     * The text content of the message.
     */
    private String text;
}