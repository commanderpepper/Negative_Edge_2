package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                goToAbout();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToAbout() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
