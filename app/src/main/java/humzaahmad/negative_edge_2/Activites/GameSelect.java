package humzaahmad.negative_edge_2.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toolbar;

import java.util.ArrayList;

import humzaahmad.negative_edge_2.Activites.About;
import humzaahmad.negative_edge_2.R;
import humzaahmad.negative_edge_2.RecyclerView.CustomAdapter;

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

    public void goToAbout(View view) {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
