package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class STCharacter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Text");

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);

        Map<String, String[]> stList = new HashMap<String,  String[]>();
        stList.put("Ryu",new String[]{"st_ryu","st_o_ryu"});
        stList.put("Ken",new String[]{"st_ken","st_o_ken"});
        stList.put("Chun Li",new String[]{"st_chunli","st_o_chunli"});
        stList.put("Sagat",new String[]{"st_sagat","st_o_sagat"});
        stList.put("Guile",new String[]{"st_guile","st_o_guile"});
        stList.put("Fei Long",new String[]{"st_feilong","st_o_feilong"});
        stList.put("Cammy",new String[]{"st_cammy","st_o_cammy"});
        stList.put("Dhalsim",new String[]{"st_dhalsim","st_o_dhalsim"});
        stList.put("Balrog",new String[]{"st_balrog","st_o_balrog"});
        stList.put("Vega",new String[]{"st_vega","st_o_vega"});
        stList.put("M Bison",new String[]{"st_mbison","st_o_mbison"});
        stList.put("E Honda",new String[]{"st_ehonda","st_o_ehonda"});
        stList.put("Dee Jay",new String[]{"st_deejay","st_o_deejay"});
        stList.put("T Hawk",new String[]{"st_thawk","st_o_thawk"});
        stList.put("Zangief",new String[]{"st_zangief","st_o_zangief"});
        stList.put("Blanka",new String[]{"st_blanka","st_o_blanka"});


        try
        {
            ArrayList<String[]> characterData = getCharacterFromFile.readFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
