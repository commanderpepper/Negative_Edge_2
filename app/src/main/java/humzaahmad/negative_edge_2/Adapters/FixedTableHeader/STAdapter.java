package humzaahmad.negative_edge_2.Adapters.FixedTableHeader;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;

import humzaahmad.negative_edge_2.R;

/**
 * This is the Character Adapter for the FixedTableLayout library
 * Currently it's used for Super Turbo only
 * In the future, other adapters might be made for different games
 */

public class STAdapter extends BaseTableAdapter {
    private final Context context;
    private final LayoutInflater inflater;
    private String[][] table;

    public STAdapter(Context context, String[][] table) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        setInformation(table);
    }

    public void setInformation(String[][] table) {
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

    /**
     * @param column the column. If the column is <code>-1</code> it is the header.
     * @return width for each column
     * -1 is the Move column
     * 0 is the Start Up column
     * getColumnCount()-1 is the Notes column
     */
    @Override
    public int getWidth(int column) {
        if (column == getColumnCount() - 1) {
            return 1500;
        } else if (column < 0) {
            return 425;
        } else if (column == 1) {
            return 550;
        } else {
            return 450;
        }

    }

    @Override
    public int getHeight(int row) {
        return 150;
    }

    /**
     * @param row
     * @param column
     * @return a view that will be used for a particular cell
     */
    public int getLayoutResource(int row, int column) {
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

    /**
     * @param row    The row of the item within the adapter's data table of the
     *               item whose view we want. If the row is <code>-1</code> it is
     *               the header.
     * @param column The column of the item within the adapter's data table of the
     *               item whose view we want. If the column is <code>-1</code> it
     *               is the header.
     * @return a number that indicates a type of row
     * <0 is the header
     * row % 2 are even rows
     * Rest are odd rows
     */
    @Override
    public int getItemViewType(int row, int column) {

        if (row < 0) {
            return 0;
        } else if (row % 2 == 0) {
            return 2;
        } else
            return 1;

    }

    private void setText(View view, String text) {
        ((TextView) view.findViewById(android.R.id.text1)).setText(text);
    }

}
