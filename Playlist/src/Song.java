/**
 * Created by KIRAN on 14.06.2017.
 */
public class Song {
    private String title;
    private int duration;

    public Song(String title, int duration, Album album) {
        this.title = title;
        this.duration = duration;
        album.addSong(this.title, this.duration);
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
