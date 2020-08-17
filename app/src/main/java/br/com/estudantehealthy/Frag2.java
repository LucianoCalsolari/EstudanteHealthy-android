package br.com.estudantehealthy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.estudantehealthy.adapter.Adapter_tasks;

public class Frag2 extends Fragment {

    private RecyclerView recyclerView;
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.frag2_layout,container,false);
        recyclerView = rootView.findViewById(R.id.recyclerView);

        //Configurar adapter
        Adapter_tasks adapterTasks = new Adapter_tasks(getContext());

        //Configurar Recyclerview
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapterTasks);

        return  rootView;
    }

}
