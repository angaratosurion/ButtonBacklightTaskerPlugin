package net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.Base.ErroHandling;

/**
 * Created by angarato surion on 30/10/2017.
 */

public class CapacityButtonbacklightControler
{
    //final String ErrorMsg="can't create /sys/class/leds/button-backlight/brightness: No such file or directory";
    final String ErrorMsg="No such file or directory";


    public void EnableOrDisable(Context context, Boolean bbset)
    {
        try
        {
            if (context != null)
            {
                Runtime r = Runtime.getRuntime();
                java.lang.Process p = r.exec("su");
                String cmd;
                if (bbset == true) {
                    cmd = "echo 1 > /sys/class/leds/button-backlight/brightness";
                    //  Settings.System.putInt(context.getApplicationContext().getContentResolver(), "button_key_light", 1);

                } else {

                    cmd = "#!/bin/bash\necho 0 >sys/class/leds/button-backlight/brightness";

                }
                p.getOutputStream().write(cmd.getBytes());
                if (this.CheckifRunnedSuccesfully(context, p) == false) {
                    if (bbset == true) {
                        cmd = "settings put system button_key_light -1";
                    } else {
                        cmd = "settings put system button_key_light 0";
                    }
                    p.getOutputStream().write(cmd.getBytes());
                    if (this.CheckifRunnedSuccesfully(context, p) == false) {

                        Toast.makeText(context, R.string.UnsupportedRomOrDevice, Toast.LENGTH_LONG).show();
                    }
                }

            }
        }
        catch (Exception ex)
            {
            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
            try {
                ErroHandling(ex);
            } catch (IOException e) {
                //
            }

        }
    }

    public   Boolean CheckifRunnedSuccesfully(Context context,Process p)
        {
        try {
            Boolean ap = false;

            if (context != null && p != null) {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(p.getInputStream()));
                int read;
                char[] buffer = new char[4096];
                StringBuffer output = new StringBuffer();
                while ((read = reader.read(buffer)) > 0) {
                    output.append(buffer, 0, read);
                }
                if (output.toString().contains(ErrorMsg) == true)
                {
                    ap = true;
                }
            }


            return ap;
        }
         catch (Exception ex)
            {
            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
            try {
                ErroHandling(ex);
            } catch (IOException e) {
                //
            }
            return false;

        }
    }
}
