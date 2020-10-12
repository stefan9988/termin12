package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Dao<Voce,Integer>VoceDao;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionSource connectionSource=null;
        try {
            connectionSource=new JdbcConnectionSource("jdbc:sqlite:primer.db");
            VoceDao= DaoManager.createDao(connectionSource,Voce.class);

            TableUtils.dropTable(connectionSource,Voce.class,true);
            TableUtils.createTable(connectionSource,Voce.class);

            Voce v1=new Voce("jabuka","crvena","jabuka.jpg");
            Voce v2=new Voce("limun","zut","limun.jpg");
            Voce v3=new Voce("jagoda","crvena","jagoda.jpg");
            VoceDao.create(v1);
            VoceDao.create(v2);
            VoceDao.create(v3);

            List<Voce>voces=VoceDao.queryForAll();
            LinearLayout layout=findViewById(R.id.ActFirst);
            for (final Voce voce:voces){
                Button button=new Button(this);
                button.setText(voce.getNaziv());
                button.setId(voce.getId());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this,SecundActivity.class);
                        intent.putExtra("id",voce.getId());
                        startActivity(intent);
                    }
                });
                layout.addView(button);
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            assert connectionSource != null;
            connectionSource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}