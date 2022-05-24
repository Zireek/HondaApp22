package com.example.hondaapp2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MotoFragment extends Fragment {

    Button botonvermoto;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_moto, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceSrate) {
        super.onViewCreated(view, savedInstanceSrate);

        navController = Navigation.findNavController(view);

        botonvermoto  = view.findViewById(R.id.botonvermoto);

        botonvermoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_motoFragment_to_motosupersportFragment);
            }
        });

    }


}