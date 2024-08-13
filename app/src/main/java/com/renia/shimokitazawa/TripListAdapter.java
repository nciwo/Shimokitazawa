package com.renia.shimokitazawa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.ViewHolder> {
    private ArrayList<String> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tripName;

        ViewHolder(View itemView) {
            super(itemView);

            tripName = itemView.findViewById(R.id.trip_list_item_name);
        }
    }

    TripListAdapter(ArrayList<String> list) {
        mData = list;
    }

    @Override
    public TripListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.trip_list_item, parent, false);
        TripListAdapter.ViewHolder vh = new TripListAdapter.ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(TripListAdapter.ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.tripName.setText(text);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
