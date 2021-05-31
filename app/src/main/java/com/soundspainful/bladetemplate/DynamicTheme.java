package com.soundspainful.bladetemplate;

import com.vuzix.hud.resources.DynamicThemeApplication;

public class DynamicTheme extends DynamicThemeApplication {

    @Override
    protected int getNormalThemeResId() {
        return R.style.AppTheme;
    }

    @Override
    protected int getLightThemeResId() {
        return R.style.AppTheme_Light;
    }

}
