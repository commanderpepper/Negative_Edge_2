package humzaahmad.negative_edge_2.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Humza Ahmad, commanderpepper
 *         Created by Humza on 9/23/2017.
 *         This class gets the character list for the games within Negative Edge.
 *         It uses a HashMap where the keys are the Game Names and value is an array list populated with the game characters.
 */

public class CharacterLists {

    public Map<String, List<String>> characterList;
    public ArrayList<String> super_turbo;
    public ArrayList<String> alpha_2;

    public CharacterLists() {
        characterList = new HashMap<String, List<String>>();

        super_turbo = new ArrayList<>();
        super_turbo.add("Ryu");
        super_turbo.add("Old Ryu");
        super_turbo.add("Ken");
        super_turbo.add("Old Ken");
        super_turbo.add("Chun Li");
        super_turbo.add("Old Chun Li");
        super_turbo.add("Sagat");
        super_turbo.add("Old Sagat");
        super_turbo.add("Guile");
        super_turbo.add("Old Guile");
        super_turbo.add("Fei Long");
        super_turbo.add("Old Fei Long");
        super_turbo.add("Cammy");
        super_turbo.add("Old Cammy");
        super_turbo.add("Dhalsim");
        super_turbo.add("Old Dhalsim");
        super_turbo.add("Balrog");
        super_turbo.add("Old Balrog");
        super_turbo.add("Vega");
        super_turbo.add("Old Vega");
        super_turbo.add("M Bison");
        super_turbo.add("Old M Bison");
        super_turbo.add("E Honda");
        super_turbo.add("Old E Honda");
        super_turbo.add("Dee Jay");
        super_turbo.add("Old Dee Jay");
        super_turbo.add("T Hawk");
        super_turbo.add("Old T Hawk");
        super_turbo.add("Zangief");
        super_turbo.add("Old Zangief");
        super_turbo.add("Blanka");
        super_turbo.add("Old Blanka");
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
    }

    /**
     * @param gameName - the name of the game the user has chosen
     * @return - the ArrayList that represents a game list of characters
     */
    public ArrayList<String> getCharacterList(String gameName) {
        return (ArrayList<String>) characterList.get(gameName);
    }

}
