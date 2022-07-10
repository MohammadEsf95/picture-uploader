package com.example.demo.application.picture.dto;

import com.example.demo.domain.picture.Picture;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PictureDTO {

    private Long id;
    private String name;
    private LocalDateTime createDate;
    private byte[] picBytes;

    public PictureDTO() {
    }

    public PictureDTO(Long id, String name, LocalDateTime createDate, byte[] picBytes) {
        this.id = id;
        this.name = name;
        this.createDate = createDate;
        this.picBytes = picBytes;
    }

    public static List<PictureDTO> from(List<Picture> pictures) {
        return pictures.stream()
                .map(PictureDTO::from)
                .collect(Collectors.toList());
    }

    public static PictureDTO from(Picture picture) {
        return new PictureDTO(
                picture.getId(),
                picture.getName(),
                picture.getCreateDate(),
                picture.getPicBytes()
        );
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
}
