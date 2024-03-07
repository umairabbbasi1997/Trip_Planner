package com.liteapps.newtripplanner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.liteapps.newtripplanner.OnClickListener;
import com.liteapps.newtripplanner.R;
import com.liteapps.newtripplanner.model.TripModel;

import java.util.Collections;
import java.util.List;

public class TripAdapter
        extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    List<TripModel> list
            = Collections.emptyList();

    Context context;
    OnClickListener listiner;


    public TripAdapter(List<TripModel> list,
                                Context context,OnClickListener listiner)
    {
        this.list = list;
        this.context = context;
        this.listiner = listiner;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    @NonNull
    @Override
    public TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context
                = parent.getContext();
        LayoutInflater inflater
                = LayoutInflater.from(context);

        // Inflate the layout

        View photoView
                = inflater
                .inflate(R.layout.item_list,
                        parent, false);

        TripViewHolder viewHolder
                = new TripViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void
    onBindViewHolder(final TripViewHolder viewHolder,
                     final int position)
    {
        int index = viewHolder.getAdapterPosition();
        viewHolder.title
                .setText(list.get(position).getDestination());
        viewHolder.desc
                .setText(list.get(position).getTripDetails());
        viewHolder.time.setText(list.get(position).getTime());
        viewHolder.date
                .setText(list.get(position).getDate());
        viewHolder.itemView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listiner.onItemClick(index);
            }
        });
        viewHolder.btnDelete .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                listiner.onItemDelete(index);
            }
        });


    }



public class TripViewHolder extends RecyclerView.ViewHolder  {
    TextView title,desc,date,time;
    ImageView btnDelete;

    TripViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tv_title);
        desc = itemView.findViewById(R.id.tv_des);
        date = itemView.findViewById(R.id.tv_date);
        time = itemView.findViewById(R.id.tv_time);
        btnDelete = itemView.findViewById(R.id.btn_delete);

    }


}




}
