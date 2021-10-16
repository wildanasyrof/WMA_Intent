package com.my.navigasiapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link history#newInstance} factory method to
 * create an instance of this fragment.
 */
public class history extends Fragment {

    RecyclerView recyclerView;
    rvAdapter rvadapter;
    ArrayList<animelist> objAnime = new ArrayList<>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public history() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment history.
     */
    // TODO: Rename and change types and number of parameters
    public static history newInstance(String param1, String param2) {
        history fragment = new history();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        animelistadd(); //memanggil fungsi
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_history, container, false);

        recyclerView = view.findViewById(R.id.recyclerview); //set untuk recycler view dalam xml/front end
        rvadapter = new rvAdapter(objAnime); //recyclerview adapter untuk object di atas
        recyclerView.setAdapter(rvadapter); //set adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext())); //set layout linear

        return view;
    }

    private void animelistadd() {
        objAnime.add(new animelist("Tesla Note", 2, 8.51, "Action", "Mission T adalah operasi intelijen yang bertugas untuk menyelamatkan dunia dari keruntuhan! Sang karakter utama adalah Negoro, yang dilatih sebagai ninja sejak muda dan dibesarkan sebagai agen intelijen terbaik. Negoro bekerjasama dengan agen inteligen dan membawa misi untuk takdir dunia. Tujuan misi ini untuk mengembalikan peninggalan dari pencipta jenius Nikola Tesla, “Shards of Tesla”. Dapatkah keduanya menyelesaikan misi mereka dengan melewati agen intelijen dari negara lain yang mengincar fragmen yang sama?"));
     }
}