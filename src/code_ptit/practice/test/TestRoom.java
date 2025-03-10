package code_ptit.practice.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestRoom {
    private String id;
    private LocalDateTime start;
    private String roomId;

    public TestRoom(int id, String start, String roomId) {
        this.id = String.format("C%03d", id);
        this.start = LocalDateTime.parse(start, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        this.roomId = roomId;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public String getRoomId() {
        return roomId;
    }
}
