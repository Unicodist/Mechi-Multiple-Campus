package com.mmc.jhapa.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.mmc.jhapa.R;
import com.mmc.jhapa.fragments.*;

public class MainActivity extends AppCompatActivity {

    NavigationBarView bottomNavigationView;
    NavigationView sidebar;
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
        initializeSideBar();
        setSidebarMenuClickListener();
    }

    private void setSidebarMenuClickListener() {
        sidebar.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sidebar_menu_notes:
                        fragment = new ComingSoonFragment();
                        break;

                    case R.id.sidebar_menu_results:
                        fragment = new ComingSoonFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_holder,fragment).commit();

                thisPage.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (thisPage.isOpen()){
            thisPage.closeDrawer(GravityCompat.START);
            return;
        }
        if(bottomNavigationView.getSelectedItemId() != R.id.bottom_navigation_home)
        {
            bottomNavigationView.getMenu().getItem(0).setChecked(true);
            getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_holder,new HomeFragment()).commit();
            return;
        }
        super.onBackPressed();}

    private void initializeSideBar() {
        sidebar.inflateMenu(R.menu.sidebar_main_menu);
    }

    private void initializeToolBar() {
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);

        toolbar.setNavigationOnClickListener(view -> thisPage.openDrawer(GravityCompat.START));
    }

    private void setBottomNavClickListener() {
        fragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main_fragment_holder,fragment).commit();

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.bottom_navigation_home:
                    fragment = new HomeFragment();
                    break;
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
        sidebar = findViewById(R.id.navigationview_main);
        thisPage = findViewById(R.id.activity_main_drawer);
        toolbar = findViewById(R.id.main_toolbar);
        bottomNavigationView = findViewById(R.id.main_bottomnav);
    }
}