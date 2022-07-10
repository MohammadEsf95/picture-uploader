package com.example.demo.presentation.picture;

import com.example.demo.application.picture.PictureService;
import com.example.demo.application.util.pagination.PaginationDTO;
import com.example.demo.presentation.responseentity.ResponseEntityUtil;
import com.example.demo.presentation.responseentity.response.SuccessfulRequestResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(path = "/pictures")
public class PictureController {

    private final PictureService pictureService;

    public PictureController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @PostMapping
    public ResponseEntity<Object> uploadPicture(@RequestParam(value = "file") MultipartFile imageDate) throws IOException {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        pictureService.uploadPicture(imageDate)
                )
        );
    }

    @GetMapping
    public ResponseEntity<Object> findAll(@RequestParam int page, @RequestParam int pageSize) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        pictureService.findAll(
                                PaginationDTO.pageable(page, pageSize)
                        )
                )
        );
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntityUtil.generateSuccessfulRequestResponseEntity(
                new SuccessfulRequestResponseEntity<>(
                        pictureService.findById(id)
                )
        );
    }
}
