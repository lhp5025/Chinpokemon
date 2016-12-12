package world;

import java.io.Serializable;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TileProbability implements Serializable {
    public NavigableMap<Integer, String> map = new TreeMap<Integer, String>();
    
    public int encounterProbability;
    
    public void put(String s) {
        map.put(map.size(), s);
    }
    
    public TileProbability(int encounterProbability) {
        this.encounterProbability = encounterProbability;
    }
}
