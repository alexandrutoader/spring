package com.siit.spring.service;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.model.Album;
import com.siit.spring.mapper.AlbumEntityToAlbumMapper;
import com.siit.spring.mapper.AlbumToAlbumEntityMapper;
import com.siit.spring.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AlbumService {
    private final AlbumRepository repository;

    private final AlbumEntityToAlbumMapper albumEntityToAlbumMapper;

    private final AlbumToAlbumEntityMapper albumToAlbumEntityMapper;

    public Album create(Album album) {
        AlbumEntity albumEntity = albumToAlbumEntityMapper.convert(album);
        AlbumEntity savedEntity = repository.save(albumEntity);

        return albumEntityToAlbumMapper.convert(savedEntity);
    }
}
