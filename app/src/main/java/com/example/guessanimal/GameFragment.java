package com.example.guessanimal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class GameFragment extends Fragment {
    private Button btn1, btn2,btn3, crow, fox, raccoon;
    private ImageView imageView;
    boolean isCrow, isRaccoon, isFox;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        changeImage(view);
        guessAnimal(view);
    }

    private void initView(View view){
        imageView = view.findViewById(R.id.animal_image);
        btn1=view.findViewById(R.id.btn_1);
        btn2=view.findViewById(R.id.btn_2);
        btn3=view.findViewById(R.id.btn_3);
        crow = view.findViewById(R.id.crow_btn);
        raccoon = view.findViewById(R.id.raccoon_btn);
        fox = view.findViewById(R.id.fox_btn);


    }

    private void  changeImage(View view){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.crow);
                isCrow=true;
                isRaccoon=false;
                isFox=false;


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.raccoon);
                isRaccoon=true;
                isFox=false;
                isCrow=false;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.fox);
                isFox=true;
                isCrow=false;
                isRaccoon=false;
            }
        });
    }

    private void guessAnimal(View view){

        crow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isCrow){
                    Toast.makeText(requireContext(),"Правильно", Toast.LENGTH_SHORT).show();

                }else if (isRaccoon){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }else if (isFox){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }
            }
        });

        raccoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isRaccoon){
                    Toast.makeText(requireContext(),"Правильно", Toast.LENGTH_SHORT).show();
                }else if(isFox){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }else if (isCrow){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isFox){
                    Toast.makeText(requireContext(),"Правильно", Toast.LENGTH_SHORT).show();
                }else if(isCrow){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }
                else if (isRaccoon){
                    Toast.makeText(requireContext(),"Ошибка", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



}