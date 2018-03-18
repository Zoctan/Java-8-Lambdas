package chapter7;

import base.Album;
import base.SampleData;
import base.Track;

import java.util.List;

public class OrderStream {
    static List<Album> albums = SampleData.getAlbumList();

    public static void main(String[] args) {
        System.out.println(countMusicians());
        System.out.println(countTracks());
        System.out.println(countRunningTime());
    }

    public static long countMusicians() {
        return albums.stream()
                .mapToLong(album -> album.getMusicians().count())
                .sum();
    }

    public static long countTracks() {
        return albums.stream()
                .mapToLong(album -> album.getTracks().count())
                .sum();
    }

    public static long countRunningTime() {
        return albums.stream()
                .mapToLong(album -> album.getTracks()
                        .mapToLong(Track::getLength)
                        .sum())
                .sum();
    }
}
