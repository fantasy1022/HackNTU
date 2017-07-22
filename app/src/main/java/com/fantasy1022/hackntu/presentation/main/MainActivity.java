package com.fantasy1022.hackntu.presentation.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.fantasy1022.hackntu.R;
import com.fantasy1022.hackntu.presentation.map.MapsFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public final String TAG = getClass().getSimpleName();
    MapsFragment mapFragment;

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            new MaterialDialog.Builder(this)
                    .title(R.string.choice_area)
                    .items(R.array.choice_area_item)
                    .itemsCallbackMultiChoice(mapFragment.getAreaItem(), new MaterialDialog.ListCallbackMultiChoice() {
                        @Override
                        public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                            /**
                             * If you use alwaysCallMultiChoiceCallback(), which is discussed below,
                             * returning false here won't allow the newly selected check box to actually be selected
                             * (or the newly unselected check box to be unchecked).
                             * See the limited multi choice dialog example in the sample project for details.
                             **/
                            //0:東, 1:西, 2:南, 3:北, 4:中
                            mapFragment.updateAreaChoice(which);
                            Log.d(TAG,"which:");
                            return true;
                        }
                    })
                    .positiveText(R.string.choice_positive)
                    .show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
