package chapter7;

import base.Album;
import base.SampleData;
import base.Track;

import java.util.List;
import java.util.function.ToLongFunction;

public class OrderStreamDSL {
    static List<Album> albums = SampleData.getAlbumList();

    public static void main(String[] args) {
        System.out.println(countMusicians());
        System.out.println(countTracks());
        System.out.println(countRunningTime());
    }

    private static long countFeature(ToLongFunction<Album> function) {
        return albums.stream()
                .mapToLong(function)
                .sum();
    }

    public static long countMusicians() {
        return countFeature(album -> album.getMusicians().count());
    }

    public static long countTracks() {
        return countFeature(album -> album.getTracks().count());
    }

    public static long countRunningTime() {
        return countFeature(album -> album.getTracks()
                .mapToLong(Track::getLength)
                .sum());
    }
}
