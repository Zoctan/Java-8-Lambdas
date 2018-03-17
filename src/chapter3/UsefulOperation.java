package chapter3;

import base.Album;
import base.SampleData;
import base.Track;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;

public class UsefulOperation {
    public static void main(String[] args) {
        collect();
        map();
        filter();
        flatMap();
        maxOrMin();
        reduce();
        combine();
    }

    private static void collect() {
        List<String> collected = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

        assert Arrays.asList("a", "b", "c").equals(collected);
    }

    private static void map() {
        List<String> collected = Stream.of("a", "b", "abc")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());

        assert Arrays.asList("A", "B", "ABC").equals(collected);
    }

    private static void filter() {
        List<String> startWithDigits = Stream.of("1a", "b", "abc")
                .filter(string -> isDigit(string.charAt(0)))
                .collect(Collectors.toList());

        assert Collections.singletonList("1a").equals(startWithDigits);
    }

    private static void flatMap() {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());

        assert Arrays.asList(1, 2, 3, 4).equals(together);
    }

    private static void maxOrMin() {
        List<Track> tracks = Arrays.asList(
                new Track("BaKai", 524),
                new Track("Violets", 378),
                new Track("Time Was", 451));

        Track shortestTrack = tracks.stream()
                .min(Comparator.comparing(track -> track.getLength()))
                .get();

        assert tracks.get(1).equals(shortestTrack);
    }

    private static void reduce() {
        int count = Stream.of(1, 2, 3)
                .reduce(0, (acc, element) -> acc + element);

        assert 6 == count;
    }

    private static void combine() {
        Album album = SampleData.pleasePleaseMe;
        Set<String> origins = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .flatMap(artist -> artist.getMembers())
                .map(member -> member.getNationality())
                .collect(Collectors.toSet());

        List<String> nationalityList = new ArrayList<>(origins);

        assert Arrays.asList("UK").equals(nationalityList);
    }
}
