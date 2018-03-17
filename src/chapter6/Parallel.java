package chapter6;

import base.Album;
import base.SampleData;
import base.Track;

import java.util.List;

public class Parallel {
    public static void main(String[] args) {
        int serial = serialArraySum(SampleData.getAlbumList());
        int parallel = parallelArraySum(SampleData.getAlbumList());
        assert serial == parallel;
    }

    private static int serialArraySum(List<Album> albums) {
        return albums.stream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }

    private static int parallelArraySum(List<Album> albums) {
        return albums.parallelStream()
                .flatMap(Album::getTracks)
                .mapToInt(Track::getLength)
                .sum();
    }
}
