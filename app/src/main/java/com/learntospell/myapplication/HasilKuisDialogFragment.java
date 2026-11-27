package com.learntospell.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HasilKuisDialogFragment extends DialogFragment {
    public static final String REQUEST_KEY = "REQUEST_HASIL_KUIS";
    public static final String KEY_AKSI = "KEY_AKSI";
    public static final String AKSI_MAIN_LAGI = "AKSI_MAIN_LAGI";
    public static final String AKSI_MENU = "AKSI_MENU";

    private static final String ARG_LEVEL = "KEY_LEVEL";
    private static final String ARG_BENAR = "JUMLAH_BENAR";
    private static final String ARG_SALAH = "JUMLAH_SALAH";
    private static final String ARG_TOTAL = "JUMLAH_SOAL";
    private static final String ARG_NAMA = "KEY_NAMA";
    private static final String ARG_WAKTU = "WAKTU_PENGERJAAN";

    public static HasilKuisDialogFragment newInstance(String level, int benar, int salah, int totalSoal) {
        return newInstance(level, benar, salah, totalSoal, "Anonim", 0);
    }

    public static HasilKuisDialogFragment newInstance(String level, int benar, int salah,
                                                      int totalSoal, String nama, int waktuDetik) {
        HasilKuisDialogFragment fragment = new HasilKuisDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_LEVEL, level);
        args.putInt(ARG_BENAR, benar);
        args.putInt(ARG_SALAH, salah);
        args.putInt(ARG_TOTAL, totalSoal);
        args.putString(ARG_NAMA, nama);
        args.putInt(ARG_WAKTU, waktuDetik);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String level = "Easy";
        String nama = "Anonim";
        int benar = 0;
        int salah = 0;
        int total = 5;
        int waktu = 0;

        if (getArguments() != null) {
            level = getArguments().getString(ARG_LEVEL, "Easy");
            nama = getArguments().getString(ARG_NAMA, "Anonim");
            benar = getArguments().getInt(ARG_BENAR, 0);
            salah = getArguments().getInt(ARG_SALAH, 0);
            total = getArguments().getInt(ARG_TOTAL, 5);
            waktu = getArguments().getInt(ARG_WAKTU, 0);
        }

        int nilai = total > 0 ? (benar * 100 / total) : 0;
        String pesan = "Pemain: " + nama
                + "\nLevel: " + level
                + "\nBenar: " + benar + " | Salah: " + salah
                + "\nNilai Akhir: " + nilai
                + "\nWaktu Pengerjaan: " + waktu + " detik";

        setCancelable(false);
        return new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Sesi Selesai")
                .setMessage(pesan)
                .setPositiveButton("Main Lagi", (dialog, which) -> kirimAksi(AKSI_MAIN_LAGI))
                .setNegativeButton("Menu Utama", (dialog, which) -> kirimAksi(AKSI_MENU))
                .create();
    }

    private void kirimAksi(String aksi) {
        Bundle result = new Bundle();
        result.putString(KEY_AKSI, aksi);
        getParentFragmentManager().setFragmentResult(REQUEST_KEY, result);
    }
}