import java.util.*;

class Song {
    private int id;
    private String name;

    public Song(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class RecentlyPlayedStore {
    private int capacity;
    private Map<User, LinkedList<Song>> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void addSong(User user, Song song) {
        if (!store.containsKey(user)) {
            store.put(user, new LinkedList<>());
        }
        LinkedList<Song> playlist = store.get(user);
        playlist.remove(song);  
        playlist.addFirst(song);
        if (playlist.size() > capacity) {
            playlist.removeLast();
        }
    }

    public List<Song> getRecentlyPlayed(User user) {
        if (!store.containsKey(user)) {
            return Collections.emptyList();
        }
        return store.get(user);
    }
}

public class Main {
    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        User user = new User(1, "Mohan Murali");
        Song song1 = new Song(1, "Song 1");
        Song song2 = new Song(2, "Song 2");
        Song song3 = new Song(3, "Song 3");
        Song song4 = new Song(4, "Song 4");

        store.addSong(user, song1);
        store.addSong(user, song2);
        store.addSong(user, song3);
        store.addSong(user, song4);

        List<Song> recentlyPlayed = store.getRecentlyPlayed(user);
        System.out.println("Recently played songs:");
        for (Song song : recentlyPlayed) {
            System.out.println(song.getName());
        }
    }
}
