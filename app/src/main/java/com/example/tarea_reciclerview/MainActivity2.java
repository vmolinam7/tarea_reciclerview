package com.example.tarea_reciclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

import Adaptadores.AdatarImg;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView rImages;
    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int resId = R.anim.layout_animation_down_to_up;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getApplicationContext(), resId);
        txtTitulo=findViewById(R.id.txtVista);
        rImages=findViewById(R.id.rImages);
        rImages.setLayoutManager(new GridLayoutManager(this,2));
        Bundle bl=this.getIntent().getExtras();
        String[] images=getIntent().getStringArrayExtra("images");
        rImages.setLayoutAnimation(animation);
        txtTitulo.setText(bl.getString("title"));
        AdatarImg imgAdapter=new AdatarImg(this, images);
        rImages.setAdapter(imgAdapter);

    }
}