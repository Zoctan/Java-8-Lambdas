package base;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class SampleData {
    public static final Artist taylorSwift = new Artist("Taylor Swift", "US");

    public static final Artist johnColtrane = new Artist("John Coltrane", "US");

    public static final Artist johnLennon = new Artist("John Lennon", "UK");
    public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
    public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
    public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");

    public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

    public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");

    public static final Artist ryanTedder = new Artist("Ryan Tedder", "US");
    public static final Artist zachFilkins = new Artist("Zach Filkins", "US");
    public static final Artist eddieFisher = new Artist("Eddie Fisher", "US");
    public static final Artist andrewBrown = new Artist("Andrew Brown", "US");
    public static final Artist brentKutzle = new Artist("Brent Kutzle", "US");

    public static final List<Artist> membersOfOneRepublic = Arrays.asList(ryanTedder, zachFilkins, eddieFisher, andrewBrown, brentKutzle);

    public static final Artist oneRepublic = new Artist("One Republic", membersOfOneRepublic, "US");

    public static final Album wakingUp = new Album("Waking Up", asList(new Track("Good Life", 253), new Track("All This Time", 242), new Track("All the Right Moves", 237), new Track("Secrets", 224)), Collections.singletonList(oneRepublic));

    public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), Collections.singletonList(johnColtrane));

    public static final Album pleasePleaseMe = new Album("Please Please Me", asList(new Track("I Saw Her Standing There", 173), new Track("Misery", 108)), Collections.singletonList(theBeatles));

    public static final Album sampleShortAlbum = new Album("sample Short Album", Collections.singletonList(new Track("short track", 30)), Collections.singletonList(johnColtrane));

    public static final Album manyTrackAlbum = new Album("sample Short Album", asList(new Track("short track", 30), new Track("short track 2", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), Collections.singletonList(johnColtrane));

    public static Stream<Album> getAlbums() {
        return getAlbumList().stream();
    }

    public static List<Album> getAlbumList() {
        return Arrays.asList(wakingUp, aLoveSupreme, pleasePleaseMe, sampleShortAlbum, manyTrackAlbum);
    }

    public static Stream<Artist> getArtists() {
        return getArtistList().stream();
    }

    public static List<Artist> getArtistList() {
        return Arrays.asList(johnColtrane, taylorSwift, theBeatles, oneRepublic);
    }
}