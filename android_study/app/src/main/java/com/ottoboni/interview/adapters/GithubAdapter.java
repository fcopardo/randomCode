package com.ottoboni.interview.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ottoboni.interview.R;
import com.ottoboni.interview.data.GitHubProject;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by caoj on 28/03/18.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder>{

    private List<GitHubProject> mItems;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public GithubAdapter(List<GitHubProject> items, Context context, OnItemClickListener listener) {
        mItems = items;
        mContext = context;

        mListener = listener;

        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.onBind(mItems.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView projectName;

        public ViewHolder(View itemView) {
            super(itemView);
            projectName = itemView.findViewById(R.id.project_name);
        }

        public void onBind(final GitHubProject project, final OnItemClickListener listener) {

            projectName.setText(project.getProjectName());
            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(project);
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClicked(GitHubProject project);
    }

}
