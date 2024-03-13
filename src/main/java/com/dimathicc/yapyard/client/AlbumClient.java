package com.dimathicc.yapyard.client;

import com.dimathicc.yapyard.dto.AlbumDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "albumClient", url = "https://jsonplaceholder.typicode.com/albums")
public interface AlbumClient {

    @GetMapping
    List<AlbumDTO> listAlbums();

    @GetMapping("/{albumId}")
    AlbumDTO getAlbumById(@PathVariable Long albumId);

    @PostMapping
    AlbumDTO createAlbum(@RequestBody AlbumDTO albumDTO);

    @PutMapping("/{albumId}")
    AlbumDTO updateAlbum(@PathVariable Long albumId, @RequestBody AlbumDTO albumDTO);

    @DeleteMapping("/{albumId}")
    AlbumDTO deleteAlbum(@PathVariable Long albumId);
}
