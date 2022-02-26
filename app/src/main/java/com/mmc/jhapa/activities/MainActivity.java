package com.mmc.jhapa.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.mmc.jhapa.R;
import com.mmc.jhapa.fragments.BlogFragment;
import com.mmc.jhapa.fragments.NoticeFragment;
import com.mmc.jhapa.fragments.TeamFragment;

public class MainActivity extends AppCompatActivity {

    NavigationBarView bottomNavigationView;
    Fragment fragment;
    Toolbar toolbar;
    DrawerLayout thisPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setBottomNavClickListener();
        initializeToolBar();
    }

    @Override
    public void onBackPressed() {
        if (thisPage.isOpen()){
            thisPage.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();

    }

    private void initializeToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setSubtitle(getString(R.string.college_address));
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thisPage.openDrawer(GravityCompat.START);
            }
        });
    }

    private void setBottomNavClickListener() {
        fragment = new BlogFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_holder,fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_navigation_blog:
                    fragment = new BlogFragment();
                    break;
                case R.id.bottom_navigation_notice:
                    fragment = new NoticeFragment();
                    break;
                case R.id.bottom_navigation_team:
                    fragment = new TeamFragment();
                    break;
                default:
                    Toast.makeText(MainActivity.this, "Woah, How did you do that?", Toast.LENGTH_SHORT).show();
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_holder,fragment).commit();
            return true;
        });
    }

    public void bindViews(){
        thisPage = findViewById(R.id.activity_main_drawer);
        toolbar = findViewById(R.id.main_toolbar);
        bottomNavigationView = findViewById(R.id.main_bottomnav);
    }
}