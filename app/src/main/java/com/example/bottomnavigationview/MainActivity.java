package com.example.bottomnavigationview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.example.bottomnavigationview.pages.HomeFragment;
import com.example.bottomnavigationview.pages.NewsFragment;
import com.example.bottomnavigationview.pages.NotifFragment;
import com.example.bottomnavigationview.pages.ProfileFragment;


public class MainActivity extends AppCompatActivity {
    private  BottomNavigationView btNav;
    private FrameLayout body;

    private HomeFragment home;
    private NewsFragment news;
    private NotifFragment notif;
    private ProfileFragment profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        body = (FrameLayout) findViewById(R.id.body);
        btNav = (BottomNavigationView) findViewById(R.id.btnnavview);

        home = new HomeFragment();
        news = new NewsFragment();
        notif = new NotifFragment();
        profile = new ProfileFragment();

        setFragment(home);
        btNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.btnhome :
                        setFragment(home);
                        return true;
                    case R.id.btnnews :
                        setFragment(news);
                        return true;
                    case R.id.btnnotif :
                        setFragment(notif);
                        return true;
                    case R.id.btnprofile :
                        setFragment(profile);
                        return true;
                    default:
                        return false;
                }
            }
        });

    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.body, fragment);
        fragmentTransaction.commit();
    }
}
