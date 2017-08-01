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
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.ravneet.ieeedtu.Adapters.MessageAdapter;
import com.example.ravneet.ieeedtu.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ChatRoom extends AppCompatActivity {

    public static final int DEFAULT_MES_LENGTH_LIMIT = 100;
    public static final int RC_PHOTO_PICKER = 1;

    private ListView listView;
    private MessageAdapter adapter;
    private ProgressBar progressBar;
    private ImageButton PhotoPickerButton;
    private EditText et_Message;
    private Button btn_MessageSend;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseStorage firebaseStorage;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_room);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        listView = (ListView) findViewById(R.id.messageListView);
        PhotoPickerButton = (ImageButton) findViewById(R.id.photoPickerButton);
        et_Message = (EditText) findViewById(R.id.messageEditText);
        btn_MessageSend = (Button) findViewById(R.id.sendButton);

        databaseReference = firebaseDatabase.getReference().child("Messages");
        storageReference = firebaseStorage.getReference().child("Chat_Photos");

        progressBar.setVisibility(ProgressBar.INVISIBLE);

        PhotoPickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                i.setType("image/*");
                i.putExtra(i.EXTRA_LOCAL_ONLY,true);
                startActivityForResult(i.createChooser(i,"Complete Action Using"),RC_PHOTO_PICKER);

            }
        });

        et_Message.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                if(charSequence.toString().trim().length() > 0){
                    btn_MessageSend.setEnabled(true);
                }else {
                    btn_MessageSend.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_Message.setFilters(new InputFilter[]{new InputFilter.LengthFilter(DEFAULT_MES_LENGTH_LIMIT)});

    }
}
