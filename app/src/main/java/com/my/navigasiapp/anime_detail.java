package com.my.navigasiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class anime_detail extends AppCompatActivity {

    TextView txtJudul, txtEpisode, txtRating, txtGenre, txtDeskripsi;
    String[] episode;
    ListView listViewEpisode;
    ImageButton wa, ig, tele;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        Intent intent = getIntent();

        //set item pada front end

        txtJudul = findViewById(R.id.dtljudul);
        txtEpisode = findViewById(R.id.dtlepisode);
        txtRating = findViewById(R.id.dtlrating);
        txtGenre = findViewById(R.id.dtlgenre);
        txtDeskripsi = findViewById(R.id.dtldeskripsi);
        wa = findViewById(R.id.btnwa);
        ig = findViewById(R.id.btnig);
        tele = findViewById(R.id.btntele);

        //call value dari class anime list sesuai kodenya dan fungsinya
        animelist anime = intent.getParcelableExtra("ANIME");
        txtJudul.setText(anime.getJudul());
        txtEpisode.setText(String.valueOf(anime.getEps())); //tostring karena integer
        txtRating.setText(String.valueOf(anime.getRating())); //tostring karena double
        txtGenre.setText(anime.getGenre());
        txtDeskripsi.setText(anime.getDeskripsi());

        //mengisi string[] episode sesuai value episode dalam array linklist
        int x = anime.getEps();
        episode = new String[x];
        for(int i = 0; i < x; i++){
            int arrItem = x - i;
            episode[i] = ("Episode " +String.valueOf(arrItem));

        }

        //list view adapter
        listViewEpisode = findViewById(R.id.lvEpisode);
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, episode); //create new adapter, dengan string episode yang dibuat otomatis sesuai value
        listViewEpisode.setAdapter(lvAdapter); //set adapter

        listViewEpisode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String episode = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Gagal memuat " + episode, Toast.LENGTH_SHORT).show();

            }
        });

        //intent implicit
        wa.setOnClickListener(new View.OnClickListener() { //button on click
            @Override
            public void onClick(View view) {
                String urlig = "https://wa.me/6285398334647"; //url send message to wa
                Intent intentig = new Intent(Intent.ACTION_VIEW, Uri.parse(urlig)); //set intent action  ke url wa
                startActivity(intentig); //start activity intent
            }
        });

        ig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlig = "https://www.instagram.com/thisiswasyrof/";
                Intent intentig = new Intent(Intent.ACTION_VIEW, Uri.parse(urlig));
                startActivity(intentig);
            }
        });

        tele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String urlig = "https://t.me/wildan_asyrof";
                Intent intentig = new Intent(Intent.ACTION_VIEW, Uri.parse(urlig));
                startActivity(intentig);
            }
        });

    }
}