import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }
    public boolean addSong(String title,double duration){
        if (findSong(title)==null){
            songs.add(new Song(title,duration));
            return true;
        }
        return false;
    }

    private Song findSong(String title){
        for (int i = 0; i < songs.size(); i++) {
            if (this.songs.get(i).getTitle().equals(title)){
                return this.songs.get(i);
            }
        }
        return null;
    }

    public boolean addToPlayList(int track,LinkedList<Song> playlist){
        if (track<=0 || track>songs.size()){
            return false;
        }
        Iterator<Song> songListIterator = this.songs.iterator();
        Iterator<Song> playlistIterator = playlist.iterator();
        while (playlistIterator.hasNext()){
            if (playlistIterator.next().getTitle() == this.songs.get(track).getTitle()){
                playlist.add(this.songs.get(track-1));
            }else{
                return false;
            }
        }
            return true;
    }
    public boolean addToPlayList(String title,LinkedList<Song> playlist){
        if(findSong(title) == null){
            return false;
        }
        Iterator<Song> songListIterator = this.songs.iterator();
        Iterator<Song> playlistIterator = playlist.iterator();
        while (playlistIterator.hasNext()){
            if (playlistIterator.next().getTitle() == title){
                playlist.add(findSong(title));
            }else{
                return false;
            }
        }
            return true;
    }
}
