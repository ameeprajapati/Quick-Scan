package com.example.admin.quickscan.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.quickscan.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    private ViewPager mViewPager;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mViewPager = (ViewPager) view.findViewById(R.id.pager);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);


    }

    public static class ViewPagerFragment extends Fragment {

        private int resourceId;

        public ViewPagerFragment() {
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                resourceId = getArguments().getInt("resourceId");
            }
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.pager_item, null);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setImageResource(resourceId);

        }
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private int[] mResources = {
                R.drawable.dash1,
                R.drawable.dash3,
                R.drawable.dash2
        };

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("resourceId", mResources[position]);
            viewPagerFragment.setArguments(bundle);
            return viewPagerFragment;
        }

        @Override
        public int getCount() {
            return mResources.length;
        }
    }
}


