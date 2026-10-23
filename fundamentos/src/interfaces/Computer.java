package interfaces;

public class Computer implements MusicPlayer, VideoPlayer {

    @Override
    public void playMusic() {
        System.out.println("Computador está reproduzindo música");
    }

    @Override
    public void pauseMusic() {        
        System.out.println("Computador está pausando música");
    }

    @Override
    public void stopMusic() {
        System.out.println("Computador está parando música");
    }

    @Override
    public void playVideo() {
        System.out.println("Computador está reproduzindo vídeo");
    }

    @Override
    public void pauseVideo() {
        System.out.println("Computador está pausando vídeo");
    }

    @Override
    public void stopVideo() {
        System.out.println("Computador está parando vídeo");
    }

}
