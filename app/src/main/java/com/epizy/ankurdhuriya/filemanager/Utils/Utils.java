package com.epizy.ankurdhuriya.filemanager.Utils;

import android.content.res.Resources;

/*
 * Created by ankur on 23/06/18.
 */

public class Utils {

    private Utils() {
    }

    public static float dp2px(Resources resources, float dp) {
        final float scale = resources.getDisplayMetrics().density;
        return  dp * scale + 0.5f;
    }

    public static float sp2px(Resources resources, float sp){
        final float scale = resources.getDisplayMetrics().scaledDensity;
        return sp * scale;
    }
}
