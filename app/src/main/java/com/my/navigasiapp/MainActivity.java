package com.my.navigasiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNav = findViewById(R.id.bot_nav); //set item ke front end

        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new Home()).commit(); //container mereplace fragment ke fragment home

        botNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()){ //switch case untuk pemilihan item menu, get item by id dari menu
                    case R.id.nav_home:
                        selectedFragment = new Home();
                        break;
                    case R.id.nav_browse:
                        selectedFragment = new browse();
                        break;
                    case R.id.nav_history:
                        selectedFragment = new history();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment).commit(); //set fragment ke item menu yang dipilih

                return true;
            }
        });
    }
}