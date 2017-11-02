package humzaahmad.negative_edge_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stcharacter);

        Intent intent = getIntent();
        String name = intent.getStringExtra("Text");

        TextView nameView = (TextView) findViewById(R.id.textView);
        nameView.setText(name);

        GetCharacterFromFile getCharacterFromFile = new GetCharacterFromFile(this);

        Map<String, String[]> stList = new HashMap<String, String[]>();
        stList.put("Ryu", new String[]{"st_ryu", "st_o_ryu"});
        stList.put("Ken", new String[]{"st_ken", "st_o_ken"});
        stList.put("Chun Li", new String[]{"st_chunli", "st_o_chunli"});
        stList.put("Sagat", new String[]{"st_sagat", "st_o_sagat"});
        stList.put("Guile", new String[]{"st_guile", "st_o_guile"});
        stList.put("Fei Long", new String[]{"st_feilong", "st_o_feilong"});
        stList.put("Cammy", new String[]{"st_cammy", "st_o_cammy"});
        stList.put("Dhalsim", new String[]{"st_dhalsim", "st_o_dhalsim"});
        stList.put("Balrog", new String[]{"st_balrog", "st_o_balrog"});
        stList.put("Vega", new String[]{"st_vega", "st_o_vega"});
        stList.put("M Bison", new String[]{"st_mbison", "st_o_mbison"});
        stList.put("E Honda", new String[]{"st_ehonda", "st_o_ehonda"});
        stList.put("Dee Jay", new String[]{"st_deejay", "st_o_deejay"});
        stList.put("T Hawk", new String[]{"st_thawk", "st_o_thawk"});
        stList.put("Zangief", new String[]{"st_zangief", "st_o_zangief"});
        stList.put("Blanka", new String[]{"st_blanka", "st_o_blanka"});


        ArrayList<String[]> characterData = null;
        try {
            characterData = getCharacterFromFile.readFile(stList.get(name)[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        newCharacter = getTable(characterData, 15);
        TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.char_table);
        tableFixHeaders.setAdapter(new CharacterAdapter(this, newCharacter));
    }

    public String[][] getTable(ArrayList<String[]> characterData, int tableWidth) {

        String[][] characterInfo = new String[characterData.size()][tableWidth];
        for (int i = 0; i < characterInfo.length; i++) {
            characterInfo[i] = characterData.get(i);
        }
        return characterInfo;
    }
}
