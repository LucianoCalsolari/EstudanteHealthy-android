package br.com.estudantehealthy;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag1 extends Fragment implements Runnable {

    private static Chronometer minutes_for_next_drink;
    private ProgressBar progressDrunk;
    private Button buttonDrinksABit;
    private Handler handler = new Handler();
    private static TextView water_percentage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        run();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1_layout,container,false);

        progressDrunk = view.findViewById(R.id.progressDrunk);
        buttonDrinksABit = view.findViewById(R.id.button_drink);
        minutes_for_next_drink = view.findViewById(R.id.minutes_for_next_drink);
        water_percentage = view.findViewById(R.id.text_water_percentage);

        buttonDrinksABit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(progressDrunk.getProgress() < 100){
                    progressDrunk.setProgress(progressDrunk.getProgress()+10);
                }
                resetDesidratacao(view);
            }
        });
        startDesidratacao(view);
        return view ;
    }

    public void startDesidratacao(View view){
        minutes_for_next_drink.start();
    }

    public void resetDesidratacao(View view){
        deleteTime();
        water_percentage.setText(progressDrunk.getProgress() + "%");
    }

    @Override
    public void run() {
        if (progressDrunk.getProgress() > 0) {
            //atualiza a porcentagem de agua
            water_percentage.setText(progressDrunk.getProgress() -1 + "%");
            //atualiza o quanto de hidratacao ainda resta
            progressDrunk.setProgress(progressDrunk.getProgress() - 1);
            handler.postDelayed(this, 3000);
            deleteTime();
        }else if (progressDrunk.getProgress() == 0){
            handler.postDelayed(this, 3000);
            water_percentage.setText("Você esta desidratado.");
        }
    }

    public void deleteTime() {
        minutes_for_next_drink.setBase(SystemClock.elapsedRealtime());
    }
}


