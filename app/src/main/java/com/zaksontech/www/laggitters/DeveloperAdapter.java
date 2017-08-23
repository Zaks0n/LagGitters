package com.zaksontech.www.laggitters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;




/**
 * Created by Zaks0n on 8/22/2017.
 */

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_URL = "url";

    private List<Developers> developers;
    private Context context;

    public DeveloperAdapter(List<Developers> developers, Context context) {

        this.developers = developers;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_all_profile, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final Developers developersList = developers.get(position);
        holder.userName.setText(developersList.getUserName());

        Picasso.with(context)
                .load(developersList.getAvatar_url())
                .into(holder.avatar_url);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Developers developersList = developers.get(position);

                Intent skipIntent = new Intent(v.getContext(), SingleProfileActivity.class);
                skipIntent.putExtra(KEY_NAME, developersList.getUserName());
                skipIntent.putExtra(KEY_URL, developersList.getHtml_url());
                skipIntent.putExtra(KEY_IMAGE, developersList.getAvatar_url());
                v.getContext().startActivity(skipIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return developers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView userName;
        public ImageView avatar_url;
        public TextView html_url;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            userName = (TextView) itemView.findViewById(R.id.username);
            avatar_url = (ImageView) itemView.findViewById(R.id.profilePic);
            html_url = (TextView) itemView.findViewById(R.id.url);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.profilecontainer);
        }

    }
}
