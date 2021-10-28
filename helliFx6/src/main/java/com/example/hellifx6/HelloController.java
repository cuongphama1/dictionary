package com.example.hellifx6;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import com.sun.javafx.event.EventHandlerManager;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    DictionaryCommandline dc = new DictionaryCommandline();


    @FXML
    private Button btn;

    @FXML
    private Button btn_speak;

    @FXML
    private Button btn_add;

    @FXML
    private Button btn_delete;

    @FXML
    private Button btn_edit;

    @FXML
    private TextArea textarea;

    @FXML
    private TextArea textarea_2;

    @FXML
    private TextArea textarea_3;

    @FXML
    private TextField txtf;

    @FXML
    private TextField txtf_2;

    @FXML
    private TextField txtf_3;

    @FXML
    void deadd(ActionEvent event) {
        String target = txtf_2.getText();
        String explain = txtf_3.getText();
        if(dc.checkWord_1(target)) {
            textarea_3.setText("existed word");
        } else {
            dc.addWord_3(target, explain);
            textarea_3.setText("add success");
        }
    }

    @FXML
    void dedelete(ActionEvent event) {
         String word = txtf_2.getText();
         if (dc.checkWord_1(word)) {
             dc.removeWord_3(word);
             textarea_3.setText("delete success");
         } else {
             textarea_3.setText("can not delete");
         }

    }

    @FXML
    void deedit(ActionEvent event) {
        String target = txtf_2.getText();
        String explain = txtf_3.getText();
        if (dc.checkWord_1(target)) {
            dc.editWord_3(target, explain);
            textarea_3.setText("edit success");
        } else {
            textarea_3.setText("can not edit");
        }
    }

    @FXML
    void desearch(ActionEvent event) {
        String word = txtf.getText();
        //dc.insertFromFile();

        String data1 =   dc.dictionarySearcher_2_1(word);
       // String data2 = dc.dictionarySearcher_3(word);
        //textarea_2.setText(data2);
        textarea.setText(data1);

    }

    @FXML
    void despeak(ActionEvent event) {
        String word = txtf.getText();
        VoiceImplement voiceImplement = new VoiceImplement();
        voiceImplement.TextToSpeech(word);
    }

    @FXML
    void desuggest(KeyEvent event) {
        String word = txtf.getText();
        String data2 = dc.dictionarySearcher_3_1(word);
        textarea_2.setText(data2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TextFields.bindAutoCompletion(txtf, "hello");

    }
}
