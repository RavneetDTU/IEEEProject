package com.example.ravneet.ieeedtu.Adapters;

import android.support.v7.widget.CardView;

/**
 * Created by ravneet on 17/8/17.
 */

public interface CardAdapter {

    public final int MAX_ELEVATION_FACTOR = 8;
    float getBaseElevation();
    CardView getCardViewAt(int position);
    int getCount();
}
