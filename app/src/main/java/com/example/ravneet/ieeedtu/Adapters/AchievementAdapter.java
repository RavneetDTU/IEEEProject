package com.example.ravneet.ieeedtu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Achievement;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ravneet on 30/7/17.
 */

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder> {

    private Context context;
    private ArrayList<Achievement> achievementList;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public AchievementAdapter(Context context, ArrayList<Achievement> achievementList){
        this.context = context;
        this.achievementList = achievementList;
    }

    public void updateAchievements(ArrayList<Achievement> achievementList){
        this.achievementList = achievementList;
        notifyDataSetChanged();
    }

    @Override
    public AchievementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_achivement,parent,false);

        return new AchievementViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(AchievementViewHolder holder, int position) {

        final Achievement thisAchievement = achievementList.get(position);

        holder.title.setText(thisAchievement.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(thisAchievement.getTitle(),thisAchievement.getBody(),null,null);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return achievementList.size();
    }

    class AchievementViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        View thisview;

        public AchievementViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_achivemenmtTitle);
            thisview = itemView;
        }
    }
}
