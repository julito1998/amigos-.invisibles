package com.amigosinvisibles.gdp.mymodelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MyModelMapper extends ModelMapper {
/**SON EJEMPLOS NO BORRAR POR EL MOMENTO
    public MyModelMapper() {
        setConfiguracionGlobal();
    }

    private void setConfiguracionGlobal() {
        //aca adentro van los addMappings(name());
        this.addMappings(configSongToListDTO());
        this.addMappings(configCreateDTOToSong());
        this.addMappings(configPlaylistToPlaylistDTO());
    }

    //aca va el mapeo
    private PropertyMap<Song, SongListResponseDTO> configSongToListDTO() {
        return new PropertyMap<Song, SongListResponseDTO>() {
            @Override
            protected void configure() {
            }
        };
    }

    private PropertyMap<SongCreateRequestDTO, Song> configCreateDTOToSong() {
        return new PropertyMap<SongCreateRequestDTO, Song>() {
            @Override
            protected void configure(){
                map().setGenre(source.getGenre());
                map().setAuthor(source.getAuthor());
                map().setName(source.getName());
            }
        };
    }

    private PropertyMap<Playlist, PlaylistResponseDTO> configPlaylistToPlaylistDTO() {
        return new PropertyMap<Playlist, PlaylistResponseDTO>() {
            @Override
            protected void configure(){
                map().setUserId(source.getOwner());
            }
        };
    }**/
}
