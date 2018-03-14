package base;

public final class Track {
    // 单曲名
    private final String name;
    // 单曲播放长度：秒
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }
}