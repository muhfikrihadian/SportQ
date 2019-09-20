package com.muhfikrihadian.sportq.features.home.pages;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhfikrihadian.sportq.R;
import com.muhfikrihadian.sportq.adapter.BaseRecyclerAdapter;
import com.muhfikrihadian.sportq.adapter.MenuItemBean;
import com.muhfikrihadian.sportq.features.lapangan.lapanganfutsal.LapanganFutsal;
import com.muhfikrihadian.sportq.holder.MenuItemBindView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PageHome extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView menuView;
    private List<MenuItemBean> menuList;
    private BaseRecyclerAdapter menuAdapter;
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
    public PageHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page_home, container, false);
        ButterKnife.bind(this, view);
        carouselView = (CarouselView) view.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);
        setUp();
        return view;
    }

    private void setUp(){
        menuList = new ArrayList<>();
        menuList.add(new MenuItemBean(1, R.drawable.ic_futsal,"Futsal"));
        menuList.add(new MenuItemBean(2, R.drawable.ic_badminton, "Badminton"));
        menuList.add(new MenuItemBean(3, R.drawable.ic_basket, "Basket"));

        menuAdapter = new BaseRecyclerAdapter(menuList).onCreateVHolder(new MenuItemBindView());
        menuView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        menuView.setAdapter(menuAdapter);
        menuAdapter.setOnItemClicked(new BaseRecyclerAdapter.OnItemClickedListener() {
            @Override
            public void onItemClicked(View view, int i, boolean z, int i2) {
                if (menuList.get(i).getId() == 1) {
                    startActivity(new Intent(getActivity(), LapanganFutsal.class));
                } else if (menuList.get(i).getId() == 2) {
                    startActivity(new Intent(getActivity(), LapanganFutsal.class));
                } else if (menuList.get(i).getId() == 3) {
                    startActivity(new Intent(getActivity(), LapanganFutsal.class));
                }
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

}
