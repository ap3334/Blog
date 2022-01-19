package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> Java(다른 언어 포함) Object -> table로 매핑

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // 빌더 패턴
@Entity // User 클래스가 MySQL에 테이블이 생성됨
public class User {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라감
    private int id; //시퀀스, auto-increment

    @Column(nullable = false, length = 30)
    private String userName; // 아이디

    @Column(nullable = false, length = 100)
    private String password; // 123456 => 해쉬 (비밀번호 암호화)

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String roll; // Enum을 쓰는게 좋음 (admin / user / manager)

    @CreationTimestamp // 시간이 자동 입력
    private Timestamp createDate;
}
