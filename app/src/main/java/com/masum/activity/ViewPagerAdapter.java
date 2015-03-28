package com.masum.activity;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class ViewPagerAdapter extends PagerAdapter {
    // Declare Variables
    Context context;
    String[] country;
    LayoutInflater inflater;

    public ViewPagerAdapter(Context context, String[] country) {
        this.context = context;
        this.country = country;

    }

    @Override
    public int getCount() {
        return country.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return null;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

    @Override
    public CharSequence getPageTitle(int pos) {
        return MainActivity.resizingSpan(country[pos], pos);
    }

}
