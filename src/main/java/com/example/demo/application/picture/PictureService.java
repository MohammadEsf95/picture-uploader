package com.example.demo.application.picture;

import com.example.demo.application.picture.dto.PictureDTO;
import com.example.demo.application.util.pagination.PageDTO;
import com.example.demo.application.util.responsedto.SuccessfulResponseDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

public interface PictureService {

    SuccessfulResponseDTO uploadPicture(MultipartFile imageData) throws IOException;

    PageDTO<PictureDTO> findAll(Pageable pageable);

    PictureDTO findById(Long id);
}
