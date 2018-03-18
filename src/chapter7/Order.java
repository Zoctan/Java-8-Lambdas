package chapter7;

import base.Album;
import base.SampleData;
import base.Track;

import java.util.List;

public class Order {
    static List<Album> albums = SampleData.getAlbumList();

    public static void main(String[] args) {
        System.out.println(countMusicians());
        System.out.println(countTracks());
        System.out.println(countRunningTime());
    }

    public static long countMusicians() {
        long count = 0;
        for (Album album : albums) {
            count += album.getMusicianList().size();
        }
        return count;
    }

    public static long countTracks() {
        long count = 0;
        for (Album album : albums) {
            count += album.getTrackList().size();
        }
        return count;
    }

    public static long countRunningTime() {
        long count = 0;
        for (Album album : albums) {
            for (Track track : album.getTrackList()) {
                count += track.getLength();
            }
        }
        return count;
    }
}
