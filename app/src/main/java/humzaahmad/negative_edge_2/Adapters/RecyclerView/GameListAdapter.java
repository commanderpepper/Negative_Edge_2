package humzaahmad.negative_edge_2.Adapters.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import humzaahmad.negative_edge_2.Activites.GenericGame;
import humzaahmad.negative_edge_2.R;

/**
 * @author Humza Ahmad, commanderpepper
 * Created by Humza on 9/23/2017.
 * Custom Adapter for Recycler View
 * Utilizes buttons for the views
 * Currently this adapter is used for the game list only.
 * In the future I should change the onClick button to choose which class the intent points to.
 */

public class GameListAdapter extends RecyclerView.Adapter<GameListAdapter.ViewHolder> {

    private List<String> data;
    private Context context;

    public Context getContext() {
        return context;
    }

    public GameListAdapter(List<String> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public GameListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View button = layoutInflater.inflate(R.layout.single_button,parent, false);
        ViewHolder viewHolder = new ViewHolder(button);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GameListAdapter.ViewHolder holder, int position) {
        String buttons = data.get(position);
        Button button = holder.button;
        button.setText(buttons);
        holder.setText(data.get(position));
        holder.setContext(getContext());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public Button button;
        public String text;
        public Context context;

        public Button getButton() {
            return button;
        }

        public void setButton(Button button) {
            this.button = button;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Context getContext() {
            return context;
        }

        public void setContext(Context context) {
            this.context = context;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            button = (Button) itemView.findViewById(R.id.button);
            button.setOnClickListener(this);
        }

        /**
         * @param view - This is the button view
         *             This class will start a new activity
         */
        @Override
        public void onClick(View view) {
            String text = getText();
            Intent intent = new Intent(context, GenericGame.class);
            intent.putExtra("Text", text);
            context.startActivity(intent);
        }
    }
}
