package com.learntospell.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class KonfirmasiKeluarKuisDialogFragment extends DialogFragment {

    public static final String REQUEST_KEY = "REQUEST_KELUAR_KUIS";
    public static final String KEY_KELUAR = "KEY_KELUAR";

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Keluar dari Permainan?")
                .setMessage("Progres kuis pada sesi ini tidak akan disimpan jika Anda keluar sekarang.")
                .setPositiveButton("Ya, Keluar", (dialog, which) -> kirimHasil(true))
                .setNegativeButton("Lanjut Main", (dialog, which) -> kirimHasil(false))
                .create();
    }

    @Override
    public void onCancel(@NonNull DialogInterface dialog) {
        super.onCancel(dialog);
        kirimHasil(false);
    }

    private void kirimHasil(boolean keluar) {
        Bundle result = new Bundle();
        result.putBoolean(KEY_KELUAR, keluar);
        getParentFragmentManager().setFragmentResult(REQUEST_KEY, result);
    }
}