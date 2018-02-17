package humzaahmad.negative_edge_2.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toolbar;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import humzaahmad.negative_edge_2.Adapters.CharacterAdapter;
import humzaahmad.negative_edge_2.Data.CharacterListGetter;
import humzaahmad.negative_edge_2.Data.GetCharacterFromFile;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 * This is an activity for ST characters. The reason for a special activity is due to the nature of ST.
 * ST has new and old characters. New Characters are the ones most people know. 
 * Old need a special code to access them in game.
 */

public class STCharacter extends AppCompatActivity {

    private String[][] newCharacter;
    private String[][] oldCharacter;
    boolean isNew = true;
    private TableFixHeaders tableFixHeaders;
    String name;
    CharacterAdapter newAdapter;
    CharacterAdapter oldAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        name = intent.getStringExtra("Text");

        toolbar = (Toolbar) findViewById(R.id.st_toolbar);
        toolbar.setTitle(name);
        setActionBar(toolbar);

        Switch switchButton = (Switch) findViewById(R.id.switchButton);

        if(name.equals("Akuma")) {
            switchButton.setVisibility(View.INVISIBLE);
        }

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);


        /**
         * @// TODO: 11/5/2017 I should move 'stList' into GetCharacterFromFile class 
         */

        CharacterListGetter cg = new CharacterListGetter();


        Map<String, String[]> stList = cg.stList;
        
        ArrayList<String[]> newCharacterData = null;
        ArrayList<String[]> oldCharacterData = null;

        try {
            newCharacterData = getCharacterFromFile.readFile(stList.get(name)[0]);
            if(!name.equals("Akuma"))
            {
                oldCharacterData = getCharacterFromFile.readFile(stList.get(name)[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        newCharacter = getCharacterFromFile.convertData(newCharacterData);
        newAdapter = new CharacterAdapter(this, newCharacter);

        if(!name.equals("Akuma"))
        {
            oldCharacter = getCharacterFromFile.convertData(oldCharacterData);
            oldAdapter = new CharacterAdapter(this, oldCharacter);
        }

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(newAdapter);
    }

    /**
     * @param view
     * Switches which adapter is shown to the user when they switch bewteen old and new
     * Uses a boolean to help with the switching
     */
    public void switchOldAndNew(View view) {
        if(isNew)
        {
            tableFixHeaders.setAdapter(oldAdapter);
            /**
             * @// TODO: 11/5/2017 Add the special code for each character 
             */
            //nameView.setText("Old " + name);
            toolbar.setTitle("Old " + name);
            isNew = false;
        }
        else
        {
            tableFixHeaders.setAdapter(newAdapter);
            //nameView.setText(name);
            toolbar.setTitle(name);
            isNew = true;
        }
    }

}
