package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class GenericGame extends AppCompatActivity {

    ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_game);

        Intent intent = getIntent();
        String character = intent.getStringExtra("Text");

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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.character_list);
        CustomAdapter customAdapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(customAdapter);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
