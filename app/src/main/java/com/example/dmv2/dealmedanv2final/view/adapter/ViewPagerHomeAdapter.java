package com.example.dmv2.dealmedanv2final.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dmv2.dealmedanv2final.view.fragment.DealItemFragment;
import com.example.dmv2.dealmedanv2final.view.fragment.DealProductFragment;
import com.example.dmv2.dealmedanv2final.view.fragment.TopupFragment;

import java.util.ArrayList;

/**
 * Created by CM on 6/2/2017.
 */

public class ViewPagerHomeAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> ArrFrag = new ArrayList<>();
        private ArrayList<String> title = new ArrayList<>();

        public ViewPagerHomeAdapter(FragmentManager fm) {
            super(fm);
            this.addFragment(new DealItemFragment(), "Voucher Makan");
            this.addFragment(new DealProductFragment(), "Voucher Product");
        }

        private void addFragment(Fragment fr, String st) {
            ArrFrag.add(fr);
            title.add(st);
        }

        @Override
        public Fragment getItem(int position) {
            return ArrFrag.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title.get(position);
        }

        @Override
        public int getCount() {
            return ArrFrag.size();
        }
}
