package com.example.nicolo.synthesizer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.MediaController;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private NumberPicker numPickOne;
    private Button aButton,aSharpButton,bButton,cButton,cSharpButton,dButton,dSharpButton,eButton, fButton, fSharpButton,gButton,gSharpButton, aHighButton, aScaleButton;
    private Button twinkle;
    private Button seeNotes;
    private CheckBox playSecondLineOrNah;
    private MediaPlayer aNote, cNote, aSharpNote,cSharpNote, dNote,dSharpNote,eNote,fNote,fSharpNote, gNote, gSharpNote, aHighNote, bNote;
    private final int WHOLE_NOTE = 1000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wireWidgets();
        setListeners();
        createMediaPlayers();



    }

    public MediaPlayer getaNote() {
        return aNote;
    }

    public MediaPlayer getbNote() {
        return bNote;
    }

    public MediaPlayer getaSharpNote() {
        return aSharpNote;
    }

    public MediaPlayer getcNote() {
        return cNote;
    }

    public MediaPlayer getcSharpNote() {
        return cSharpNote;
    }

    public MediaPlayer getdNote() {
        return dNote;
    }

    public MediaPlayer geteNote() {
        return eNote;
    }

    public MediaPlayer getfNote() {
        return fNote;
    }

    public MediaPlayer getdSharpNote() {
        return dSharpNote;
    }

    public MediaPlayer getfSharpNote() {
        return fSharpNote;
    }

    public MediaPlayer getgSharpNote() {
        return gSharpNote;
    }

    public MediaPlayer getgNote() {
        return gNote;
    }

    public Button getaHighButton() {
        return aHighButton;
    }

    private void createMediaPlayers() {
        aNote=MediaPlayer.create(this, R.raw.scalea);
        bNote=MediaPlayer.create(this, R.raw.scaleb);
        aSharpNote=MediaPlayer.create(this, R.raw.scalebb);
        cNote=MediaPlayer.create(this, R.raw.scalec);
        cSharpNote=MediaPlayer.create(this, R.raw.scalecs);
        dNote=MediaPlayer.create(this, R.raw.scaled);
        dSharpNote=MediaPlayer.create(this, R.raw.scaleds);
        eNote=MediaPlayer.create(this, R.raw.scalee);
        fSharpNote=MediaPlayer.create(this, R.raw.scalefs);
        fNote=MediaPlayer.create(this, R.raw.scalef);
        gNote=MediaPlayer.create(this, R.raw.scaleg);
        gSharpNote=MediaPlayer.create(this, R.raw.scalegs);
        aHighNote=MediaPlayer.create(this, R.raw.scalehigha);




    }

    private void setListeners() {
        aButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        aSharpButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        cSharpButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        dSharpButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        fSharpButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
        gSharpButton.setOnClickListener(this);
        aHighButton.setOnClickListener(this);
        aScaleButton.setOnClickListener(this);
        numPickOne.setOnClickListener(this);
        twinkle.setOnClickListener(this);
        seeNotes.setOnClickListener(this);

    }


    private void wireWidgets() {
         aButton=(Button)(findViewById(R.id.button_a));
        bButton=(Button)(findViewById(R.id.button_b));
        aSharpButton=(Button)(findViewById(R.id.button_a_sharp));
        cButton=(Button)(findViewById(R.id.button_c));
        cSharpButton=(Button)(findViewById(R.id.button_c_sharp));
        dButton=(Button)(findViewById(R.id.button_d));
        dSharpButton=(Button)(findViewById(R.id.button_d_sharp));
        eButton=(Button)(findViewById(R.id.button_e));
        fButton=(Button)(findViewById(R.id.button_f));
        fSharpButton=(Button)(findViewById(R.id.button_f_sharp));
        gButton=(Button)(findViewById(R.id.button_g));
        gSharpButton=(Button)(findViewById(R.id.button_g_sharp));
        aHighButton=(Button)(findViewById(R.id.button_a_high));
        aScaleButton=(Button)(findViewById(R.id.a_major));
        numPickOne=(NumberPicker)(findViewById(R.id.number_picker_one));
        numPickOne.setMinValue(1);
        numPickOne.setMaxValue(12);
        twinkle=(Button)(findViewById(R.id.twinkle));
        playSecondLineOrNah=(CheckBox)findViewById(R.id.playSecondLine);
        seeNotes=(Button)findViewById(R.id.switch_notes_page);





    }


    private void delayPlaying(int delay)
    {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Log.e("SynthesizerActivity","Audio playback interrupted");
        }
    }
    public void playTwinkleFirstLine()
    {
        playOnce(getaNote());
        playOnce(getaNote());
        playOnce(geteNote());
        playOnce(geteNote());
        playOnce(getfSharpNote());
        playOnce(getfSharpNote());
        playOnce(geteNote());
        playOnce(getdNote());
        playOnce(getdNote());
        playOnce(getcSharpNote());
        playOnce(getcSharpNote());
        playOnce(getbNote());
        playOnce(getbNote());
        playOnce(getaNote());
    }
    public void playTwinkleSecondLine()
    {
        playOnce(geteNote());
        playOnce(geteNote());
        playOnce(getdNote());
        playOnce(getdNote());
        playOnce(getcSharpNote());
        playOnce(getcSharpNote());
        playOnce(bNote);
    }

    public void playOnce(MediaPlayer m)
    {
        m.seekTo(0);
        m.start();
        delayPlaying(WHOLE_NOTE/4);
    }

    public void play(MediaPlayer m)
    {
        for(int i=0; i<numPickOne.getValue(); i++)
        {
            m.seekTo(0);
            m.start();
            delayPlaying(WHOLE_NOTE/4);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_a:
                play (aNote);
                    break;

            case R.id.button_a_sharp:
                play(aSharpNote);
                break;
            case  R.id.button_b:
                play(bNote);
                break;
            case  R.id.button_c:
                play(cNote);
                break;
            case  R.id.button_c_sharp:
                play(cSharpNote);
                break;
            case  R.id.button_d:
                play(dNote);
                break;
            case  R.id.button_d_sharp:
                play(dSharpNote);
                break;
            case  R.id.button_e:
                play(eNote);
                break;
            case  R.id.button_f:
                play(fNote);
                break;
            case  R.id.button_f_sharp:
                play(fSharpNote);
                break;
            case  R.id.button_g:
                play(gNote);
                break;
            case  R.id.button_g_sharp:
                play(gSharpNote);
                break;
            case  R.id.button_a_high:
                play(aHighNote);
                break;
            case R.id.a_major:
                MediaPlayer[] aScaleNotes= new MediaPlayer[]{aNote, bNote, cSharpNote, dNote, eNote, fSharpNote, gSharpNote, aHighNote};
                for(int i=0;i<aScaleNotes.length;i++)
                {
                    play(aScaleNotes[i]);
                }

                break;

            case R.id.twinkle:

                playTwinkleFirstLine();
                if(playSecondLineOrNah.isChecked()) {
                    playTwinkleSecondLine();
                    playTwinkleSecondLine();
                    playTwinkleFirstLine();
                }

                break;
            case R.id.switch_notes_page:

                setContentView(R.layout.notes);
                break;







            default:
        }
    }
}
