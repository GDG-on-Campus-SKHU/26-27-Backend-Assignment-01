package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Music;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MusicRepository {
    private final Map<Long, Music> musics = new HashMap<>();
    private long sequence = 0L;

    public MusicRepository() {
        save(new Music(null, "19484", "우산", "에픽하이(Feat.윤하)", "타블로, 미쓰라 진", "타블로"));
        save(new Music(null, "62527", "미안해", "양다일", "정키, 양다일, 박찬, 토마조", "정키, 박찬, 토마조"));
        save(new Music(null, "20456", "Don't Look Back In Anger", "Oasis", "Noel Gallagher", "Noel Gallagher"));
    }

    public Music save(Music newMusic) {
        Music music = new Music(++sequence, newMusic.getNumber(),
                newMusic.getName(), newMusic.getSinger(), newMusic.getLyricist(), newMusic.getComposer());
        musics.put(music.getId(), music);
        return music;
    }

    public List<Music> findAll() {
        return new ArrayList<>(musics.values());
    }

    public Optional<Music> findById(Long id) {
        return Optional.ofNullable(musics.get(id));
    }

    public boolean delete(Long id) {
        return musics.remove(id) != null;
    }
}
