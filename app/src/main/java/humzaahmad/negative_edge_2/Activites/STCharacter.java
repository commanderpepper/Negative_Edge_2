package humzaahmad.negative_edge_2.Activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.inqbarna.tablefixheaders.TableFixHeaders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import humzaahmad.negative_edge_2.Adapters.CharacterAdapter;
import humzaahmad.negative_edge_2.Data.GetCharacterFromFile;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 * This is an activity for ST characters. The reason for a special activity is due to the nature of ST.
 * ST has new and old characters. New Characters are the ones most people know. 
 * Old need a special code to access them in game.
 */

public class STCharacter extends AppCompatActivity {

    private String[][] newCharacter;
    private String[][] oldCharacter;
    boolean isNew = true;
    private TableFixHeaders tableFixHeaders;
    TextView nameView;
    String name;
    CharacterAdapter newAdapter;
    CharacterAdapter oldAdapter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        name = intent.getStringExtra("Text");

        toolbar = (Toolbar) findViewById(R.id.st_toolbar);
        toolbar.setTitle(name);
        setActionBar(toolbar);

        //nameView = (TextView) findViewById(R.id.textView);
        //nameView.setText(name);

        //Switch switchButton = (Switch) findViewById(R.id.switch1);


        if(name.equals("Akuma")) {
            //switchButton.setVisibility(View.INVISIBLE);
        }


        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);


        /**
         * @// TODO: 11/5/2017 I should move 'stList' into GetCharacterFromFile class 
         */
        Map<String, String[]> stList = new HashMap<String, String[]>();
        stList.put("Ryu", new String[]{"st_ryu", "st_o_ryu" });
        stList.put("Ken", new String[]{"st_ken", "st_o_ken" });
        stList.put("Chun Li", new String[]{"st_chunli", "st_o_chunli" });
        stList.put("Sagat", new String[]{"st_sagat", "st_o_sagat" });
        stList.put("Guile", new String[]{"st_guile", "st_o_guile" });
        stList.put("Fei Long", new String[]{"st_feilong", "st_o_feilong" });
        stList.put("Cammy", new String[]{"st_cammy", "st_o_cammy" });
        stList.put("Dhalsim", new String[]{"st_dhalsim", "st_o_dhalsim" });
        stList.put("Balrog", new String[]{"st_balrog", "st_o_balrog" });
        stList.put("Vega", new String[]{"st_vega", "st_o_vega"});
        stList.put("M Bison", new String[]{"st_mbison", "st_o_mbison" });
        stList.put("E Honda", new String[]{"st_ehonda", "st_o_ehonda" });
        stList.put("Dee Jay", new String[]{"st_deejay", "st_o_deejay" });
        stList.put("T Hawk", new String[]{"st_thawk", "st_o_thawk" });
        stList.put("Zangief", new String[]{"st_zangief", "st_o_zangief" });
        stList.put("Blanka", new String[]{"st_blanka", "st_o_blanka" });
        stList.put("Akuma", new String[]{"st_akuma", "st_akuma"});
        
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

        newCharacter = getCharacterFromFile.convertData(newCharacterData);
        newAdapter = new CharacterAdapter(this, newCharacter);

        if(!name.equals("Akuma"))
        {
            oldCharacter = getCharacterFromFile.convertData(oldCharacterData);
            oldAdapter = new CharacterAdapter(this, oldCharacter);
        }

        tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(newAdapter);
    }

    /**
     * @param view
     * Switches which adapter is shown to the user when they switch bewteen old and new
     * Uses a boolean to help with the switching
     */
    public void switchOldAndNew(View view) {
        if(isNew)
        {
            tableFixHeaders.setAdapter(oldAdapter);
            /**
             * @// TODO: 11/5/2017 Add the special code for each character 
             */
            //nameView.setText("Old " + name);
            toolbar.setTitle("Old " + name);
            isNew = false;
        }
        else
        {
            tableFixHeaders.setAdapter(newAdapter);
            //nameView.setText(name);
            toolbar.setTitle(name);
            isNew = true;
        }
    }

}
