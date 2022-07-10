package com.example.demo.application.picture;

import com.example.demo.application.picture.dto.PictureDTO;
import com.example.demo.application.util.pagination.PageDTO;
import com.example.demo.application.util.responsedto.SuccessfulResponseDTO;
import com.example.demo.domain.picture.Picture;
import com.example.demo.domain.picture.PictureRepository;
import com.example.demo.infrastructure.ApplicationMessages;
import com.example.demo.infrastructure.exception.ExceptionMessages;
import com.example.demo.infrastructure.exception.applicationexception.RecordNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class PictureDefaultService implements PictureService {

    private final PictureRepository pictureRepository;

    public PictureDefaultService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    @Override
    public SuccessfulResponseDTO uploadPicture(MultipartFile imageData) throws IOException {
        Picture picture = pictureRepository.save(
                new Picture(
                        imageData.getName(),
                        imageData.getBytes()
                )
        );
        return new SuccessfulResponseDTO(picture.getId().toString(), ApplicationMessages.OPERATION_COMPLETED.getTitle());
    }

    @Override
    public PageDTO<PictureDTO> findAll(Pageable pageable) {
        List<Picture> pictures = pictureRepository.findAll(pageable).getContent();
        return new PageDTO<>(
                PictureDTO.from(pictures),
                pictureRepository.count()
        );
    }

    @Override
    public PictureDTO findById(Long id) {
        Picture picture = pictureRepository.findById(id).orElseThrow(
                () -> new RecordNotFoundException(ExceptionMessages.RECORD_NOT_FOUND.getTitle())
        );
        return PictureDTO.from(picture);
    }
}
