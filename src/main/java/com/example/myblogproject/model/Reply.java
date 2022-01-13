package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false, length = 200)
    private  String content;

    @ManyToOne
    @JoinColumn(name = "boardID")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;
}
