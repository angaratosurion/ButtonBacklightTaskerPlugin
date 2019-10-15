package net.pariskoutsioukis.core;

import android.Manifest;
import android.app.Activity;
import com.vistrav.ask.Ask;

public class PermisionMngr {

    public static  void Request(Activity act )
    {
        try
        {
            Boolean ap =false;
            if (act!=null) {

                /* <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission-sdk-23 android:name="android.permission.WRITE_SETTINGS"/>*/
                Ask.on(act)
                        .forPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_SETTINGS)
                        .go();



                ap=true;

            }





            // return ap;

        }
        catch (Exception ex)
        {
             net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.Base.ErroHandling(ex);
            //return  false;
        }
    }
}
