package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class GenericCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_character);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Text");

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);

        try
        {
            ArrayList<String[]> characterData = getCharacterFromFile.readFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
