package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STCharacter extends AppCompatActivity {

    private String[][] newCharacter;
    private String[][] oldCharacter;
    boolean isNew = true;
    private TableFixHeaders tableFixHeaders;
    TextView nameView;
    String name;
    CharacterAdapter newAdapter;
    CharacterAdapter oldAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        name = intent.getStringExtra("Text");

        nameView = (TextView) findViewById(R.id.textView);
        nameView.setText(name);

        Switch switchButton = (Switch) findViewById(R.id.switch1);

        if(name.equals("Akuma")) {
            switchButton.setVisibility(View.INVISIBLE);
        }

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);

        Map<String, String[]> stList = new HashMap<String, String[]>();
        stList.put("Ryu", new String[]{"st_ryu", "st_o_ryu", "nwidth", "owidth"});
        stList.put("Ken", new String[]{"st_ken", "st_o_ken", "nwidth", "owidth"});
        stList.put("Chun Li", new String[]{"st_chunli", "st_o_chunli", "nwidth", "owidth"});
        stList.put("Sagat", new String[]{"st_sagat", "st_o_sagat", "nwidth", "owidth"});
        stList.put("Guile", new String[]{"st_guile", "st_o_guile", "nwidth", "owidth"});
        stList.put("Fei Long", new String[]{"st_feilong", "st_o_feilong", "nwidth", "owidth"});
        stList.put("Cammy", new String[]{"st_cammy", "st_o_cammy", "nwidth", "owidth"});
        stList.put("Dhalsim", new String[]{"st_dhalsim", "st_o_dhalsim", "nwidth", "owidth"});
        stList.put("Balrog", new String[]{"st_balrog", "st_o_balrog", "nwidth", "owidth"});
        stList.put("Vega", new String[]{"st_vega", "st_o_vega", "vwidth", "gwidth"});
        stList.put("M Bison", new String[]{"st_mbison", "st_o_mbison", "nwidth", "owidth"});
        stList.put("E Honda", new String[]{"st_ehonda", "st_o_ehonda", "nwidth", "owidth"});
        stList.put("Dee Jay", new String[]{"st_deejay", "st_o_deejay", "nwidth", "owidth"});
        stList.put("T Hawk", new String[]{"st_thawk", "st_o_thawk", "gwidth", "ogwidth"});
        stList.put("Zangief", new String[]{"st_zangief", "st_o_zangief", "gwidth", "ogwidth"});
        stList.put("Blanka", new String[]{"st_blanka", "st_o_blanka", "nwidth", "owidth"});
        stList.put("Akuma", new String[]{"st_akuma", "st_akuma", "nwidth"});

        /*
        When retrieving the data, a 'table width' needs to be passed.
        Most characters in ST need a tw of 15.
        Grapplers (Gief and Hawk) tw is 14, old 12
        Normal tw is 15, old 13
        Vega tw is 16, he has two damage columns, clawed and clawless
         */

        Map<String, Integer> tableWidth = new HashMap<>();
        tableWidth.put("nwidth", 15);
        tableWidth.put("gwidth", 14);
        tableWidth.put("vwidth", 16);
        tableWidth.put("owidth", 13);
        tableWidth.put("ogwidth", 12);

        ArrayList<String[]> newCharacterData = null;
        ArrayList<String[]> oldCharacterData = null;

        try {
            newCharacterData = getCharacterFromFile.readFile(stList.get(name)[0]);
            if(!name.equals("Akuma"))
            {
                oldCharacterData = getCharacterFromFile.readFile(stList.get(name)[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        newCharacter = getCharacterFromFile.convertData(newCharacterData, tableWidth.get(stList.get(name)[2]));
        newAdapter = new CharacterAdapter(this, newCharacter);

        if(!name.equals("Akuma"))
        {
            oldCharacter = getCharacterFromFile.convertData(oldCharacterData, tableWidth.get(stList.get(name)[3]));
            oldAdapter = new CharacterAdapter(this, oldCharacter);
        }

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(newAdapter);
    }

    public void switchOldAndNew(View view) {
        if(isNew)
        {
            tableFixHeaders.setAdapter(oldAdapter);
            nameView.setText("Old " + name);
            isNew = false;
        }
        else
        {
            tableFixHeaders.setAdapter(newAdapter);
            nameView.setText(name);
            isNew = true;
        }
    }
}
