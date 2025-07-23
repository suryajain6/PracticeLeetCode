import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTests {
    public static void main(String [] args){
        List<Album> albums = new ArrayList<>();

    /*    List<Pair<String, String>> artistAlbum = albums.stream()
                .flatMap(album -> album.getArtists()
                        .stream()
                        .map(artist -> new ImmutablePair<String, String>(artist.getName(), album.getAlbumName())))
                .collect(toList());*/

     /*   Map<String,String> albumnsa = albums.stream()
                .flatMap(album -> album.getArtists()
                        .stream().map(x-> new ArtistAlbum(x.getName(),album.getAlbumName()))).
                        collect(toMap(x->x.getAlbumn(),x->x.getArtist()));

        Map<String,String> albumnsaa = albums.stream()
                .flatMap(album -> album.getArtists()
                        .stream().map(x-> Map.entry(x.getName(),album.getAlbumName()))).
                collect(toMap(Map.Entry::getKey,Map.Entry::getValue));*/




        List<String> cities = new ArrayList<>();
       /* cities.add("delhi");
        cities.add("pune");*/
        cities.add("bangalore");
        cities.add("mumbai");

        List<String> reverse =cities.stream().sorted(Comparator.reverseOrder()).collect(toList());
        System.out.println(reverse);

        List<String> reverse2 =cities.stream().sorted((a,b) -> b.compareTo(a)).collect(toList());
        System.out.println(reverse2);

       /* List<String> reverse2 =cities.stream().sorted(Comparator.comparing()).collect(toList());
        System.out.println(reverse2);*/

        boolean isValid = cities.stream().anyMatch(element -> element.contains("a")); // true
        boolean isValidOne = cities.stream().allMatch(element -> element.contains("a")); // false
        boolean isValidTwo = cities.stream().noneMatch(element -> element.contains("x")); // false

        System.out.println("isValid: "+ isValid);
        System.out.println("isValidOne: "+ isValidOne);
        System.out.println("isValidTwo: "+ isValidTwo);

        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        System.out.println("reduced: "+ reduced);


    }

    public static <T> Set<T>  findDuplicates(List<T> arrList){
        Set<T> arrSet = new HashSet<>();
        return  arrList.stream().filter(n->!arrSet.add(n) ).collect(toSet());
    }

    public static Map<String,Long> countOccurrence(List<String> arrList, String str){
       // arrList.stream().filter(s->s.equals(str)).count();
        Map<String,Long> map=   arrList.stream().collect(Collectors.groupingBy(e->e,Collectors.counting()));
        Optional<String> list = arrList.stream().collect(Collectors.maxBy(Comparator.reverseOrder()));
         arrList.parallelStream().collect(Collectors.collectingAndThen(Collectors.toList(),
                l -> {
                    Collections.reverse(l);
                    return list.stream();
                }));
        return map;
    }

}

class Album {

    private String albumName;
    private int albumCost;
    private List<Artist> artists;

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getAlbumCost() {
        return albumCost;
    }

    public void setAlbumCost(int albumCost) {
        this.albumCost = albumCost;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    Album(String albumName, int albumCost, List<Artist> artists) {
        this.albumName = albumName;
        this.albumCost = albumCost;
        this.artists = artists;
    }
    // ...
}

class Artist {

    private final String name;
    private boolean associatedMajorLabels;
    private List<String> majorLabels;

    public String getName() {
        return name;
    }

    public boolean isAssociatedMajorLabels() {
        return associatedMajorLabels;
    }

    public void setAssociatedMajorLabels(boolean associatedMajorLabels) {
        this.associatedMajorLabels = associatedMajorLabels;
    }

    public List<String> getMajorLabels() {
        return majorLabels;
    }

    public void setMajorLabels(List<String> majorLabels) {
        this.majorLabels = majorLabels;
    }

    Artist(String name, boolean associatedMajorLabels, List<String> majorLabels) {
        this.name = name;
        this.associatedMajorLabels = associatedMajorLabels;
        this.majorLabels = majorLabels;
    }
    // ...
}

class ArtistAlbum{
    private String albumn;
    private String artist;

    public ArtistAlbum(String artist, String albumn) {
        this.artist = artist;
        this.albumn = albumn;
    }

    public String getAlbumn() {
        return albumn;
    }

    public void setAlbumn(String albumn) {
        this.albumn = albumn;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



}
