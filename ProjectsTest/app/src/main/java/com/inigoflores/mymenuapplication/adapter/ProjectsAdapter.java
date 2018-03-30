package com.inigoflores.mymenuapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inigoflores.mymenuapplication.R;
import com.inigoflores.mymenuapplication.Repository.Item;

import java.util.List;

/**
 * Created by inigo on 27/03/18.
 */

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolderAdapter>{

    List<Item> projects;
    Context context;
    int view;

    public ProjectsAdapter(List<Item> projects, Context context, int view) {
        this.projects = projects;
        this.context = context;
        this.view = view;
    }

    @Override
    public ViewHolderAdapter onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflated = LayoutInflater.from(parent.getContext()).inflate(view, parent, false);
        return new ViewHolderAdapter(inflated);
    }

    @Override
    public void onBindViewHolder(ViewHolderAdapter holder, int position) {
        holder.tv_name.setText(projects.get(position).name);
        holder.tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.github.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolderAdapter extends RecyclerView.ViewHolder{

        public TextView tv_name;

        public ViewHolderAdapter(View v) {
            super(v);
            tv_name = v.findViewById(R.id.tv_itemname);
        }
    }
}
