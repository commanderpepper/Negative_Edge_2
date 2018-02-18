package humzaahmad.negative_edge_2.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Humza on 2/17/2018.
 */

public class STFileNames {
    public Map<String, String[]> stFileNameList;

    public STFileNames() {
        stFileNameList = new HashMap<String, String[]>();
        stFileNameList.put("Ryu", new String[]{"st_ryu", "st_o_ryu"});
        stFileNameList.put("Ken", new String[]{"st_ken", "st_o_ken"});
        stFileNameList.put("Chun Li", new String[]{"st_chunli", "st_o_chunli"});
        stFileNameList.put("Sagat", new String[]{"st_sagat", "st_o_sagat"});
        stFileNameList.put("Guile", new String[]{"st_guile", "st_o_guile"});
        stFileNameList.put("Fei Long", new String[]{"st_feilong", "st_o_feilong"});
        stFileNameList.put("Cammy", new String[]{"st_cammy", "st_o_cammy"});
        stFileNameList.put("Dhalsim", new String[]{"st_dhalsim", "st_o_dhalsim"});
        stFileNameList.put("Balrog", new String[]{"st_balrog", "st_o_balrog"});
        stFileNameList.put("Vega", new String[]{"st_vega", "st_o_vega"});
        stFileNameList.put("M Bison", new String[]{"st_mbison", "st_o_mbison"});
        stFileNameList.put("E Honda", new String[]{"st_ehonda", "st_o_ehonda"});
        stFileNameList.put("Dee Jay", new String[]{"st_deejay", "st_o_deejay"});
        stFileNameList.put("T Hawk", new String[]{"st_thawk", "st_o_thawk"});
        stFileNameList.put("Zangief", new String[]{"st_zangief", "st_o_zangief"});
        stFileNameList.put("Blanka", new String[]{"st_blanka", "st_o_blanka"});
        stFileNameList.put("Akuma", new String[]{"st_akuma", "st_akuma"});
    }
}
