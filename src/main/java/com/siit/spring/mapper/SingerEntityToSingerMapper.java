package com.siit.spring.mapper;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.entity.SingerEntity;
import com.siit.spring.domain.model.Album;
import com.siit.spring.domain.model.Singer;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class SingerEntityToSingerMapper implements Converter<SingerEntity, Singer> {

    private final AlbumEntityToAlbumMapper albumEntityToAlbumMapper;

    @Override
    public Singer convert(SingerEntity source) {
        return Singer.builder()
                     .id(source.getId())
                     .firstName(source.getFirstName())
                     .birthDate(source.getBirthDate())
                     .albums(mapAlbumsList(source.getAlbums()))
                     .build();
    }

    private List<Album> mapAlbumsList(List<AlbumEntity> albums) {
        return albums.stream()
                     .map(albumEntityToAlbumMapper::convert)
                     .collect(Collectors.toList());
    }
}
