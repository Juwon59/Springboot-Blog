package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob //대용량 데이터 쓸 때 사용
    private String content; //썸머노트 라이브러리 <html>태그 섞여서 디자인 됨.

    @ColumnDefault("0")
    private int count; //조회수

    @ManyToOne(fetch = FetchType.EAGER) //Many = Board, User = One 한명의 유저는 여러개의 게시글 작성 가능
    @JoinColumn(name = "userID")
    private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board",fetch = FetchType.EAGER) //한개의 게시글은 여러개의 댓글을 가질 수 있다. //mappedBy 연관관계의 주인이 아니다.(난 table에 생성되는 FK가 아님) DB에 칼럼 만들지마
    //@JoinColumn(name = "ReplyID")
    private List<Reply> reply; //reply는 한개가 아니라 여러건이라 List

    @CreationTimestamp
    private Timestamp createDate; //작성 날짜
}
