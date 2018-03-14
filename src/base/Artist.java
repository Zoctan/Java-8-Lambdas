package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public final class Artist {
    // 艺术家名
    private String name;
    // 乐队成员、可为空
    private List<Artist> members;
    // 国籍
    private String nationality;

    public Artist(String name, String nationality) {
        this(name, Collections.emptyList(), nationality);
    }

    public Artist(String name, List<Artist> members, String nationality) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);

        this.name = name;
        this.members = new ArrayList<>(members);
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Stream<Artist> getMembers() {
        return members.stream();
    }

    public String getNationality() {
        return nationality;
    }

    /*
     * 是否独唱
     */
    public boolean isSolo() {
        return members.isEmpty();
    }

    /*
     * 是否来自指定国家
     */
    public boolean isFrom(String nationality) {
        return this.nationality.equals(nationality);
    }
}