package com.keeper.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "keeper_notes")
public class KeeperNoteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String content;

    // link each note to a user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private KeeperEntity user;

    public KeeperNoteEntity(String title, String content, KeeperEntity user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public KeeperNoteEntity() {}

    // getters & setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public KeeperEntity getUser() { return user; }
    public void setUser(KeeperEntity user) { this.user = user; }

    @Override
    public String toString() {
        return "KeeperNoteEntity [id=" + id + ", title=" + title + ", content=" + content + ", user=" + user.getName() + "]";
    }
}
