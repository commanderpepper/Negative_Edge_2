package humzaahmad.negative_edge_2.Activites.Characters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toolbar;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import humzaahmad.negative_edge_2.Adapters.FixedTableHeader.STAdapter;
import humzaahmad.negative_edge_2.Data.CharacterLists;
import humzaahmad.negative_edge_2.Data.GetCharacterFromFile;
import humzaahmad.negative_edge_2.Data.STFileNames;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 *         This is an activity for ST characters. The reason for a special activity is due to the nature of ST.
 *         ST has new and old characters. New Characters are the ones most people know.
 *         Old need a special code to access them in game.
 *         This activity has a switch added to the toolbar
 */

public class STCharacter extends AppCompatActivity {

    private String[][] newCharacter;
    private String[][] oldCharacter;
    boolean isNew = true;
    private TableFixHeaders tableFixHeaders;
    String name;
    STAdapter newAdapter;
    STAdapter oldAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        name = intent.getStringExtra("Name");


        toolbar = (Toolbar) findViewById(R.id.st_toolbar);
        //Sets the toolbar title to character name
        toolbar.setTitle(name);
        setActionBar(toolbar);
        //Switch view used to switch from new to old versions and vice versa
        Switch switchButton = (Switch) findViewById(R.id.switchButton);

        //Akuma does not have an old version in ST, therefore the switch button is set to invisible
        if (name.equals("Akuma")) {
            switchButton.setVisibility(View.INVISIBLE);
        }

        //GetCharacterFromFile gets the characterList from the txt files
        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);
        CharacterLists characterListGetter = new CharacterLists();
        STFileNames stFileNames = new STFileNames();

        Map<String, String[]> stFileNameList = stFileNames.stFileNameList;

        //Array List of new character characterList
        ArrayList<String[]> newCharacterData = null;
        //Array List of old character characterList
        ArrayList<String[]> oldCharacterData = null;

        try {
            newCharacterData = getCharacterFromFile.readFile(stFileNameList.get(name)[0]);
            if (!name.equals("Akuma")) {
                oldCharacterData = getCharacterFromFile.readFile(stFileNameList.get(name)[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Converts the 2D Array List into a 2D Array for the adapter
        newCharacter = getCharacterFromFile.convertData(newCharacterData);
        newAdapter = new STAdapter(this, newCharacter);

        if (!name.equals("Akuma")) {
            oldCharacter = getCharacterFromFile.convertData(oldCharacterData);
            oldAdapter = new STAdapter(this, oldCharacter);
        }

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(newAdapter);
    }

    /**
     * @param view Switches which adapter is shown to the user when they switch bewteen old and new
     *             Uses a boolean to help with the switching
     */
    public void switchOldAndNew(View view) {
        if (isNew) {
            tableFixHeaders.setAdapter(oldAdapter);
            toolbar.setTitle("Old " + name);
            isNew = false;
        } else {
            tableFixHeaders.setAdapter(newAdapter);
            toolbar.setTitle(name);
            isNew = true;
        }
    }

}
