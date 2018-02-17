package humzaahmad.negative_edge_2.Activites.Characters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

import humzaahmad.negative_edge_2.Data.GetCharacterFromFile;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 *         Currently not in use, it will mimic STCharacter but far more simplifed for future games
 *         Also, multiple game characters will use this class
 * @// TODO: 11/5/2017 Flesh out this class so in the future I can use it for games that don't have two versions.
 */

public class GenericCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_character);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Text");

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);

        try {
            ArrayList<String[]> characterData = getCharacterFromFile.readFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
