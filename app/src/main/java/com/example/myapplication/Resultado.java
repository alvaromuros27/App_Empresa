package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Resultado extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

       // setSupportActionBar(toolbar);

        Fragment_list leadsFragment = (Fragment_list)
                getSupportFragmentManager().findFragmentById(R.id.resultado2);

        if (leadsFragment == null) {
            leadsFragment = Fragment_list.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.resultado2, leadsFragment)
                    .commit();
        }

    }


    /* ListView superListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        Bundle datos = getIntent().getExtras();
        superListView = findViewById(R.id.superListView);

        getSuperHeroes();
    }
    private void getSuperHeroes() {
        Call<List<Resultados>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Resultados>>() {
            @Override
            public void onResponse(Call<List<Resultados>> call, Response<List<Resultados>> response) {
                List<Resultados> myheroList = response.body();
                String[] name = new String[myheroList.size()];
                String[] realname1 = new String[myheroList.size()];

                for (int i = 0; i < myheroList.size(); i++) {
                    name[i] = myheroList.get(i).getName();
                    realname1[i] = myheroList.get(i).getRealName();
                }

               // superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, nombre));
                //superListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_2, realname));
            }

            @Override
            public void onFailure(Call<List<Resultados>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }*/
}