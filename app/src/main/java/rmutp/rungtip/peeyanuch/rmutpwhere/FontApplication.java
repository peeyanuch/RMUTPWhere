package rmutp.rungtip.peeyanuch.rmutpwhere;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by WINDOWS on 19/3/2560.
 */

public class FontApplication extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        initFont();

    }
    private  void initFont(){
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("font/bangna-new.ttf")
        .setFontAttrId(R.attr.fontPath)
        .build()
        );
    }
}
