package com.dimathicc.yapyard.controller;

import com.dimathicc.yapyard.client.AlbumClient;
import com.dimathicc.yapyard.dto.AlbumDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {

    private final AlbumClient albumClient;

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> listAlbums() {
        return ResponseEntity.ok(albumClient.listAlbums());
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<AlbumDTO> getAlbumById(@PathVariable Long albumId) {
        return ResponseEntity.ok(albumClient.getAlbumById(albumId));
    }

    @PostMapping
    public ResponseEntity<AlbumDTO> createAlbum(@RequestBody AlbumDTO albumDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(albumClient.createAlbum(albumDTO));
    }

    @PutMapping("/{albumId}")
    public ResponseEntity<AlbumDTO> updateAlbum(@PathVariable Long albumId, @RequestBody AlbumDTO albumDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(albumClient.updateAlbum(albumId, albumDTO));
    }

    @DeleteMapping("/{albumId}")
    public ResponseEntity<AlbumDTO> deleteAlbum(@PathVariable Long albumId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(albumClient.deleteAlbum(albumId));
    }
}
