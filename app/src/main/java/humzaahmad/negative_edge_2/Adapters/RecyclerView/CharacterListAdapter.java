package humzaahmad.negative_edge_2.Adapters.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import humzaahmad.negative_edge_2.Activites.Characters.GenericCharacter;
import humzaahmad.negative_edge_2.R;
import humzaahmad.negative_edge_2.Activites.Characters.STCharacter;

/**
 * @author Humza Ahmad, commanderpepper
 *         Created by Humza on 9/23/2017.
 *         Custom Adapter for Recycler View
 *         Utilizes buttons for the views
 *         Currently this adapter is used for the character list only.
 *         In the future I should change the onClick button to choose which class the intent points to.
 */

public class CharacterListAdapter extends RecyclerView.Adapter<CharacterListAdapter.ViewHolder> {

    private List<String> data;
    private Context context;
    private String game;

    public Context getContext() {
        return context;
    }

    public CharacterListAdapter(String game, List<String> data, Context context) {
        this.game = game;
        this.data = data;
        this.context = context;
    }

    @Override
    public CharacterListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View button = layoutInflater.inflate(R.layout.single_button, parent, false);
        ViewHolder viewHolder = new ViewHolder(button);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CharacterListAdapter.ViewHolder holder, int position) {
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
            String name = getText();
            //Goes to the character being called. Only goes to ST characters, let's try to change that.
            Intent intent;
            if (game.equals("Super Street Fighter 2 Super Turbo")) {
                intent = new Intent(context, STCharacter.class);
            } else
                intent = new Intent(context, GenericCharacter.class);
            intent.putExtra("Name", name);
            intent.putExtra("Game", game);
            context.startActivity(intent);
        }
    }
}
