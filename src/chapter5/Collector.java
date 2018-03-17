package chapter5;

import base.Album;
import base.Artist;
import base.SampleData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class Collector {
    public static void main(String[] args) {
        assert "One Republic".equals(biggestGroup(SampleData.getArtists()).get().getName());

        System.out.println(averageNumberOfTracks(SampleData.getAlbumList()));

        Map<Boolean, List<Artist>> artistMapList = soloAndBands(SampleData.getArtists());
        artistMapList.get(true).stream().map(Artist::getName).forEach(System.out::println);
        artistMapList.get(false).stream().map(Artist::getName).forEach(System.out::println);

        Map<Artist, List<Album>> albumMapList = albumsByArtist(SampleData.getAlbums());
        albumMapList.get(SampleData.oneRepublic).stream().map(Album::getName).forEach(System.out::println);

        assert "[{A, B, C}]".equals(getString());
    }

    private static Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(comparing(getCount)));
    }

    public static double averageNumberOfTracks(List<Album> albums) {
        return albums.stream().collect(averagingInt(album -> album.getTrackList().size()));
    }

    private static Map<Boolean, List<Artist>> soloAndBands(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }

    private static Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician));
    }

    private static String getString() {
        List<String> strings = Arrays.asList("A", "B", "C");
        return strings.stream()
                .collect(Collectors.joining(", ", "[{", "}]"));
    }

}
