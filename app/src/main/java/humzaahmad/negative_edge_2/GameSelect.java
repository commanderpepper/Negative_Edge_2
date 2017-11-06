package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toolbar;

import java.util.ArrayList;

/**
 * Created by Humza on 9/23/2017.
 * Displays the games within Negative Edge.
 * This is the launcher activity for Negative Edge.
 * Buttons lead to Character Select
 */

public class GameSelect extends AppCompatActivity {

    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);

        data = new ArrayList<>();
        data.add("Super Street Fighter 2 Super Turbo");
        //data.add("Street Fighter Alpha 2");

        Toolbar toolbar = (Toolbar) findViewById(R.id.st_toolbar);
        setActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.game_list);
        CustomAdapter customAdapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
