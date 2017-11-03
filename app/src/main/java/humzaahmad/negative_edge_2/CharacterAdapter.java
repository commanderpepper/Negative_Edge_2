package humzaahmad.negative_edge_2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;

/**
 * Created by Humza on 2/16/2017.
 */

public class CharacterAdapter extends BaseTableAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private String [][] table;

    public CharacterAdapter(Context context, String [][] table) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        setInformation(table);
    }

    public void setInformation(String [][] table) {
        this.table = table;
    }

    public String[][] getInformation() {
        return table;
    }

    public Context getContext() {
        return context;
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public int getRowCount() {
        return table.length - 1;
    }

    @Override
    public int getColumnCount() {
        return table[0].length - 1;
    }

    @Override
    public View getView(int row, int column, View converView, ViewGroup parent) {
        if (converView == null) {
            converView = inflater.inflate(getLayoutResource(row, column), parent, false);
        }
        setText(converView, (table[row + 1][column + 1]));
        return converView;
    }

    @Override
    public int getWidth(int column)
    {
        if(column == getColumnCount()-1)
        {
            return 1000;
        }
        else {return 350;}

    }

    @Override
    public int getHeight(int row) {
        return 150;
    }

    public int getLayoutResource(int row, int column)
    {
        final int layoutResource;
        switch (getItemViewType(row, column)) {
            case 0:
                layoutResource = R.layout.table_row_header;
                break;
            case 1:
                layoutResource = R.layout.table_row_one;
                break;
            case 2:
                layoutResource = R.layout.table_row_two;
                break;
            default:
                throw new RuntimeException("???");
        }
        return layoutResource;
    }

    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int row, int column) {

        if(row<0)
        {
            return 0;
        }
        else if (row % 2 == 0)
        {
            return 2;
        }
        else
            return 1;

    }

    private void setText(View view, String text) {
        ((TextView) view.findViewById(android.R.id.text1)).setText(text);
    }

}
