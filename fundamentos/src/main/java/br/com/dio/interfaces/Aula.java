package br.com.dio.interfaces;

public class Aula {
    public static void main(String[] args) {
        playMusic(new Computer());
        playVideo(new Computer());
    }

    public static void playMusic(MusicPlayer musicPlayer) {
        musicPlayer.playMusic();
    }

    public static void playVideo(VideoPlayer videoPlayer) {
        videoPlayer.playVideo();
    }
}
