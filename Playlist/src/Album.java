import java.util.ArrayList;

/**
 * Created by KIRAN on 14.06.2017.
 */
public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new ArrayList<Song>();
    }

    public boolean addSong(String name, int duration){
        if(songList.contains(name)) {
            return false;
        }

        this.songList.add(new Song(name, duration, new Album(this.getName(),this.getArtist())));
        return true;

    }

    public boolean deleteSong(String name){
        if(songList.contains(name)){
            this.songList.remove(songList.indexOf(name));
            return true;
        }
        return false;

    }


    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }
}
