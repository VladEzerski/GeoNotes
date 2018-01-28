package com.ezerski.vladislav.geonotes;

import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Note> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView noteBackground;
        private TextView noteBody;

        private ViewHolder(View v) {
            super(v);
            noteBackground = v.findViewById(R.id.note_image);
            noteBody = v.findViewById(R.id.note_body);
        }
    }

    public RecyclerAdapter(List<Note> dataset) {
        mDataSet = dataset;
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Note note = mDataSet.get(position);
        holder.noteBody.setText(note.getBody());
        holder.noteBackground.getBackground().setColorFilter(note.getColor(),
                PorterDuff.Mode.SRC_ATOP);
    }
}