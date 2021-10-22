package com.example.hellifx6;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class VoiceImplement {
     Voice voice;
     VoiceManager voiceManager;
     public void TextToSpeech(String word) {
         System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
         voice = VoiceManager.getInstance().getVoice("kevin16");
         if(voice != null) {
             voice.allocate();
             try {
                 voice.setRate(125);
                 voice.setPitch(100);
                 voice.setVolume(2);
                 voice.speak(word);
             } catch (Exception e1) {
                 e1.printStackTrace();
             }
         } else {
             throw new IllegalStateException("can not find voice");
         }
     }

}
