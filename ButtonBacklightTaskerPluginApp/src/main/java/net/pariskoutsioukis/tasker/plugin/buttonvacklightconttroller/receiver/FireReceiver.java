/*
 * android-toast-setting-plugin-for-locale <https://github.com/twofortyfouram/android-toast-setting-plugin-for-locale>
 * Copyright 2014 two forty four a.m. LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.receiver;

import net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.Base;
import net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.CapacityButtonbacklightControler;
import net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.R;
import net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.bundle.PluginBundleValues;
import com.twofortyfouram.locale.sdk.client.receiver.AbstractPluginSettingReceiver;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import static net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller.Base.*;

public final class FireReceiver extends AbstractPluginSettingReceiver {

    @Override
    protected boolean isBundleValid(@NonNull final Bundle bundle) {
        return PluginBundleValues.isBundleValid(bundle);
    }

    @Override
    protected boolean isAsync() {
        return false;
    }

    @Override
    protected void firePluginSetting(@NonNull final Context context, @NonNull final Bundle bundle) {

        try {


        //int backLight = Settings.System.getInt(context.getContentResolver(), "button_key_light");
// if it return -1 it means that light is on
// if it return 0 the light is off
// some time it will return values like 600(1.5 sec)
        // if you want to put the backLight as off u can do like this
            Boolean bbset=  PluginBundleValues.getBacklightButtonstate(bundle);

        //Settings.System.putInt(context.getApplicationContext().getContentResolver(), "button_key_light", 0);
       // Settings.System.putInt(context.getApplicationContext().getContentResolver(), "button_key_light", 1);
            CapacityButtonbacklightControler btnctrl = new CapacityButtonbacklightControler();
            btnctrl.EnableOrDisable(context,bbset);











    }
    catch (Exception ex)
    {
        Toast.makeText(context,ex.toString(),Toast.LENGTH_LONG).show();

            ErroHandling(ex);


    }
    }
}
