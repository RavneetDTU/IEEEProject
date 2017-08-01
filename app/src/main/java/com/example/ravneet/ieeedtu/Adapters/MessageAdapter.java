package com.example.ravneet.ieeedtu.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Message;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ravneet on 1/8/17.
 */

public class MessageAdapter extends ArrayAdapter<Message> {

    public MessageAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Message> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.list_item_message,parent,false);
        }

        ImageView photoImageView = (ImageView) convertView.findViewById(R.id.iv_MessagePhoto);
        TextView message = (TextView) convertView.findViewById(R.id.tv_MessageText);
        TextView name = (TextView) convertView.findViewById(R.id.tv_messageUsername);

        Message thismessge = getItem(position);

        boolean isPhoto = thismessge.getPhotoUrl() != null;

        if(isPhoto){
            message.setVisibility(View.GONE);
            photoImageView.setVisibility(View.VISIBLE);
            Picasso.with(photoImageView.getContext()).load(thismessge.getPhotoUrl()).into(photoImageView);
        }
        else {
            message.setVisibility(View.VISIBLE);
            photoImageView.setVisibility(View.GONE);
            message.setText(thismessge.getText());
        }

        name.setText(thismessge.getName());

        return convertView;
    }
}
