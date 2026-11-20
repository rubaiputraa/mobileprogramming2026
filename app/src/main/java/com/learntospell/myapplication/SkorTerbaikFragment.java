package com.learntospell.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SkorTerbaikFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_skor_terbaik, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvRekorEasy = view.findViewById(R.id.tvRekorEasy);
        TextView tvRekorMedium = view.findViewById(R.id.tvRekorMedium);
        TextView tvRekorDifficult = view.findViewById(R.id.tvRekorDifficult);
        ListView listKosakata = view.findViewById(R.id.listKosakata);

        SharedPreferences prefs = requireContext()
                .getSharedPreferences("PREF_SKOR_TERBAIK", Context.MODE_PRIVATE);

        int skorEasy = prefs.getInt("SKOR_EASY", 0);
        int skorMedium = prefs.getInt("SKOR_MEDIUM", 0);
        int skorDifficult = prefs.getInt("SKOR_DIFFICULT", 0);

        tvRekorEasy.setText("Easy: " + skorEasy);
        tvRekorMedium.setText("Medium: " + skorMedium);
        tvRekorDifficult.setText("Difficult: " + skorDifficult);

        Set<String> riwayatSet = prefs.getStringSet("RIWAYAT_KATA", new HashSet<>());
        ArrayList<String> daftarKata = new ArrayList<>(riwayatSet);
        if (daftarKata.isEmpty()) {
            daftarKata.add("Belum ada riwayat kosakata");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                android.R.layout.simple_list_item_1,
                daftarKata
        );
        listKosakata.setAdapter(adapter);
    }
}