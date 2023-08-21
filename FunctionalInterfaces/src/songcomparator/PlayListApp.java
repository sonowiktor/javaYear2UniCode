package songcomparator;

import java.util.Comparator;

public class PlayListApp {

    public static void main(String[] arg) {

    	//Create a new PlayList object
        PlayList playlist = new PlayList("My Favourites");

        //add some new Song objects
        playlist.addSong( new Song("Only Girl (In The World)", 235, "Rhianna") );
        playlist.addSong( new Song("Thinking of Me", 206, "Olly Murs") );
        playlist.addSong( new Song("Raise Your Glass", 202,"P!nk") );
        playlist.addSong( new Song("Beat it", 150,"M Jackson") );        
        playlist.addSong( new Song("Bad", 210,"M Jackson") );
        
      
        System.out.println(playlist.getTrackListings());   
        
        
        //ADD CODE HERE...
        playlist.sortPlaylist(Comparator.reverseOrder());
        System.out.println(playlist.getTrackListings());
        
        playlist.sortPlaylist((Song s1, Song s2) -> {
        	int result = s1.getArtist().compareTo(s2.getArtist());
        	if (result == 0) {
        	result = Integer.compare(s1.getDuration(), s2.getDuration());
        	}
        	return result;
        	});
        System.out.println(playlist.getTrackListings());
        
        playlist.sortPlaylist(Comparator
        		.comparing(Song::getArtist)
        		 .thenComparingInt(Song::getDuration)
        		 .thenComparing(Song::getTitle).reversed());
        System.out.println(playlist.getTrackListings());


               
    }
}
