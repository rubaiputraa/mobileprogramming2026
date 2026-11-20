package com.learntospell.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class DetailKataBottomSheet extends BottomSheetDialogFragment {

    private static final String ARG_KATA = "ARG_KATA";
    private static final String ARG_ARTI = "ARG_ARTI";
    private static final String ARG_LEVEL = "ARG_LEVEL";

    public static DetailKataBottomSheet newInstance(String kata, String arti, String level) {
        DetailKataBottomSheet fragment = new DetailKataBottomSheet();
        Bundle args = new Bundle();
        args.putString(ARG_KATA, kata);
        args.putString(ARG_ARTI, arti);
        args.putString(ARG_LEVEL, level);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.bottom_sheet_detail_kata, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvDetailLevel = view.findViewById(R.id.tvDetailLevel);
        TextView tvDetailKata = view.findViewById(R.id.tvDetailKata);
        TextView tvDetailArti = view.findViewById(R.id.tvDetailArti);
        Button btnTutupDetail = view.findViewById(R.id.btnTutupDetail);

        if (getArguments() != null) {
            String kata = getArguments().getString(ARG_KATA, "");
            String arti = getArguments().getString(ARG_ARTI, "");
            String level = getArguments().getString(ARG_LEVEL, "Easy");

            tvDetailLevel.setText("Level: " + level);
            tvDetailKata.setText(kata);
            tvDetailArti.setText(arti);
        }

        btnTutupDetail.setOnClickListener(v -> dismiss());
    }
}