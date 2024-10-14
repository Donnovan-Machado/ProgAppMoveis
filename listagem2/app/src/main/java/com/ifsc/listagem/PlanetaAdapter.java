package com.ifsc.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ifsc.listagem.Planeta;
import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    Context mContext;
    Integer mResouse;
    List<Planeta> mListPlaneta;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        mContext=context;
        mResouse=resource;
        mListPlaneta=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        View view = layoutInflater.inflate(mResouse, parent, false);

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvnomeplaneta = view.findViewById(R.id.textViewNome);

        Planeta planeta = mListPlaneta.get(position);

        tvnomeplaneta.setText(planeta.nome);
        imageView.setImageResource(planeta.foto);

        return view;

    }
}

