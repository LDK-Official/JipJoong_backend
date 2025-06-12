package com.example.JipJoong.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "focus_session")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FocusSession {

    @Id
    @GeneratedValue
    @Column(name = "session_id", columnDefinition = "BINARY(16)")
    private UUID ssessionid;

    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID userId;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "was_interrupted")
    private Integer wasInterrupted;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Builder
    public FocusSession(UUID userId, LocalDateTime startTime, LocalDateTime endTime, Integer duration, Integer wasInterrupted) {
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.wasInterrupted = wasInterrupted;
        this.createAt = LocalDateTime.now();
    }
}
