public class Main {
    public static void main(String[] args) {
        MusicPlayer mp = new MusicPlayer();
        VideoPlayer vp = new VideoPlayer();
        mp.play();
        vp.play();
        System.out.println("Played Music and Video!");
    }
}
