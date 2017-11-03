package humzaahmad.negative_edge_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setActionBar(toolbar);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.game_list);
        CustomAdapter customAdapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
