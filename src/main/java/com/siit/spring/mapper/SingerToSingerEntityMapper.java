package com.siit.spring.mapper;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.entity.SingerEntity;
import com.siit.spring.domain.model.Album;
import com.siit.spring.domain.model.Singer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class SingerToSingerEntityMapper implements Converter<Singer, SingerEntity> {
    private final AlbumToAlbumEntityMapper albumToAlbumEntityMapper;

    @Override
    public SingerEntity convert(Singer source) {
        return SingerEntity.builder()
                .id(source.getId())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .birthDate(source.getBirthDate())
                .albums(mapAlbumsList(source.getAlbums()))
                .build();
    }

    private List<AlbumEntity> mapAlbumsList(List<Album> albums) {
        return albums.stream()
                .map(albumToAlbumEntityMapper::convert)
                .collect(Collectors.toList());
    }
}
