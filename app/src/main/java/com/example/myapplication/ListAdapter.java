package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;





import java.util.List;

public class ListAdapter extends ArrayAdapter<Resultados> {
    public ListAdapter(Context context, List<Resultados> objects) {
        super(context, 0, objects);
    }

    public static void swapItems(List<Resultados> serverAppointments) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        if(null == convertView){
            convertView = inflater.inflate(
                    R.layout.list_item,
                    parent,
                    false);

            holder = new ViewHolder();

            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.title = (TextView) convertView.findViewById(R.id.realnam);
            holder.team = (TextView) convertView.findViewById(R.id.team);
            holder.firstappearance= (TextView) convertView.findViewById(R.id.firstappearance);
            holder.createdby = (TextView) convertView.findViewById(R.id.createdby);
            holder.publisher = (TextView) convertView.findViewById(R.id.publisher);
            holder.bio = (TextView) convertView.findViewById(R.id.bio);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        Resultados resultados = getItem(position);
        holder.name.setText(resultados.getName());
        holder.title.setText(resultados.getRealName());
        holder.team.setText(resultados.getTeam());
        holder.firstappearance.setText(resultados.getAppearance());
        holder.createdby.setText(resultados.getCreador());
        holder.publisher.setText(resultados.getPublisher());
        holder.bio.setText(resultados.getBio());

        return convertView;
    }
    static class ViewHolder {

        TextView name;
        TextView title;
        TextView team;
        TextView firstappearance;
        TextView createdby;
        TextView publisher;
        TextView bio;
    }
}
