package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Humza on 9/23/2017.
 * Gets the characters for whatever game was passed via the intent.
 */

public class GenericGame extends AppCompatActivity {

    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_game);

        Intent intent = getIntent();
        String game = intent.getStringExtra("Text");

        CharacterListGetter game_to_display = new CharacterListGetter(game);

        data = game_to_display.getCharacterList();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.character_list);
        CustomAdapter customAdapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(customAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
