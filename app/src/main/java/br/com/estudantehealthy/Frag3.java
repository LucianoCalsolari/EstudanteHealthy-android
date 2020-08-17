package br.com.estudantehealthy;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.estudantehealthy.adapter.Adapter_timeof_tasks;
import br.com.estudantehealthy.model.Horas;

public class Frag3 extends Fragment {

    private Chronometer chronometer_num_now;
    private Button button_play;
    private Button button_pause;
    private Button button_refresh;
    private TextView text_rank;

    private RecyclerView recyclerView;
    private View rootView;

    private int countClicks = 0;

    private List<Horas> rank = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frag3_layout,container,false);

        //
        chronometer_num_now = rootView.findViewById(R.id.chronometer_num_now);
        button_play = rootView.findViewById(R.id.button_play);
        button_pause = rootView.findViewById(R.id.button_pause);
        button_refresh = rootView.findViewById(R.id.button_refresh);
        text_rank = rootView.findViewById(R.id.text_rank);

        //Configurando o adapter
        Adapter_timeof_tasks adapterTime = new Adapter_timeof_tasks(getContext());

        //Configurando o recyclerView
        RecyclerView.LayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTime);

        //Botao Play
        button_play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                deleteTime();
                chronometer_num_now.start();
            }
        });

        //Botao Pause
        button_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer_num_now.stop();
            //    if(chronometer_num_now.getDrawingTime()>0.02){
                    countClicks++;
                    adiciona("Estudo ", chronometer_num_now.getText());
                    deleteTime();
                    imprime(countClicks);

             //   }
            }
        });

        //Botao Recomecar
        button_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteTime();
            }
        });

        return rootView ;
    }

    //
    public void deleteTime() {
        chronometer_num_now.setBase(SystemClock.elapsedRealtime());
    }

    //
    public void adiciona(String tarefa,CharSequence horasUsadas) {
        Horas horas = new Horas(tarefa,horasUsadas);
        rank.add(horas);
    }

    //
    public void imprime(int id){

        Horas a = rank.get(id);
        text_rank.setText( a.getNome() +":"+ a.getHoras() );
    }
}
