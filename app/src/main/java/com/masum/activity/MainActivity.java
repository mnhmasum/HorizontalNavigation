package com.masum.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerTitleStrip;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;
//
public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    String[] country;
    private PagerAdapter adapter;
    private static ViewPager viewPager;
    private Button btnPrevious, btnNext;
    public int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
        setListener();

    }

    private void initView() {
        btnNext = (Button) findViewById(R.id.btnNext);
        btnPrevious = (Button) findViewById(R.id.btnPrevious);

        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip)findViewById(R.id.titlestrip);
        pagerTitleStrip.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        pagerTitleStrip.setTextColor(Color.WHITE);

        viewPager = (ViewPager) findViewById(R.id.pager);

    }

    public void setListener() {
        btnNext.setOnClickListener(this);
        btnPrevious.setOnClickListener(this);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected( int i) {
                currentPosition = i;
                Toast.makeText(getApplicationContext(),"Selected position " + currentPosition, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }

        });

    }

    public void loadData() {
        country = new String[] { "Dhaka", "Khulna", "Barishal", "Comilla", "Chittagong", "Rangpur", "Dinajpur"};
        adapter = new ViewPagerAdapter(MainActivity.this, country);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnPrevious:
                int i = viewPager.getCurrentItem();
                if (i > 0) {
                    viewPager.setCurrentItem(i - 1);
                }

                break;
            case R.id.btnNext:
                int j = viewPager.getCurrentItem();
                if (country.length > j) {
                    viewPager.setCurrentItem(j + 1);
                }
                break;
        }
    }

    public static CharSequence resizingSpan(CharSequence source, int pos) {
        //Set smaller all unselected item
        if (viewPager.getCurrentItem() != pos) {
            return source;
        }

        //set bigger selected item
        final SpannableString spannableString = new SpannableString(source);
        spannableString.setSpan(new RelativeSizeSpan(1.4f), 0, source.length(), 0);
        return spannableString;
    }
}
