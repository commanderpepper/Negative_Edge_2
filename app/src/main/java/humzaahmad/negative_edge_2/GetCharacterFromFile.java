package humzaahmad.negative_edge_2;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Humza on 11/1/2017.
 * @author Humza Ahmad, commanderpepper
 * This class gets the data from the txt files in the res/raw folder
 */

public class GetCharacterFromFile {

    Context parentContext;

    public GetCharacterFromFile(Context parentContext) {
        this.parentContext = parentContext;
    }

    /**
     * @param filename - a filename, a character file txt file needs to passed through
     * @return data - an array list populated by string arrays.
     *                  Each string array represents a move.
     *                  Each line in the txt file represents a move.
     * @throws IOException
     */
    public ArrayList<String []> readFile(String filename) throws IOException {

        ArrayList<String[]> data = new ArrayList<>();
        int id = parentContext.getResources().getIdentifier(filename, "raw", parentContext.getPackageName());

        InputStream inputStream = parentContext.getResources().openRawResource(id);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);

        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            data.add(line.split(";"));
        }

        reader.close();
        inputStream.close();
        return data;
    }

    /**
     * @param characterData - the ArrayList from the readFile method
     * @return a 2D array needed for fixedTableLayout
     */
    public String[][] convertData(ArrayList<String[]> characterData)
    {
        int tableWidth = characterData.get(0).length;

        String[][] characterInfo = new String[characterData.size()][tableWidth];
        for (int i = 0; i < characterInfo.length; i++) {
            characterInfo[i] = characterData.get(i);
        }
        return characterInfo;
    }
}
