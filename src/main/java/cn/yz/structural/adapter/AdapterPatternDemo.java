package cn.yz.structural.adapter;

interface MediaPlayer {
    public void playMp3(String fileName);
}

interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}

class Mp3Player implements MediaPlayer{

    @Override
    public void playMp3(String fileName) {
        System.out.println("Playing mp3 file. Name: "+ fileName);
    }
}

class Mp4VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}

class MusicAdapter{
    private MediaPlayer mediaPlayer;
    private AdvancedMediaPlayer advancedMediaPlayer;

    public MusicAdapter(MediaPlayer mediaPlayer, AdvancedMediaPlayer advancedMediaPlayer) {
        this.mediaPlayer = mediaPlayer;
        this.advancedMediaPlayer = advancedMediaPlayer;
    }

    public void play(String type, String fileSource){
        switch (type) {
            case "mp3" -> mediaPlayer.playMp3(fileSource);
            case "vlc" -> advancedMediaPlayer.playVlc(fileSource);
            case "mp4" -> advancedMediaPlayer.playMp4(fileSource);
            default -> System.out.println("格式不支持");
        }
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        MusicAdapter musicAdapter = new MusicAdapter(new Mp3Player(),new Mp4VlcPlayer());
        musicAdapter.play("mp3","a.mp3");
        musicAdapter.play("mp4","a.mp4");
        musicAdapter.play("vlc","a.vlc");
    }
}
