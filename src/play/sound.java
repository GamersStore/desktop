package play;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class sound
{
    public static void ps3()
    {
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        try
        {
            InputStream test=new FileInputStream("C:\\ProgramData\\Farmacia\\Sonidos\\Aviso.wav");

            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
    }
}
