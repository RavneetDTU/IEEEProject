package com.example.ravneet.ieeedtu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEEEvent;

import java.util.ArrayList;

/**
 * Created by ravneet on 2/8/17.
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private Context context;
    private ArrayList<IEEEEvent> eventList;

    public EventAdapter(Context context, ArrayList<IEEEEvent> eventList){
        this.context = context;
        this.eventList = eventList;
    }

    public void updateEventList(ArrayList<IEEEEvent> eventList){
        this.eventList = eventList;
        notifyDataSetChanged();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_item_event,parent,false);

        return new EventViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {

        IEEEEvent thisEvent = eventList.get(position);
        holder.title.setText(thisEvent.getTitle());
        holder.date.setText(thisEvent.getDate());

    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public

    class EventViewHolder extends RecyclerView.ViewHolder{

        TextView title,date;
        View thisview;

        public EventViewHolder(View itemView) {
            super(itemView);

            thisview = itemView;

            title = (TextView) itemView.findViewById(R.id.tv_EventTitle);
            date = (TextView) itemView.findViewById(R.id.tv_Eventdate);

        }
    }
}
