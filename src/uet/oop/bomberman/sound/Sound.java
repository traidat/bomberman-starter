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
 * @author Bùi Vãn B?o
 */
public class Sound extends Thread{
    public Clip music(String s){
        Clip cl = null;
        try {
         File soundFile = new File("C:\\Users\\Bao\\Documents\\NetBeansProjects\\bomberman-starter\\src\\uet\\oop\\bomberman\\sound\\" + s + ".wav");
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         cl = AudioSystem.getClip();
         cl.open(audioIn);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
        return cl;
    }
    
    public Clip bom(){
        return music("Bomb");
    }
    public Clip nen(){
        return music("nen");
    }
    public Clip die(){
        return music("die");
    }
    public Clip portal(){
        return music("potal");
    }
    public Clip enemy_die(){
        return music("enmdie");
    }
    public Clip item(){
        return music("item");
    }
}
