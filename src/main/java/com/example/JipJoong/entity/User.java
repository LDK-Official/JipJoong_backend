package com.example.JipJoong.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private Provider provider;

    @Column(name = "profile_image", length = 255)
    private String profileImage;

    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @Builder
    public User(String userName, String email, String number, Provider provider, String profileImage) {
        this.userName = userName;
        this.email = email;
        this.number = number;
        this.provider = provider;
        this.profileImage = profileImage;
        this.createAt = LocalDateTime.now();
    }

    public enum Provider {
        LOCAL, KAKAO, GOOGLE, NAVER
    }

}
