package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_list#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_list extends Fragment {
    private ListView mLeadsList;
    private ListAdapter mLeadsAdapter;
    private HashMap<String, Resultados> heroes = new HashMap<>();

    public Fragment_list() {
        // Required empty public constructor
    }

    public static Fragment_list newInstance() {
        Fragment_list fragment = new Fragment_list();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSuperHeroes();
    }

    private void getSuperHeroes(){
        Call<List<Resultados>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();
        call.enqueue(new Callback<List<Resultados>>() {
            @Override
            public void onResponse(Call<List<Resultados>> call, Response<List<Resultados>> response) {
                List<Resultados> myheroList = response.body();

                for (Resultados r : myheroList) {
                    r.setId();
                    heroes.put(r.getId(), r);
                }

                // Inicializar el adaptador con la fuente de datos.
                mLeadsAdapter = new ListAdapter(getActivity(),
                        new ArrayList<>(heroes.values())
                );

                //Relacionando la lista con el adaptador
                mLeadsList.setAdapter(mLeadsAdapter);

            }

            @Override
            public void onFailure(Call<List<Resultados>> call, Throwable t) {
                System.out.println("An error has occurred");
            }

        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_list, container, false);

        // Instancia del ListView.
        mLeadsList = (ListView) root.findViewById(R.id.leads_list);

        // Inicializar el adaptador con la fuente de datos.
        mLeadsList = (ListView) root.findViewById(R.id.leads_list);

        //Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);
        // Inflate the layout for this fragment
        return root;
    }
}