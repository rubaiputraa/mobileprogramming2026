
package com.learntospell.myapplication;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HasilKuisDialogFragment extends DialogFragment {

    public static final String REQUEST_KEY = "hasil_kuis_request";
    public static final String KEY_AKSI = "hasil_kuis_aksi";

    public static final String AKSI_MAIN_LAGI = "main_lagi";
    public static final String AKSI_MENU = "kembali_menu";

    private static final String ARG_LEVEL = "level";
    private static final String ARG_BENAR = "benar";
    private static final String ARG_SALAH = "salah";
    private static final String ARG_TOTAL = "total";

    // Menerima data hasil permainan
    public static HasilKuisDialogFragment newInstance(
            String level, int benar, int salah, int total) {

        HasilKuisDialogFragment fragment =
                new HasilKuisDialogFragment();

        Bundle args = new Bundle();

        args.putString(ARG_LEVEL, level);
        args.putInt(ARG_BENAR, benar);
        args.putInt(ARG_SALAH, salah);
        args.putInt(ARG_TOTAL, total);

        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        Bundle args = requireArguments();

        String level = args.getString(ARG_LEVEL, "Easy");
        int benar = args.getInt(ARG_BENAR, 0);
        int salah = args.getInt(ARG_SALAH, 0);
        int total = args.getInt(ARG_TOTAL, 0);

        int nilai = total > 0 ? benar * 100 / total : 0;

        String ringkasan =
                "Level: " + level +
                        "\nJawaban benar: " + benar +
                        "\nJawaban salah: " + salah +
                        "\nNilai akhir: " + nilai +
                        "\n\nMau mencoba sekali lagi?";

        return new MaterialAlertDialogBuilder(requireContext())
                .setTitle("Sesi Kuis Selesai!")
                .setMessage(ringkasan)

                .setPositiveButton("Main Lagi", (dialog, which) -> {
                    kirimAksi(AKSI_MAIN_LAGI);
                })

                .setNegativeButton("Kembali ke Menu", (dialog, which) -> {
                    kirimAksi(AKSI_MENU);
                })

                .setCancelable(false)
                .create();
    }

    // Mengirim pilihan pengguna ke QuizFragment
    private void kirimAksi(String aksi) {

        Bundle hasil = new Bundle();
        hasil.putString(KEY_AKSI, aksi);

        getParentFragmentManager().setFragmentResult(
                REQUEST_KEY,
                hasil
        );
    }
}
