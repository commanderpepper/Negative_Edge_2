package humzaahmad.negative_edge_2.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Humza on 2/17/2018.
 */

public class FileNames {
    public Map<String, Map<String, String>> fileName;

    public FileNames() {
        fileName = new HashMap<String, Map<String, String>>();

        //I added in SFA2
        //TODO: Add the test of the character from Street Fighter Alpha 2
        fileName.put("Street Fighter Alpha 2", new HashMap<String, String>());
        fileName.get("Street Fighter Alpha 2").put("Adon", "alpha_2_adon");
    }
}
