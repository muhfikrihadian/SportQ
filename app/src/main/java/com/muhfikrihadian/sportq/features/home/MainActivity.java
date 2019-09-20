package com.muhfikrihadian.sportq.features.home;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.adapter.ViewPagerAdapter;
import com.muhfikrihadian.sportq.features.home.pages.PageAccount;
import com.muhfikrihadian.sportq.features.home.pages.PageHome;
import com.muhfikrihadian.sportq.features.home.pages.PageMessages;
import com.muhfikrihadian.sportq.features.home.pages.PageNotification;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ViewPager.OnAdapterChangeListener {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;
    private ViewPagerAdapter pagerAdapter;
    private Fragment fragment;
    private FragmentManager fragmentManager;
    private int posisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUp();
    }

    private void setUp() {
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new PageHome(), getString(R.string.nav_home));
        pagerAdapter.addFragment(new PageMessages(), getString(R.string.nav_messages));
        pagerAdapter.addFragment(new PageNotification(), getString(R.string.nav_notification));
        pagerAdapter.addFragment(new PageAccount(), getString(R.string.nav_profile));

        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(pagerAdapter.getCount());
        viewPager.addOnAdapterChangeListener(this);
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

    }



    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0, false);
                    return true;
                case R.id.navigation_pesan:
                    viewPager.setCurrentItem(1, false);
                    return true;
                case R.id.navigation_notif:
                    viewPager.setCurrentItem(2, false);
                    return true;
                case R.id.navigation_akun:
                    viewPager.setCurrentItem(3, false);
                    return true;

                default:
                    return false;
            }
        }
    };

    private void setSelectedMenuItem(int num) {
        getSupportActionBar().setTitle(pagerAdapter.getPageTitle(num));
        //navigation.setSelectedItemId(navigation.getMenu().getItem(num).getItemId());
    }

    @Override
    public void onBackPressed() {
        if (posisi == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(0, false);
            navigation.setSelectedItemId(navigation.getMenu().getItem(0).getItemId());
            setSelectedMenuItem(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        posisi = position;
        setSelectedMenuItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
