package com.example.ravneet.ieeedtu.MakingPosts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.Adapters.IEEECouncilAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class IEEECouncilPost extends AppCompatActivity {

    EditText et_PostOfMember,et_NameOfMember,et_Year;
    Button btn_PostInfo;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ChildEventListener childEventListener;

    IEEECouncilAdapter councilAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeecouncil_post);

        et_PostOfMember = (EditText) findViewById(R.id.et_postofMember);
        et_NameOfMember = (EditText) findViewById(R.id.et_nameofMember);
        et_Year = (EditText) findViewById(R.id.et_YearofMember);
        btn_PostInfo = (Button) findViewById(R.id.btn_PostMemberInfo);

//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference().child("IEEECouncil");



        btn_PostInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                IEEECouncil thismember = new IEEECouncil(et_PostOfMember.getText().toString(),et_NameOfMember.getText().toString(),et_Year.getText().toString());
//
//                databaseReference.push().setValue(thismember);

                Toast.makeText(IEEECouncilPost.this, "Posting Member Info", Toast.LENGTH_SHORT).show();

                et_Year.setText("");
                et_NameOfMember.setText("");
                et_PostOfMember.setText("");


            }
        });

        childEventListener = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                IEEECouncil currentMember =  dataSnapshot.getValue(IEEECouncil.class);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

//        databaseReference.addChildEventListener(childEventListener);


    }
}