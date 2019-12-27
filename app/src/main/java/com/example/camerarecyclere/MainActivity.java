package com.example.camerarecyclere;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IPickResult {

    RecyclerView recyclerView;
    Button  btn;
    Adapter adapter;


    List<Model> images = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn=findViewById(R.id.btn);
        recyclerView=findViewById(R.id.recyclerview);
        //imageView
        btn .setOnClickListener(v -> chooseCar());
    }


    private void chooseCar() {
        PickSetup setup = new PickSetup()
                .setTitle("تصوير جديد")
                .setProgressText("درحال ارسال...")
                .setSystemDialog(true);
        PickImageDialog.build(setup).show(this);
    }


    @Override
    public void onPickResult(PickResult r) {
        if (r.getError() == null) {

            // to set image in recycler
            images.add(new Model(r.getBitmap()));


            adapter=new Adapter(images,MainActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();



//            img.setImageBitmap(r.getBitmap());
//            bm = r.getBitmap();
        } else
            Toast.makeText(MainActivity.this, r.getError().getMessage(), Toast.LENGTH_LONG).show();
    }



}

