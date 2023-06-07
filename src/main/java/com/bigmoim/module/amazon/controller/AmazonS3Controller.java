package com.bigmoim.module.amazon.controller;

import com.bigmoim.module.amazon.service.AwsS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class AmazonS3Controller {
    private final AwsS3Service awsS3Service;

    @PostMapping("/uploadFile")
    public ResponseEntity<List<String>> uploadFile(@RequestPart(value = "file", required = false) List<MultipartFile> multipartFiles){
//        System.out.println(multipartFiles.get(0).getOriginalFilename());
        return ResponseEntity.ok(awsS3Service.uploadFile(multipartFiles));
    }

    @DeleteMapping("/deleteFile")
    public ResponseEntity<String> deleteFile(@RequestParam String fileName){
        awsS3Service.deleteFile(fileName);
        return ResponseEntity.ok(fileName);
    }
}
