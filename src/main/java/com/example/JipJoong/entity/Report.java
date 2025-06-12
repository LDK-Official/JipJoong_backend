package com.example.JipJoong.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "report")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Report {

    @Id
    @GeneratedValue
    @Column(name = "report_id", columnDefinition = "BINARY(16)")
    private UUID reportId;

    @Column(name = "session_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID sessionId;

    @Column(name = "summary_text", nullable = false)
    private String summaryText;

    @Lob
    @Column(name = "keywords")
    private String keywords;

    @Lob
    @Column(name = "quiz", columnDefinition = "JSON")
    private String quiz;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Builder
    public Report(UUID sessionId, String summaryText, String keywords, String quiz, LocalDateTime createAt) {
        this.sessionId = sessionId;
        this.summaryText = summaryText;
        this.keywords = keywords;
        this.quiz = quiz;
        this.createAt = createAt == null ? LocalDateTime.now() : createAt;
    }
}
