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
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class IEEECouncilPost extends AppCompatActivity {

    public static final String TAG = "false";

    EditText et_PostOfMember,et_NameOfMember,et_Year;
    Button btn_PostInfo,btn_Image;
    ImageView memberimage;

    public static final int PICK_IMAGE = 100;
    public static final int GALLERY_INTENT = 1;
    public static final int CAMERA_REQUEST_CODE = 2;

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
        storageReference = FirebaseStorage.getInstance().getReference() ;

        btn_PostInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IEEECouncil thismember = new IEEECouncil(et_PostOfMember.getText().toString(),et_NameOfMember.getText().toString(),et_Year.getText().toString());

                databaseReference.push().setValue(thismember);

                Toast.makeText(IEEECouncilPost.this, "Posting Member Info", Toast.LENGTH_SHORT).show();

                et_Year.setText("");
                et_NameOfMember.setText("");
                et_PostOfMember.setText("");


            }
        });

        btn_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_PICK);

                i.setType("image/*");

//                startActivityForResult(i,GALLERY_INTENT);
                startActivityForResult(i,CAMERA_REQUEST_CODE);


            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK){
//
//            progressDialog.setMessage("Uploading.....");
//            progressDialog.show();
//
//            Uri uri = data.getData();
//
//            StorageReference filePath = storageReference.child("Photos").child(uri.getLastPathSegment());
//
//            filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                @Override
//                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                    Toast.makeText(IEEECouncilPost.this, "File Uploaded Succesfully", Toast.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(IEEECouncilPost.this, "File Uploading Failed !!!", Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
        if( requestCode == CAMERA_REQUEST_CODE &&  requestCode == RESULT_OK){

            Uri uri = data.getData();
            Picasso.with(getApplicationContext()).load(uri).into(memberimage);
        }
    }
}
