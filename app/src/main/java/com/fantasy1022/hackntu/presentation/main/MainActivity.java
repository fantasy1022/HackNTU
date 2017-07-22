package com.fantasy1022.hackntu.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.fantasy1022.hackntu.R;
import com.fantasy1022.hackntu.presentation.map.MapsFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();
    Fragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
    }

    private void initFragment() {
        mapFragment = new MapsFragment();
        setFragment(mapFragment, false);
    }

    private void setFragment(Fragment fragment, boolean isAddBackStack) {
        FragmentManager fragmentMgr = getSupportFragmentManager();
        FragmentTransaction fragmentTrans = fragmentMgr.beginTransaction();
        Log.d(TAG, "fragment.getClass().getName():" + fragment.getClass().getName());
        fragmentTrans.replace(R.id.content_layout, fragment, fragment.getClass().getName());//TODO: Check tag fragmentTrans
        if (isAddBackStack) {
            fragmentTrans.addToBackStack(null);
        }
        fragmentMgr.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Log.d(TAG, "onBackStackChanged");
            }
        });
        fragmentTrans.commit();
    }
}
