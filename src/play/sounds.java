package play;

import config.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class sounds
{
    public static AudioInputStream audioInputStream = null;
    
    public static void introPS1()
    {
        try
        {
            URL file = Config.getInstance().getClass().getResource("/lib/sounds/intro-ps1.wav");
            
            try
            {
                audioInputStream = AudioSystem.getAudioInputStream(new File(file.getPath().replaceAll("%20", " ")));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-30.0f);
                clip.start();
            }
            catch (UnsupportedAudioFileException ex)
            {
                Logger.getLogger(sounds.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(sounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void introPS3()
    {
        try
        {
            URL file = Config.getInstance().getClass().getResource("/lib/sounds/intro-ps3.wav");
            
            try
            {
                audioInputStream = AudioSystem.getAudioInputStream(new File(file.getPath().replaceAll("%20", " ")));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-20.0f);
                clip.start();
            }
            catch (UnsupportedAudioFileException ex)
            {
                Logger.getLogger(sounds.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(sounds.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
