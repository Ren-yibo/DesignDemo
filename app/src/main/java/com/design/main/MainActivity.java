package com.design.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.design.R;
import com.design.mvp.SlideToolBarActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mBarTogglr;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initToolBar();
        initnavigation();
        initViewPager();
        initFloatingBar();

    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("This is Title");
        toolbar.setSubtitle("This is SubTitle");
        toolbar.setLogo(android.R.drawable.ic_menu_myplaces);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(android.R.drawable.arrow_down_float);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if (item.getItemId() == R.id.action_share) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
//                    builder.setTitle("Dialog");
//                    builder.setMessage("This is Share Dialog");
//                    builder.setPositiveButton("OK", null);
//                    builder.setNegativeButton("Cancel", null);
//                    builder.show();
//                }
//                return false;
//            }
//        });
    }

    private void initnavigation() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mBarTogglr = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        mBarTogglr.syncState();
        drawerLayout.setDrawerListener(mBarTogglr);

        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        startActivity(new Intent(MainActivity.this, SwipeRefreshActivity.class));
                        break;
                    default:
                        break;
                }

                return true;
            }
        });
    }

    private void initViewPager() {
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        final List<String> mList = new ArrayList<>();
        mList.add("NORMAL");
        mList.add("SPECIAL");
        mList.add("DEFAULT");
        for (int i = 0; i < mList.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mList.get(i)));
        }
        final List<Fragment> mFragments = new ArrayList<>();
        for (int i = 0; i < mList.size(); i++) {
            mFragments.add(new TabFragment("Fragment " + mList.get(i)));
        }
        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mList.get(position);
            }
        };
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(mAdapter);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(mAdapter);
    }

    private void initFloatingBar() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(new Intent(MainActivity.this, SlideToolBarActivity.class));
                            }
                        }).show();
            }
        });
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
            Toast.makeText(MainActivity.this, "Setting ", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_share) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Dialog");
            builder.setMessage("This is Share Dialog");
            builder.setPositiveButton("OK", null);
            builder.setNegativeButton("Cancel", null);
            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
