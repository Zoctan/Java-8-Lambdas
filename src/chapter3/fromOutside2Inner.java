package chapter3;

import base.Artist;
import base.SampleData;

import java.util.Iterator;
import java.util.List;

public class fromOutside2Inner {
    public static void main(String[] args) {
        List<Artist> allArtists = SampleData.getArtistList();

        assert 2L == fromUSArtistsUsingFor(allArtists);

        assert 2L == fromUSArtistsUsingIterator(allArtists);

        assert 2L == fromUSArtistsUsingStream(allArtists);

    }

    private static long fromUSArtistsUsingFor(List<Artist> allArtists) {
        long count = 0L;

        for (Artist artist : allArtists) {
            if (artist.isFrom("US")) {
                count++;
            }
        }
        return count;
    }

    private static long fromUSArtistsUsingIterator(List<Artist> allArtists) {
        long count = 0L;
        Iterator iterator = allArtists.iterator();

        while (iterator.hasNext()) {
            Artist artist = (Artist) iterator.next();
            if (artist.isFrom("US")) {
                count++;
            }
        }

        return count;
    }

    private static long fromUSArtistsUsingStream(List<Artist> allArtists) {
        return allArtists.stream()
                .filter((artist) -> artist.isFrom("US"))
                .count();
    }
}
