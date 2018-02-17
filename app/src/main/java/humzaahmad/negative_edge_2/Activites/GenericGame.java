package humzaahmad.negative_edge_2.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import java.util.ArrayList;

import humzaahmad.negative_edge_2.Adapters.GameAdapter;
import humzaahmad.negative_edge_2.Data.CharacterListGetter;
import humzaahmad.negative_edge_2.R;

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

        Toolbar toolbar = (Toolbar) findViewById(R.id.character_toolbar);
        toolbar.setTitle(game);
        setActionBar(toolbar);

        //Logger log = Logger.getLogger("HUMZA");

        //Logger.getLogger(Level.SEVERE, "game string is " + game);
        //log.log(Level.SEVERE, game);
        CharacterListGetter game_to_display = new CharacterListGetter();

        data = game_to_display.getCharacterList(game);

        /*

        data = new ArrayList<>();
        data.add("Ryu");
        data.add("Ken");
        data.add("Chun Li");
        data.add("Sagat");
        data.add("Guile");
        data.add("Fei Long");
        data.add("Cammy");
        data.add("Dhalsim");
        data.add("Balrog");
        data.add("Vega");
        data.add("M Bison");
        data.add("E Honda");
        data.add("Dee Jay");
        data.add("T Hawk");
        data.add("Zangief");
        data.add("Akuma");
        data.add("Blanka");

        */

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.character_list);
        GameAdapter gameAdapter = new GameAdapter(data, this);
        recyclerView.setAdapter(gameAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

}
