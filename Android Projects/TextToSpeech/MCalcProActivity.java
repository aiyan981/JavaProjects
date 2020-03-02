package ca.yorku.eecs.mcalcpro;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import ca.roumani.i2c.MPro;

public class MCalcPro_Activity extends AppCompatActivity implements TextToSpeech.OnInitListener
{
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mcalcpro_layout);

        this.tts = new TextToSpeech(this,this);
    }
    @Override
    public void onInit(int status)
    {
        this.tts.setLanguage(Locale.US);
    }

    public void buttonClicked(View v){
        EditText pView = (EditText)findViewById(R.id.pBox);
        String principal = pView.getText().toString();

        EditText aView = (EditText) findViewById(R.id.aBox);
        String amort = aView.getText().toString();

        EditText iView = (EditText) findViewById(R.id.aBox);
        String interest = iView.getText().toString();

        try{
            MPro mp = new MPro();
            mp.setPrinciple(principal);
            mp.setAmortization(amort);
            mp.setInterest(interest);

            String s = "Monthly Payment = " + mp.computePayment("%,.2f");
            s += "\n\n";
            s += "By making this payment monthly for " + amort + " years, the mortgage will be " +
                    "paid in full. But if you terminate the mortgage on its nth anniversary, the balance" +
                    "still owing depends on n as shown below:";

            s += "\n\n";
            s += String.format("%8d", 0) + mp.outstandingAfter(0, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 1) + mp.outstandingAfter(1, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 2) + mp.outstandingAfter(2, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 3) + mp.outstandingAfter(3, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 4) + mp.outstandingAfter(4, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 5) + mp.outstandingAfter(5, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 10) + mp.outstandingAfter(10, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 15) + mp.outstandingAfter(15, "%,16.0f");
            s += "\n\n";

            s += String.format("%8d", 20) + mp.outstandingAfter(20, "%,16.0f");
            s += "\n\n";

            ((TextView) findViewById(R.id.output)).setText(s);
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null);

        }

        catch (Exception e){
            // display e.getMessage()
            Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            label.show();
        }


    }



}
