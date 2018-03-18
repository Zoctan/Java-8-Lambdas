package chapter7;

import base.Album;
import base.SampleData;

public class WithInitial {
    private static Database database = new Database();

    public static void main(String[] args) {

    }

    private static ThreadLocal<Album> findArtistFromDB() {
        ThreadLocal<Album> thisAlbum = new ThreadLocal<Album>() {
            @Override
            protected Album initialValue() {
                return database.findCurrentAlbum();
            }
        };
        return thisAlbum;
    }

    private static ThreadLocal<Album> findArtistFromDBWithInitial() {
        ThreadLocal<Album> thisAlbum = ThreadLocal.withInitial(
                () -> database.findCurrentAlbum()
        );
        return thisAlbum;
    }
}

class Database {
    Album findCurrentAlbum() {
        return SampleData.dreamingOutLoud;
    }
}
