package org.esiea.merrouche_rauber.myapplication;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
public class CharactersAdapter extends RecyclerView.Adapter<CharactersAdapter.CharactersHolder> {
private JSONArray characters;
public CharactersAdapter (JSONArray characters){
        this.characters=characters;
        }

@Override
public CharactersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater lI = LayoutInflater.from(parent.getContext());
        View view = lI.inflate(R.layout.rv_characters_element,parent,false);
        return new CharactersHolder(view);
        }

@Override
public void onBindViewHolder(CharactersHolder holder, int position) {
        try {
        holder.name.setText(characters.getJSONObject(position).getString("name"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
}

@Override
public int getItemCount() {
        if(characters != null) {
        return characters.length();
        }
        else{
        return 0;
        }
        }

public class CharactersHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public CharactersHolder(View view) {
        super(view);
        this.name=(TextView) view.findViewById(R.id.rv_characters_element_name);
    }
}

    public void setNewCharacters (JSONArray newCharacters){
        this.characters=newCharacters;
        notifyDataSetChanged();
        Log.d("TAG", String.valueOf(getItemCount()));
    }

}
