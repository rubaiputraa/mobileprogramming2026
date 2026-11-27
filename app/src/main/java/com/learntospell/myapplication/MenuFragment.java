package com.learntospell.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class MenuFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etNamaPemain = view.findViewById(R.id.etNamaPemain);
        RadioGroup radioGroupLevel = view.findViewById(R.id.radioGroupLevel);
        Button btnMulaiKuis = view.findViewById(R.id.btnMulaiKuis);

        btnMulaiKuis.setOnClickListener(v -> {
            String namaPemain = etNamaPemain.getText().toString().trim();
            if (namaPemain.isEmpty()) {
                namaPemain = "Anonim";
            }

            String level = "Easy";
            int checkedId = radioGroupLevel.getCheckedRadioButtonId();
            if (checkedId == R.id.radioMedium) {
                level = "Medium";
            } else if (checkedId == R.id.radioDifficult) {
                level = "Difficult";
            }

            Bundle bundle = new Bundle();
            bundle.putString("KEY_LEVEL", level);
            bundle.putString("KEY_NAMA", namaPemain);
            Navigation.findNavController(v)
                    .navigate(R.id.action_menuFragment_to_quizFragment, bundle);
        });
    }
}