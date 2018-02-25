package humzaahmad.negative_edge_2.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridLayout;
import android.widget.Toolbar;

import java.util.ArrayList;

import humzaahmad.negative_edge_2.Adapters.RecyclerView.CharacterListAdapter;
import humzaahmad.negative_edge_2.Data.CharacterLists;
import humzaahmad.negative_edge_2.R;

/**
 * Created by Humza on 9/23/2017.
 * Gets the characters for whatever game was passed via the intent.
 */

public class GenericGame extends AppCompatActivity {

    //The list of characters in a game
    ArrayList<String> characterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_game);

        Intent intent = getIntent();
        String game = intent.getStringExtra("Text");

        Toolbar toolbar = (Toolbar) findViewById(R.id.character_toolbar);
        toolbar.setTitle(game);
        setActionBar(toolbar);

        characterList = new CharacterLists().getCharacterList(game);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.character_list);
        CharacterListAdapter gameAdapter = new CharacterListAdapter(game, characterList, this);
        recyclerView.setAdapter(gameAdapter);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);
    }

}
