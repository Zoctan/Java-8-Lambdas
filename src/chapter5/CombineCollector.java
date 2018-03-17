package chapter5;

import base.Album;
import base.Artist;
import base.SampleData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CombineCollector {
    public static void main(String[] args) {
        countArtistAlbums(SampleData.getAlbums());
        countArtistAlbumsUsingCounting(SampleData.getAlbums());

        Map<Artist, List<String>> map1 = getArtistAlbumsNameUsingMapping(SampleData.getAlbums());
        Map<Artist, List<String>> map2 = getArtistAlbumsName(SampleData.getAlbums());
        assert map1.equals(map2);

        CombineCollector c = new CombineCollector();
        String name = SampleData.oneRepublic.getName();
        assert c.artistCache.get(name) == null;
        //Artist artist = c.getArtist(name);
        Artist artist = c.getArtistUsingComputeIfAbsent(name);
        assert c.artistCache.get(name) != null && artist != null;
    }

    private static void countArtistAlbums(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(Album::getMainMusician));

        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }

        assert numberOfAlbums.get(SampleData.theBeatles) == 1;
        assert numberOfAlbums.get(SampleData.oneRepublic) == 2;
        assert numberOfAlbums.get(SampleData.johnColtrane) == 1;
        assert numberOfAlbums.get(SampleData.taylorSwift) == 2;
    }

    private static void countArtistAlbumsUsingCounting(Stream<Album> albums) {
        Map<Artist, Long> numberOfAlbums = albums.collect(
                groupingBy(Album::getMainMusician,
                        counting())
        );

        assert numberOfAlbums.get(SampleData.theBeatles) == 1;
        assert numberOfAlbums.get(SampleData.oneRepublic) == 2;
        assert numberOfAlbums.get(SampleData.johnColtrane) == 1;
        assert numberOfAlbums.get(SampleData.taylorSwift) == 2;
    }

    private static Map<Artist, List<String>> getArtistAlbumsName(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(Album::getMainMusician));

        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(toList()));
        }
        return nameOfAlbums;
    }

    private static Map<Artist, List<String>> getArtistAlbumsNameUsingMapping(Stream<Album> albums) {
        return albums.collect(
                groupingBy(Album::getMainMusician,
                        mapping(Album::getName,
                                toList()))
        );
    }

    private Map<String, Artist> artistCache = new HashMap<>();

    private Artist readArtistFromDB(String name) {
        return SampleData.oneRepublic;
    }

    private Artist getArtist(String name) {
        Artist artist = artistCache.get(name);
        if (artist == null) {
            artist = readArtistFromDB(name);
            artistCache.put(name, artist);
        }
        return artist;
    }

    private Artist getArtistUsingComputeIfAbsent(String name) {
        return artistCache.computeIfAbsent(name, this::readArtistFromDB);
    }

    private static void forEachMap(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist = albums.collect(groupingBy(Album::getMainMusician));

        Map<Artist, Integer> numberOfAlbums = new HashMap<>();

        albumsByArtist.forEach(
                (artist, albumList) -> numberOfAlbums.put(artist, albumList.size())
        );
    }
}
