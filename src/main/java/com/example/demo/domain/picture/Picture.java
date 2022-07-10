package com.example.demo.domain.picture;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Entity
@Table(name = "pics")
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "pic_name")
    private String name;

    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @Column(name = "pic_bytes",length = 100000)
    private byte[] picBytes;

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }

    public Picture() {
    }

    public Picture(String name, byte[] picBytes) {
        this.name = name;
        this.picBytes = picBytes;
    }

    public Picture(Long id, String name, byte[] file) {
        this.id = id;
        this.name = name;
        this.picBytes = file;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public byte[] getPicBytes() {
        return picBytes;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createDate=" + createDate +
                ", picBytes=" + Arrays.toString(picBytes) +
                '}';
    }
}
