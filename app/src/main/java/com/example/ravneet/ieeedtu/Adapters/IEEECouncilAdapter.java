package com.example.ravneet.ieeedtu.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.CircularPropagation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ravneet on 19/7/17.
 */

public class IEEECouncilAdapter extends RecyclerView.Adapter<IEEECouncilAdapter.IEEECouncilHolder> {

    public static final String TAG = "false";

    private Context context;
    private ArrayList<IEEECouncil> councilList;

    public IEEECouncilAdapter(Context context,ArrayList<IEEECouncil> councilList){
        this.context = context;
        this.councilList = councilList;
    }

    public void updateCouncil(ArrayList<IEEECouncil> councilList){
        this.councilList = councilList;
        notifyDataSetChanged();
    }

    @Override
    public IEEECouncilHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.list_item_ieeecouncil,parent,false);

        return new IEEECouncilHolder(view);
    }

    @Override
    public void onBindViewHolder(IEEECouncilHolder holder, int position) {

        final IEEECouncil thismember = councilList.get(position);

        holder.PostOfMember.setText(thismember.getPost());
        holder.NameofMember.setText(thismember.getName());
        holder.Year.setText(thismember.getYear());
        Picasso.with(context).load(thismember.getImageurl()).fit().centerCrop().into(holder.iv_memberimage);

    }

    @Override
    public int getItemCount() {
        return councilList.size();
    }


    class IEEECouncilHolder extends RecyclerView.ViewHolder{

        View thisview;
        ImageView iv_memberimage;
        TextView PostOfMember,NameofMember,Year;

        public IEEECouncilHolder(View itemView) {
            super(itemView);

            thisview = itemView;
//
//            PostOfMember = (TextView) itemView.findViewById(R.id.tv_postOfMember);
//            NameofMember = (TextView) itemView.findViewById(R.id.tv_nameOfMember);
//            Year = (TextView) itemView.findViewById(R.id.tv_YearOfMember);
//            iv_memberimage = (ImageView) itemView.findViewById(R.id.iv_PostOfMember);

        }
    }
}
