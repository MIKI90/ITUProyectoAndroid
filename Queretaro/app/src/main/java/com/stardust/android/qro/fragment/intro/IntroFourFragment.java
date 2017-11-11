package com.stardust.android.qro.fragment.intro;

import android.content.Context;

import com.stardust.android.qro.R;
import com.stardust.android.qro.fragment.BaseFragment;

/*
 * Created by NOE on 06/11/2017.
 */

public class IntroFourFragment extends BaseFragment {

    @Override
    protected int fragmentLayoutResource() {
        return R.layout.fragment_intro_four;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getActivity();
    }
}
