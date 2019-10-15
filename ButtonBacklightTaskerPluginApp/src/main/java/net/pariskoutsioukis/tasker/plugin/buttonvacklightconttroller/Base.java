package net.pariskoutsioukis.tasker.plugin.buttonvacklightconttroller;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by angarato surion on 22/6/2017.
 */

public class Base {
    public static void ErroHandling(Exception ex) {//throws IOException {

        File f = new File(Environment.getExternalStorageDirectory()+"/ButtonBacklightTaskerPugin/Logs");
        File ef =new  File(Environment.getExternalStorageDirectory()+"/ButtonBacklightTaskerPugin/Logs/error.txt");
        Date date =new Date();

        if ( !f.exists())
        {
            f.mkdir();
        }
        if ( ef.exists())
        {
            try {
                BufferedReader br = new BufferedReader(new FileReader(ef));
                String line,in="",out="";

                while ((line = br.readLine()) != null) {
                    in+=line+'\n';
                    // text.append('\n');
                }
                br.close();
                //BufferedWriter bw = new BufferedWriter(new FileWriter(ef));
                out=in+"\n"+date.toString()+"\n"+ex.toString()+" : "+ex.fillInStackTrace().toString() +"\n";
                PrintWriter wr = new PrintWriter(ef)  ;
                wr.append( out);
                ex.printStackTrace(wr);
                wr.flush();;
                wr.close();

                //  bw.write(out);
                //    bw.close();


            }
            catch (IOException n)
            {
                // ef.createNewFile();
            }



        }
        else {
            try {
                ef.createNewFile();
                String out="";


                PrintWriter wr = new PrintWriter(ef)  ;
                wr.append( "\n"+date.toString()+"\n"+ex.toString()+" : "+ex.fillInStackTrace().toString() +"\n");
                ex.printStackTrace(wr);
                wr.flush();;
                wr.close();


            }
            catch (IOException n)
            {
                // ef.createNewFile();
            }

        }


    }

}
