package com.example.ravneet.ieeedtu.Adapters;

import android.content.Context;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Notification;

import java.util.ArrayList;

/**
 * Created by ravneet on 28/7/17.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationHolder> {

    private Context context;
    private ArrayList<Notification> notificationList;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public NotificationAdapter (Context context, ArrayList<Notification> notificationList){
        this.context = context;
        this.notificationList = notificationList;
    }


    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_notification,parent,false);

        return new NotificationHolder(itemview);

    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, int position) {

        final Notification thisnotificatioin = notificationList.get(position);

        holder.title.setText(thisnotificatioin.getTitle());
        holder.date.setText(thisnotificatioin.getDate());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(thisnotificatioin.getTitle());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    class NotificationHolder extends RecyclerView.ViewHolder{

        TextView title,date;
        View thisview;

        public NotificationHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_notificationTitle);
            date = (TextView) itemView.findViewById(R.id.tv_notificationDate);

            thisview = itemView;
        }
    }
}
