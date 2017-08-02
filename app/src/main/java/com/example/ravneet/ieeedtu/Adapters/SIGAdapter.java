package com.example.ravneet.ieeedtu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.SIGModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by ravneet on 19/7/17.
 */

public class SIGAdapter extends RecyclerView.Adapter<SIGAdapter.SIGViewHolder> {

    private Context context;
    private ArrayList<SIGModel> sigArrayList;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public SIGAdapter (Context context,ArrayList<SIGModel> sigArrayList){
        this.context = context;
        this.sigArrayList = sigArrayList;
    }

    public void updateSIGList(ArrayList<SIGModel> sigArrayList){
        this.sigArrayList = sigArrayList;
        notifyDataSetChanged();
    }

    @Override
    public SIGViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View itemview = li.inflate(R.layout.list_itemsignotification,parent,false);

        return new SIGViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(SIGViewHolder holder, int position) {

        final SIGModel thisSIG = sigArrayList.get(position);

        holder.title.setText(thisSIG.getTitle());
        holder.place.setText(thisSIG.getPlace());
        holder.date.setText(thisSIG.getDate());
        holder.thisview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(thisSIG.getTitle(),null);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return sigArrayList.size();
    }

    class SIGViewHolder extends RecyclerView.ViewHolder{

        View thisview;
        TextView title,date,place;

        public SIGViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.tv_SIGtitle);
            date = (TextView) itemView.findViewById(R.id.tv_SIGDate);
            place = (TextView) itemView.findViewById(R.id.tv_SIGPlace);

            thisview = itemView;
        }
    }
}
