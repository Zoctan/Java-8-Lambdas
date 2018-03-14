package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.Collections.unmodifiableList;

public final class Album {
    // 专辑名
    private String name;
    // 单曲列表
    private List<Track> tracks;
    // 艺术家列表
    private List<Artist> musicians;

    public Album(String name, List<Track> tracks, List<Artist> musicians) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(tracks);
        Objects.requireNonNull(musicians);

        this.name = name;
        this.tracks = new ArrayList<>(tracks);
        this.musicians = new ArrayList<>(musicians);
    }

    public String getName() {
        return name;
    }

    public Stream<Track> getTracks() {
        return tracks.stream();
    }

    public Stream<Artist> getMusicians() {
        return musicians.stream();
    }

    public List<Track> getTrackList() {
        return unmodifiableList(tracks);
    }

    public List<Artist> getMusicianList() {
        return unmodifiableList(musicians);
    }

    /*
     * 主唱
     */
    public Artist getMainMusician() {
        return musicians.get(0);
    }
}