public class Song {
    String name;
    String artist;
    int rated;

    public Song() {
    }

    public Song(String name, String artist, int rated) {
        this.name = name;
        this.artist = artist;
        this.rated = rated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getRated() {
        return rated;
    }

    public void setRated(int rated) {
        this.rated = rated;
    }

    @Override
    public String toString() {
        return name + "|" + artist + "|" + rated;
    }
    
    public int compareTo(Song o) {
        if (name.equals(o.name)) return rated - o.rated;
        else return 0;
    }

}
