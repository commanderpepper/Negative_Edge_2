package humzaahmad.negative_edge_2;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Humza on 11/1/2017.
 */

public class GetCharacterFromFile {

    Context parentContext;

    public GetCharacterFromFile(Context parentContext) {
        this.parentContext = parentContext;
    }

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

    public String[][] convertData(ArrayList<String[]> characterData, int tableWidth)
    {
        String[][] characterInfo = new String[characterData.size()][tableWidth];
        for (int i = 0; i < characterInfo.length; i++) {
            characterInfo[i] = characterData.get(i);
        }
        return characterInfo;
    }
}
