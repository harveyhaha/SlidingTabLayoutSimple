package com.harveyhaha;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.harveyhaha.widget.SlidingTabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private SlidingTabLayout slidingTabLayout;
    private String[] titles = {"全部微博", "互相关注", "朋友圈"};
    private boolean distributeEvenly = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        initSlidingTabLayout();
        //

    }

    private void initSlidingTabLayout() {
        pager = (ViewPager) findViewById(R.id.pager);
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidingTabs);
        slidingTabLayout.setCustomTabView(R.layout.comm_lay_tab_indicator, android.R.id.text1);
        pager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));
        slidingTabLayout.setDistributeEvenly(distributeEvenly);

        slidingTabLayout.setViewPager(pager);
        slidingTabLayout.setSelectedIndicatorColors(Color.parseColor("#ffffffff"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.distributeEvenly) {
            distributeEvenly =true;
            initSlidingTabLayout();
            return true;
        }
        if (id == R.id.noDistributeEvenly) {
            distributeEvenly =false;
            initSlidingTabLayout();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final int totalPaginas = 3;
        private String[] titulos;

        public ViewPagerAdapter(FragmentManager fm, String[] titulos) {
            super(fm);
            this.titulos = titulos;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment tab = TabFragment.getInstance(titles[position]);

            return tab;
        }

        public CharSequence getPageTitle(int position) {
            return titulos[position];
        }

        @Override
        public int getCount() {
            return totalPaginas;
        }
    }
}
