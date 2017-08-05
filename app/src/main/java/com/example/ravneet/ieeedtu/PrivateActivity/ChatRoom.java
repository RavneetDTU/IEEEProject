package com.example.ravneet.ieeedtu.PrivateActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.ravneet.ieeedtu.Adapters.MessageAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.Message;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatRoom extends AppCompatActivity {

//    public static final int DEFAULT_MES_LENGTH_LIMIT = 100;
//    public static final int RC_PHOTO_PICKER = 1;
//
//    private ListView listView;
//    private MessageAdapter adapter;
//    private ProgressBar progressBar;
//    private ImageButton PhotoPickerButton;
//    private EditText et_Message;
//    private Button btn_MessageSend;
//
//    private FirebaseDatabase firebaseDatabase;
//    private FirebaseAuth firebaseAuth;
//    private DatabaseReference databaseReference;
//    private FirebaseStorage firebaseStorage;
//    private StorageReference storageReference;
//
//    private MessageAdapter messageAdapter;
//
//    private ValueEventListener valueEventListener = new ValueEventListener() {
//        @Override
//        public void onDataChange(DataSnapshot dataSnapshot) {
//
//            for(DataSnapshot data : dataSnapshot.getChildren()){
//                Message thisMessge = new Message(data.child("text").getValue().toString(),data.child("name").getValue().toString(),null);
//                messageAdapter.add(thisMessge);
//            }
//
//        }
//
//        @Override
//        public void onCancelled(DatabaseError databaseError) {
//
//        }
//    };

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);


        Picasso.with(this).load("https://github.com/RavneetDTU/IEEEProject/blob/master/ComingSoon.png").into((ImageView) findViewById(R.id.iv_imageChat));
        progressBar.setVisibility(ProgressBar.GONE);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        firebaseStorage = FirebaseStorage.getInstance();
//        firebaseAuth = FirebaseAuth.getInstance();
//
//        progressBar = (ProgressBar) findViewById(R.id.progressBar);
//        listView = (ListView) findViewById(R.id.messageListView);
//        PhotoPickerButton = (ImageButton) findViewById(R.id.photoPickerButton);
//        et_Message = (EditText) findViewById(R.id.messageEditText);
//        btn_MessageSend = (Button) findViewById(R.id.sendButton);
//
//        databaseReference = firebaseDatabase.getReference().child("Messages");
//        storageReference = firebaseStorage.getReference().child("Chat_Photos");
//
//        progressBar.setVisibility(ProgressBar.INVISIBLE);
//
//        PhotoPickerButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
//                i.setType("image/*");
//                i.putExtra(i.EXTRA_LOCAL_ONLY,true);
//                startActivityForResult(i.createChooser(i,"Complete Action Using...."),RC_PHOTO_PICER);K
//
//            }
//        });
//
//        btn_MessageSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Message thismessage = new Message(et_Message.getText().toString(),firebaseAuth.getCurrentUser().getDisplayName(),null);
//
//                databaseReference.push().setValue(thismessage);
//
//                et_Message.setText("");
//            }
//        });
//
//        et_Message.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MES_LENGTH_LIMIT)});
//
//        databaseReference.addValueEventListener(valueEventListener);
//
    }
}

