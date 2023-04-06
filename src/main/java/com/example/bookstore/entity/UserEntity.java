package com.example.bookstore.entity;

import com.example.bookstore.enums.AuthorityName;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private AuthorityName authority;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch =FetchType.EAGER
    )
    private List<BookEntity> books;




}
