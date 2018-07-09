package server.places;

import java.util.HashSet;


public class Area {
    HashSet<String> places;

    public Area() {
        this.places = new HashSet<>();
    }

    public HashSet<String> addPlace(String city){
        places.add(city);
        return places;
    }

    public HashSet<String>removePlaces(String city){
        if (places.contains(city)){
            places.remove(city);
            return places;
        } else {
            return null;
        }
    }

    public boolean contains(String place){
        if (places.contains(place)){
            return true;
        } else {
            return false;
        }
    }

    public void printPlaces(){
        for (String p : places) {
            System.out.println(p);
        }
    }

    public HashSet<String> getPlaces() {
        return places;
    }
}
