package com.learntospell.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class QuizFragment extends Fragment {

    private HashMap<String, String> kamusEasy, kamusMedium, kamusDifficult, kamus;
    private ArrayList<String> kataEasy, kataMedium, kataDifficult, kata;
    private int JUMLAH_OPSI = 5, JUMLAH_SOAL = 3, soalKe = 0;
    private RecyclerView rvOpsi;
    private OpsiAdapter adapter;
    private TextView textHasil, textSkor, textWaktu, textSoal;
    private String soal;
    private String levelTerpilih = "Easy";
    private ArrayList<String> opsiJawaban, listsalah;
    private int skorBenar = 0;
    private int skorSalah = 0;

    private static final String TAG_TIMER = "Timer";
    private static final long DURASI_SOAL = 15000;
    private CountDownTimer timer;
    private long sisaMs = DURASI_SOAL;
    private boolean sudahDijawab = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textHasil = view.findViewById(R.id.hasil);
        textSkor = view.findViewById(R.id.skor);
        textWaktu = view.findViewById(R.id.waktu);
        textSoal = view.findViewById(R.id.vocab);
        rvOpsi = view.findViewById(R.id.opsi);
        Button tombolBerikutnya = view.findViewById(R.id.tombolBerikutnya);

        rvOpsi.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new OpsiAdapter((OpsiAdapter.OnOpsiClickListener) position -> {
            periksaJawaban(position);
            Log.d("VocabQuiz", "Opsi diklik: posisi " + position);
        });
        rvOpsi.setAdapter(adapter);

        tombolBerikutnya.setOnClickListener(v -> letsPlay());

        kamus = new HashMap<>();
        kata = new ArrayList<>();
        listsalah = new ArrayList<>();

        kamusEasy = new HashMap<>();
        kataEasy = new ArrayList<>();
        kamusMedium = new HashMap<>();
        kataMedium = new ArrayList<>();
        kamusDifficult = new HashMap<>();
        kataDifficult = new ArrayList<>();

        readFromFile(R.raw.vocab_easy, kamusEasy, kataEasy);
        readFromFile(R.raw.vocab_medium, kamusMedium, kataMedium);
        readFromFile(R.raw.vocab_difficult, kamusDifficult, kataDifficult);

        if (getArguments() != null && getArguments().getString("KEY_LEVEL") != null) {
            levelTerpilih = getArguments().getString("KEY_LEVEL");
        }

        pilihLevel(levelTerpilih);
        soalKe = 0;
        skorBenar = 0;
        skorSalah = 0;
        sudahDijawab = false;

        updateSkor();
        letsPlay();
    }

    private void pilihLevel(String level) {
        if ("Medium".equalsIgnoreCase(level)) {
            kamus = kamusMedium;
            kata = kataMedium;
        } else if ("Difficult".equalsIgnoreCase(level)) {
            kamus = kamusDifficult;
            kata = kataDifficult;
        } else {
            kamus = kamusEasy;
            kata = kataEasy;
        }
    }

    private void letsPlay() {
        if (soalKe >= JUMLAH_SOAL) {
            selesaiSesi();
            return;
        }
        soalKe++;
        opsiJawaban = new ArrayList<>();
        soal = null;
        textHasil.setText("");

        ArrayList<String> acak = new ArrayList<>(kata);
        Collections.shuffle(acak);
        soal = acak.get(0);

        for (int i = 0; i < JUMLAH_OPSI; i++) {
            opsiJawaban.add(kamus.get(acak.get(i)));
        }
        Collections.shuffle(opsiJawaban);

        textSoal.setText(soal);
        adapter.setOpsi(opsiJawaban, opsiJawaban.indexOf(kamus.get(soal)));

        sisaMs = DURASI_SOAL;
        mulaiTimer(sisaMs);
    }

    private void selesaiSesi() {
        hentikanTimer();
        sudahDijawab = true;
        Intent intent = new Intent(requireContext(), RingkasanHasil.class);
        intent.putExtra("JUMLAH_BENAR", skorBenar);
        intent.putExtra("JUMLAH_SALAH", skorSalah);
        intent.putExtra("JUMLAH_SOAL", JUMLAH_SOAL);
        intent.putExtra("KEY_LEVEL", levelTerpilih);
        intent.putStringArrayListExtra("DAFTAR_SALAH", listsalah);
        startActivity(intent);
    }

    private void periksaJawaban(int position) {
        hentikanTimer();
        adapter.tandaiJawaban(position);
        String benar = kamus.get(soal);
        String diklik = opsiJawaban.get(position);
        if (diklik.equals(benar)) {
            skorBenar++;
            textHasil.setText("Benar!");
        } else {
            skorSalah++;
            textHasil.setText("Salah. Jawaban benar: " + benar);
            listsalah.add(soal + ": " + benar);
        }
        updateSkor();
    }

    private void readFromFile(int resourceId, HashMap<String, String> kamus, ArrayList<String> kata) {
        Scanner scan = new Scanner(getResources().openRawResource(resourceId));
        while (scan.hasNextLine()) {
            String[] t = scan.nextLine().split("\t");
            if (t.length >= 2) {
                kamus.put(t[0].trim(), t[1].trim());
                kata.add(t[0].trim());
            }
        }
        scan.close();
    }

    private void updateSkor() {
        textSkor.setText("soal no: " + (soalKe + 1) + " Benar: " + skorBenar + "  Salah: " + skorSalah);
    }

    private void mulaiTimer(long durasi) {
        hentikanTimer();
        timer = new CountDownTimer(durasi, 1000) {
            @Override
            public void onTick(long ms) {
                sisaMs = ms;
                textWaktu.setText((ms + 999) / 1000 + " detik");
                Log.d(TAG_TIMER, "tick " + (ms + 999) / 1000);
            }

            @Override
            public void onFinish() {
                sisaMs = 0;
                textWaktu.setText("0 detik");
                waktuHabis();
            }
        }.start();
    }

    private void hentikanTimer() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void waktuHabis() {
        skorSalah++;
        updateSkor();
        adapter.tandaiWaktuHabis();
        textHasil.setText("Waktu habis. Jawaban benar: " + kamus.get(soal));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!sudahDijawab && sisaMs > 0) {
            mulaiTimer(sisaMs);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        hentikanTimer();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        hentikanTimer();
    }
}