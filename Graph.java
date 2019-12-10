import java.util.HashMap;
import java.util.*;

public class Graph {
    public Map<String, LinkedList<String>> map;
    public LinkedList<String> paths;

    public Graph(){

        this.map = new HashMap();
    }

    //adds an edge between two actors by assigning each as key,value pair of each other
    public void addEdge(String source, String destination){

        if(source.equals(destination))
            return;


        if(this.map.get(source) == null) { // key is not in the map so we add it
            this.map.put(source, new LinkedList<String>());
        }

        if(this.map.get(destination) == null) {
            this.map.put(destination, new LinkedList<String>());
        }

        this.map.get(source).add(destination);
        this.map.get(destination).add(source);
    }


    public String find(String source, String  destination){

        if(!map.containsKey(source) || !map.containsKey(destination)) {
            return "Invalid actor";
        }

        return find(source.toLowerCase(), destination.toLowerCase(), "");
    }

    // dfs done recursively
    private String find(String source, String destination, String path){

        path += source + "--->";
        LinkedList<String> temp = map.get(source);

        if(temp.contains(destination)) {
            return (path + destination).toUpperCase();
        }
        for(String actor : temp)
            if(map.get(actor).contains(destination))
                return find(actor, destination, path);

        for(String actor : temp) {
            if (!path.contains(actor)) {
                return find(actor, destination, path);
            }
        }

        return ""; // did not find the path

    }
}
