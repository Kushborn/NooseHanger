package com.example.noosehanger;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> userNames;
    private ArrayList<Integer> mImages;
    private ArrayList<String> userScores;
    private Context mContext;


    public RecyclerViewAdapter(Context mContext, ArrayList<String> userNames, ArrayList<Integer> mImages, ArrayList<String> userScores) {
        this.userNames = userNames;
        this.mImages = mImages;
        this.userScores = userScores;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(mImages.get(position)).into(holder.userImage);

        holder.userName.setText(userNames.get(position));
        holder.userScore.setText(userScores.get(position));

        /*
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on: " + userNames.get(position));

                Toast.makeText(mContext, userNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        */
    }

    @Override
    public int getItemCount() {
        return userNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView userImage;
        TextView userName, userScore;
        RelativeLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            userImage = itemView.findViewById(R.id.profile_image);
            userName = itemView.findViewById(R.id.username);
            userScore = itemView.findViewById(R.id.userscore);

        }
    }
}
