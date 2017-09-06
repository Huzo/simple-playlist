import java.util.*;

/**
 * Created by KIRAN on 14.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Song> playlist = new LinkedList<Song>();
        ArrayList<Album> albumList = new ArrayList<Album>();

        Album AJFA = new Album("...And Justice For All","Metallica");
        playlist.add(new Song("Blackened", 403, AJFA));
        playlist.add(new Song("...And Justice For All", 586, AJFA));
        playlist.add(new Song("Eye of the Beholder", 385, AJFA));
        playlist.add(new Song("One", 446, AJFA));
        playlist.add(new Song("The Shortest Straw", 395, AJFA));
        playlist.add(new Song("Harvester of Sorrow", 345, AJFA));
        playlist.add(new Song("The Frayed Ends of Sanity", 464, AJFA));
        playlist.add(new Song("To Live Is to Die", 588, AJFA));
        playlist.add(new Song("Dyer's Eve", 313, AJFA));

        menu(playlist);






    }
    public static void menu(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> iterator = playlist.listIterator();
        while(!quit){

            System.out.println("1)Quit" +
                    "\n2)Skip song" +
                    "\n3)Skip to previous song" +
                    "\n4)Replay song" +
                    "\n5)List the songs in playlist");
            int choice = scanner.nextInt();
            scanner.nextLine();
            nowPlaying(playlist);

            switch(choice){
                case 1:
                    quit = true;
                    break;
                case 2:
                    if(!goingForward){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        goingForward = true;
                    }
                    if(iterator.hasNext()){
                        System.out.println("Now playing " + iterator.next());
                    }
                    else{
                        System.out.println("End of the list");
                        goingForward = false;
                    }
                    break;
                case 3:
                    if(goingForward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        goingForward = false;
                    }
                    if(iterator.hasPrevious()){
                        System.out.println("Now playing " + iterator.previous());
                    }
                    else{
                        System.out.println("End of the list");
                        goingForward = true;
                    }
                    break;
                case 4:
                    if(goingForward){
                        System.out.println("Now playing" + iterator.previous());
                    }else{
                        iterator.previous();
                        System.out.println("Now playing" + iterator.next());
                    }
                    break;
                case 5:
                    for(int i = 0; i < playlist.size(); i++ ){
                        System.out.println(i+1 + ": " + playlist.get(i));
                    }
                    break;

            }
        }
    }
    public static void nowPlaying( LinkedList<Song> playList){
        Iterator<Song> i = playList.iterator();
        while(i.hasNext()){
            System.out.println("Now playing" + i.next());
        }
        System.out.println("********************");

    }
}
