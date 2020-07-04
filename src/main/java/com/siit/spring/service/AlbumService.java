package com.siit.spring.service;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.model.Album;
import com.siit.spring.exception.SingerNotFoundException;
import com.siit.spring.mapper.AlbumEntityToAlbumMapper;
import com.siit.spring.mapper.AlbumToAlbumEntityMapper;
import com.siit.spring.mapper.SingerToSingerEntityMapper;
import com.siit.spring.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlbumService {

    private final AlbumRepository repository;

    private final AlbumEntityToAlbumMapper albumEntityToAlbumMapper;

    private final AlbumToAlbumEntityMapper albumToAlbumEntityMapper;

    private final SingerToSingerEntityMapper singerToSingerEntityMapper;

    public Album findById(long albumId) {
        return repository.findById(albumId)
                .map((AlbumEntity albumEntity) -> albumEntityToAlbumMapper.convert(albumEntity))
                .orElseThrow(() -> new SingerNotFoundException("The album with id provided cannot be found"));
    }

    public List<Album> getAll() {
        return repository.getAll()
                .stream()
                .map(albumEntityToAlbumMapper::convert)
                .collect(Collectors.toList());
    }

    public Album create(Album album) {
        AlbumEntity albumEntity = albumToAlbumEntityMapper.convert(album);

        System.out.println("albumEntity = " + albumEntity);

        AlbumEntity savedEntity = repository.save(albumEntity);
        return albumEntityToAlbumMapper.convert(savedEntity);
    }

    @Transactional //
    public void updateTransactional(Album album) {
        AlbumEntity existingEntity = repository.findById(album.getId())
                .orElseThrow(() -> new SingerNotFoundException("The album with id provided cannot be found"));

        updateFields(existingEntity, album);
    }

    private void updateFields(AlbumEntity existingEntity, Album album) {
        existingEntity.setReleaseDate(album.getReleaseDate());
        existingEntity.setSinger(singerToSingerEntityMapper.convert(album.getSinger()));
        existingEntity.setTitle(album.getTitle());
    }

    public void delete(Long id) {
        AlbumEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new SingerNotFoundException("The album with id provided cannot be found"));

        repository.delete(existingEntity);
    }
}
