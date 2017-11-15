package com.stardust.android.qro.activity.intro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;

import com.rd.PageIndicatorView;
import com.stardust.android.qro.R;
import com.stardust.android.qro.activity.BaseActivity;
import com.stardust.android.qro.activity.MainActivity;
import com.stardust.android.qro.fragment.intro.IntroFourFragment;
import com.stardust.android.qro.fragment.intro.IntroOneFragment;
import com.stardust.android.qro.fragment.intro.IntroThreeFragment;
import com.stardust.android.qro.fragment.intro.IntroTwoFragment;
import com.stardust.android.qro.preferences.Preferences;
import com.stardust.android.widget.ViewPagerIndicator;

import butterknife.BindView;

public class IntroActivity extends BaseActivity implements IntroPresenter.View {

    @BindView(R.id.indicator)
    PageIndicatorView indicator;
    @BindView(R.id.pager)
    ViewPager pager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().getDecorView().setSystemUiVisibility(256 | 1024);
        }
        if (Preferences.getInstance(this).getLoggedUser()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        setContentView(R.layout.activity_intro);

        HomePageAdapter adapter = new HomePageAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

    }

    private void initPager() {
        final ViewPager.LayoutParams layoutParams = new ViewPager.LayoutParams();
        layoutParams.width = LayoutParams.MATCH_PARENT;
        layoutParams.height = LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.BOTTOM;

        final ViewPagerIndicator viewPagerIndicator = new ViewPagerIndicator(this);
        pager.addView(viewPagerIndicator, layoutParams);
    }

    private class HomePageAdapter extends FragmentPagerAdapter {
        HomePageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new IntroOneFragment();
                case 1:
                    return new IntroTwoFragment();
                case 2:
                    return new IntroThreeFragment();
                case 3:
                    return new IntroFourFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
