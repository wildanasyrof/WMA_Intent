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
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

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

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview); //set untuk recycler view dalam xml/front end
        rvadapter = new rvAdapter(objAnime); //recyclerview adapter untuk object di atas
        recyclerView.setAdapter(rvadapter); //set adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext())); //set layout linear

        return view;
    }

    private void animelistadd() {
        objAnime.add(new animelist("Tesla Note", 2, 8.51, "Action", "Mission T adalah operasi intelijen yang bertugas untuk menyelamatkan dunia dari keruntuhan! Sang karakter utama adalah Negoro, yang dilatih sebagai ninja sejak muda dan dibesarkan sebagai agen intelijen terbaik. Negoro bekerjasama dengan agen inteligen dan membawa misi untuk takdir dunia. Tujuan misi ini untuk mengembalikan peninggalan dari pencipta jenius Nikola Tesla, “Shards of Tesla”. Dapatkah keduanya menyelesaikan misi mereka dengan melewati agen intelijen dari negara lain yang mengincar fragmen yang sama?"));
        objAnime.add(new animelist("Blue Period", 3, 8.05, "Action", "Siswa sekolah menengah tahun kedua, Yatora Yaguchi, bosan dengan kehidupan normalnya. Dia belajar dengan baik dan bermain-main dengan teman-temannya, tetapi sebenarnya, dia tidak menikmati salah satu dari aktivitas itu. Terikat oleh norma, dia diam-diam iri pada mereka yang melakukan sesuatu secara berbeda. Itu sampai dia menemukan kesenangan menggambar. Saat melihat lukisan yang dibuat oleh salah satu anggota Art Club, Yatora terpesona dengan warna-warna yang digunakan di dalamnya. Belakangan, dalam sebuah senam seni, ia mencoba menyampaikan bahasanya tanpa kata-kata melainkan melalui lukisan. Setelah pengalaman itu, Yatora mendapati dirinya begitu tertarik pada seni sehingga dia memutuskan bahwa itulah yang ingin dia lakukan untuk mencari nafkah. Tetapi ada banyak rintangan yang menghalangi jalannya: orang tuanya yang ragu-ragu atas pilihan uniknya, teman-temannya yang lebih berpengalaman, dan mempelajari suatu subjek jauh lebih dalam dari yang dia harapkan."));
        objAnime.add(new animelist("Shinka no Mi", 2, 8.31, "Adventure", "Seiichi Hiiragi adalah orang gemuk yang jelek, menjijikkan, kotor, dan bau\", ini adalah hinaan yang dilontarkan kepada Seiichi tentang penampilannya. Begitulah kehidupan sekolah Seiichi yang menyedihkan.Suatu hari, sebuah suara yang mengaku sebagai Dewa mengumumkan melalui sistem pengumuman untuk bersiap ditransfer ke dunia lain. Seluruh sekolah, termasuk Seiichi, dikirim ke dunia fantasi yang menggunakan elemen game seperti level, statistik, dan skill. Namun, Dewa masih memiliki persiapan yang harus diselesaikan untuk transfer, dan akan mengirim mereka segera setelah ritual pemanggilan pahlawan telah siap. Semua kelas membentuk kelompok untuk menunggu transfer tersebut, tetapi Seiichi sendirian, tidak masuk kedalam kelompok manapun, dan karena itu dia ditransfer ke area yang berbeda. Setelah ditransfer, hal pertama yang Seiichi makan adalah \"Buah Evolusi,\" yang akan mengubah hidupnya secara drastis...Ini adalah kisah Seiichi, seseorang yang dibully oleh teman-teman sekelasnya, diabaikan hingga sendirian, hingga ke kisah kerja kerasnya, sikap positif, dan dirinya yang bertahan di dunia baru ini."));
    }
}