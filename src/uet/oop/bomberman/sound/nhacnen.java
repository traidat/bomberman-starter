/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uet.oop.bomberman.sound;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author dell
 */
public class nhacnen {
    public static Clip cl = null;
        public static void music_nen(File fl){
        
        try {
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(fl);
         cl = AudioSystem.getClip();
         cl.open(audioIn);
         cl.loop(Clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
    }
    
    public static void stop_nen(){
        if (cl.isRunning())
            cl.stop();
    }
    public static void Nhac(){
        music_nen(new File("C:\\Users\\dell\\Documents\\NetBeansProjects\\bomberman-starter1\\src\\uet\\oop\\bomberman\\sound\\nen.wav"));
    }
}
