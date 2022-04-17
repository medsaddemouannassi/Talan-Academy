package Streaming;

import java.util.ArrayList;

public interface Musique {
    public void displayMusic(ArrayList<MusiqueImpl> musiques);
    public boolean compare(MusiqueImpl music);
}
