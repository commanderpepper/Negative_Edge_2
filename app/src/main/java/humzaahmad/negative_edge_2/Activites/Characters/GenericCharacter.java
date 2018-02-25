package humzaahmad.negative_edge_2.Activites.Characters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toolbar;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import java.io.IOException;
import java.util.ArrayList;

import humzaahmad.negative_edge_2.Adapters.FixedTableHeader.STAdapter;
import humzaahmad.negative_edge_2.Data.FileNames;
import humzaahmad.negative_edge_2.Data.GetCharacterFromFile;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 *         Currently not in use, it will mimic STCharacter but far more simplifed for future games
 *         Also, multiple game characters will use this class
 * @// TODO: 11/5/2017 Flesh out this class so in the future I can use it for games that don't have two versions.
 */

public class GenericCharacter extends AppCompatActivity {

    private String[][] characterData;
    private ArrayList<String[]> characterArray;
    private TableFixHeaders tableFixHeaders;
    String characterName;
    String gameName;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_character);

        Intent intent = getIntent();
        characterName = intent.getStringExtra("Name");
        gameName = intent.getStringExtra("Game");

        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        //Sets the toolbar title to character name
        toolbar.setTitle(characterName);
        setActionBar(toolbar);

        FileNames fileNames = new FileNames();

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);
        String fileName = fileNames.fileName.get(gameName).get(characterName);

        try {
            characterArray = getCharacterFromFile.readFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        characterData = getCharacterFromFile.convertData(characterArray);

        STAdapter tableAdapter = new STAdapter(this, characterData);
        tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(tableAdapter);


    }
}
