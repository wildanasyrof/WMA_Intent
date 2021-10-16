package com.my.navigasiapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link browse#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class browse extends Fragment {

    RecyclerView recyclerView;
    rvAdapter rvadapter;
    ArrayList<animelist> objAnime = new ArrayList<>();
    String[] keyword;
    Spinner spinner;
    AutoCompleteTextView autoCompleteTextView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment browse.
     */
    // TODO: Rename and change types and number of parameters
    public static browse newInstance(String param1, String param2) {
        browse fragment = new browse();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public browse() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        animelistadd(); //memanggil fungsi anime list
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_browse, container, false);

        //AutoComplete Setting
        autoCompleteTextView = view.findViewById(R.id.search); //set untuk item edittext front end
        ArrayAdapter<String> adapterSearch = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, keyword); //adapter autocomplete dan call dari string keyword
        autoCompleteTextView.setAdapter(adapterSearch); //set adapter

        spinner = view.findViewById(R.id.genre); //set item spinner front end
        ArrayAdapter<CharSequence> spAdapter  =ArrayAdapter.createFromResource(getContext(), R.array.genre, android.R.layout.simple_spinner_item); //create adapter spinner
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item); //set view spinner/model
        spinner.setAdapter(spAdapter); //set adapter
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //set item yang dipilih dan memanggil toast
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    String spitem = adapterView.getItemAtPosition(i).toString(); //mengambil item di posisi
                    Toast.makeText(getContext(), "Gagal memuat genre " + spitem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //Recycler View Setting
        recyclerView = view.findViewById(R.id.recyclerview); //set untuk recycler view dalam xml/front end
        rvadapter = new rvAdapter(objAnime); //recyclerview adapter untuk object di atas
        recyclerView.setAdapter(rvadapter); //set adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext())); //set layout linear

        return view;

    }

    //fungsi anime list seabagi tempat obj
    private void animelistadd() {
        keyword = new String[]{"Tokyo Ghoul", "Re Zero", "Boku No Hero", "Attack on Titan", "Dororo", "Tensura", "Danmachi", "Naruto", "Akame ga Kill", "Attack on Titan s2"};

        objAnime.add(new animelist("Attack On Titan S1", 25, 8.51, "Action", "Anime Attack on Titan bercerita tentang umat manusia yang dibantai sejak berabad-abad yang lalu hingga hampir punah oleh makhluk mengerikan menyerupai manusia yang disebut Titan. Hal ini memaksa manusia untuk bersembunyi dan diam dalam ketakutan di balik tembok konsentris yang sangat tinggi dan besar."));
        objAnime.add(new animelist("Black Clover", 170, 8.05, "Action", "Black Clover bercerita tentang 2 anak yatim piatu bernama Asta dan Yuno. Mereka dibesarkan bersama di gereja yang sama dan sejak itu tak terpisahkan. Sebagai anak-anak, mereka berjanji akan saling bersaing untuk melihat siapa yang akan menjadi Kaisar Magus berikutnya."));
        objAnime.add(new animelist("Dr. Stone", 24, 8.31, "Adventure", "3700 tahun setelah kilatan cahaya hijau misterius mengubah umat manusia menjadi batu, seorang remaja jenius bernama Senku Ishigami bangkit dan menemukan dirinya di dunia tempat di mana semua jejak peradaban manusia telah terkikis oleh waktu. Senku yang menyadari bahwa dirinya dibangkitkan dengan asam nitrat, menghidupkan kembali temannya yang bernama Taiju Oki dan teman sekelas mereka Yuzuriha Ogawa untuk membangun kembali peradaban mereka."));
        objAnime.add(new animelist("Tokyo Ghoul", 13, 7.8, "Horror", "okyo Ghoul yang bercerita tentang makhluk aneh yang memakan manusia, mereka disebut “Ghoul”. Seorang mahasiswa, Kaneki Ken, menjalani kehidupan normal dan telah jatuh cinta dengan seorang gadis. Tapi, setelah kencan pertama mereka ternyata gadis itu adalah seorang Ghoul. dia pun benar-benar trauma, dan entah bagaimana dia bisa selamat dari Ghoul yang tiba-tiba mati dengan sendirinya. Apa yang akan terjadi saat para dokter menanamkan beberapa organ padanya, agar dia bisa bertahan hidup?"));
    }

}