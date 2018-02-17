package humzaahmad.negative_edge_2.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Humza Ahmad, commanderpepper
 * Created by Humza on 9/23/2017.
 * This class gets the character list for the games within Negative Edge.
 * It uses a HashMap where the keys are the Game Names and value is an array list populated with the game characters.
 * Future use might include storing old and new name for ST.
 * @// TODO: 11/5/2017 Add the character files into this object 
 * @// TODO: 11/5/2017 Add the character codes for old charaters in ST
 */

public class CharacterListGetter {

    public Map<String, List<String>>  characterList;
    public ArrayList<String> super_turbo;
    public ArrayList<String> alpha_2;
    public Map<String, String[]> stList;

    public CharacterListGetter() {
        characterList = new HashMap<String, List<String>>();
        
        super_turbo = new ArrayList<>();
        super_turbo.add("Ryu");
        super_turbo.add("Ken");
        super_turbo.add("Chun Li");
        super_turbo.add("Sagat");
        super_turbo.add("Guile");
        super_turbo.add("Fei Long");
        super_turbo.add("Cammy");
        super_turbo.add("Dhalsim");
        super_turbo.add("Balrog");
        super_turbo.add("Vega");
        super_turbo.add("M Bison");
        super_turbo.add("E Honda");
        super_turbo.add("Dee Jay");
        super_turbo.add("T Hawk");
        super_turbo.add("Zangief");
        super_turbo.add("Blanka");
        super_turbo.add("Akuma");

        alpha_2 = new ArrayList<>();
        alpha_2.add("Adon");
        alpha_2.add("Akuma");
        alpha_2.add("Birdie");
        alpha_2.add("Charlie");
        alpha_2.add("Chun Li");
        alpha_2.add("Dan");
        alpha_2.add("Dhalsim");
        alpha_2.add("Gen");
        alpha_2.add("Guy");
        alpha_2.add("Ken");
        alpha_2.add("M. Bison");
        alpha_2.add("Rolento");
        alpha_2.add("Rose");
        alpha_2.add("Ryu");
        alpha_2.add("Sagat");
        alpha_2.add("Sakura");
        alpha_2.add("Sodom");
        alpha_2.add("Zangief");

        characterList.put("Super Street Fighter 2 Super Turbo", super_turbo);
        characterList.put("Street Fighter Alpha 2", alpha_2);

        stList = new HashMap<String, String[]>();
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
        
    }

    /**
     * @param gameName - the name of the game the user has chosen
     * @return - the ArrayList that represents a game list of characters
     */
    public ArrayList<String> getCharacterList(String gameName)
    {
        return (ArrayList<String>) characterList.get(gameName);
    }

}
