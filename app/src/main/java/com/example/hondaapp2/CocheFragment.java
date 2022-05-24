package com.example.hondaapp2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.royrodriguez.transitionbutton.TransitionButton;


public class CocheFragment extends Fragment {

    TransitionButton botonh, botone, botong, btodos;
    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coche, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstanceSrate) {
        super.onViewCreated(view, savedInstanceSrate);

        navController = Navigation.findNavController(view);

        botonh = view.findViewById(R.id.botonh);
        botone = view.findViewById(R.id.botone);
        botong = view.findViewById(R.id.botong);

        botone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botone.startAnimation();

                // Do your networking task or background work here.
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        boolean isSuccessful = true;

                        // Choose a stop animation if your call was succesful or not
                        if (isSuccessful) {
                            botone.stopAnimation(TransitionButton.StopAnimationStyle.EXPAND, new TransitionButton.OnAnimationStopEndListener() {
                                @Override
                                public void onAnimationStopEnd() {
                                    navController.navigate(R.id.action_cocheFragment_to_electricoFragment);
                                }
                            });
                        } else {
                            botone.stopAnimation(TransitionButton.StopAnimationStyle.SHAKE, null);
                        }
                    }
                }, 2000);
            }
        });


        botonh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cocheFragment_to_hibridoFragment);
            }
        });

        botong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_cocheFragment_to_gasolinaFragment);
            }
        });

    }
}