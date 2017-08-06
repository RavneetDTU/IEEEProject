package com.example.ravneet.ieeedtu.MakingPosts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ravneet.ieeedtu.Adapters.IEEECouncilAdapter;
import com.example.ravneet.ieeedtu.R;
import com.example.ravneet.ieeedtu.infrasturcture.IEEECouncil;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IEEECouncilPost extends AppCompatActivity {

    public static final String TAG = "false";

    EditText et_PostOfMember,et_NameOfMember,et_Year;
    Button btn_PostInfo,btn_Image;
    ImageView memberimage;

    Uri downloadURL;

    public static final int PICK_IMAGE = 100;

    private ProgressDialog progressDialog;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ieeecouncil_post);

        et_PostOfMember = (EditText) findViewById(R.id.et_postofMember);
        et_NameOfMember = (EditText) findViewById(R.id.et_nameofMember);
        et_Year = (EditText) findViewById(R.id.et_YearofMember);
        btn_PostInfo = (Button) findViewById(R.id.btn_PostMemberInfo);
        btn_Image = (Button) findViewById(R.id.btn_IEEEMemberImage);
        memberimage = (ImageView) findViewById(R.id.iv_memberImage);

        progressDialog = new ProgressDialog(this);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("IEEECouncil");
        storageReference = FirebaseStorage.getInstance().getReference();
        btn_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                i.setType("image/*");
                i.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(i,"Select Picture Using"),PICK_IMAGE);


            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && data != null && data.getData() != null){
            if(requestCode == PICK_IMAGE) {
                Uri uri = data.getData();
                Picasso.with(getApplicationContext()).load(uri).into((ImageView)findViewById(R.id.iv_memberImage));

                progressDialog.setMessage("Uploading....");
                progressDialog.show();

                StorageReference filepath = storageReference.child("IEEEPic").child(uri.getLastPathSegment());

                filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        progressDialog.dismiss();
                        //noinspection VisibleForTests
                        downloadURL = taskSnapshot.getDownloadUrl();
                        btn_PostInfo.setOnClickListener( new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                IEEECouncil thismember = new IEEECouncil(et_PostOfMember.getText().toString(),et_NameOfMember.getText().toString(),et_Year.getText().toString(),downloadURL.toString());

                                databaseReference.push().setValue(thismember);

                                Toast.makeText(IEEECouncilPost.this, "Posting Member Info", Toast.LENGTH_SHORT).show();

                                et_Year.setText("");
                                et_NameOfMember.setText("");
                                et_PostOfMember.setText("");

                            }
                        });

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(IEEECouncilPost.this, "Image Uploading Failed", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                });
            }
        }
    }

}
