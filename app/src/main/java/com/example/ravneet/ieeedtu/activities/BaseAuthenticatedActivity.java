package com.example.ravneet.ieeedtu.activities;

import android.content.Intent;
import android.os.Bundle;

/**
 * Created by ravneet on 16/6/17.
 */

public abstract class BaseAuthenticatedActivity extends BaseActivity {

    @Override
    protected final void onCreate(Bundle savedState) {
        super.onCreate(savedState);

//        if(!application.getAuth().getUser().isLoggedIn()){
//            startActivity(new Intent(this,LoginActivity.class));
//            finish();
//            return;
//        }
//
//        onIEEECreate(savedState);
//    }
//
//    protected abstract void onIEEECreate(Bundle savedState);
    }
}
