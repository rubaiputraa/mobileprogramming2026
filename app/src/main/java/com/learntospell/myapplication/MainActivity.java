package com.learntospell.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private HashMap<String, String> kamusEasy, kamusMedium, kamusDifficult, kamus;
    private ArrayList<String> kataEasy, kataMedium, kataDifficult, kata;
    int JUMLAH_OPSI=5;
    private RecyclerView rvOpsi;
    private OpsiAdapter adapter;
    private TextView textHasil;
    private String soal;
    private int JUMLAH_SOAL = 10;
    private int soalke = 0;
    private ArrayList<String> opsiJawaban;
    private static final String TAG_LC = "Lifecycle";
    private TextView textSkor;
    private int skorBenar = 0;
    private int skorSalah = 0;

    private static final String TAG_TIMER = "Timer";
    private static final long DURASI_SOAL = 15000;

    private TextView textWaktu;
    private RadioGroup radioGroupLevel;
    private CountDownTimer timer;
    private long sisaMs = DURASI_SOAL;
    private boolean sudahDijawab = false;
    private static final String KEY_SKOR_BENAR = "skor_benar";
    private static final String KEY_SKOR_SALAH = "skor_salah";
    private static final String KEY_SOAL = "soal";
    private static final String KEY_OPSI = "opsi";
    private static final String KEY_SISA_MS = "sisa_ms";
    private static final String KEY_LEVEL = "level";

    private final Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG_LC, "onCreate, savedInstanceState " + (savedInstanceState == null ? "null" : "ada"));


        // pilihLevel(radioGroupLevel.getCheckedRadioButtonId());


        textHasil = findViewById(R.id.hasil);
        rvOpsi = findViewById(R.id.opsi);
        rvOpsi.setLayoutManager(new LinearLayoutManager(this));

        adapter = new OpsiAdapter(new OpsiAdapter.OnOpsiClickListener() {
            @Override
            public void onOpsiClick(int position) {
                periksaJawaban(position);
                Log.d("VocabQuiz", "Opsi diklik: posisi " + position);
            }
        });
        rvOpsi.setAdapter(adapter);
        Button tombolBerikutnya = findViewById(R.id.tombolBerikutnya);
        tombolBerikutnya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsPlay();
            }
        });

        kamus = new HashMap<>();
        kata = new ArrayList<>();

        kamusEasy = new HashMap<>();
        kataEasy = new ArrayList<>();
        kamusMedium = new HashMap<>();
        kataMedium = new ArrayList<>();
        kamusDifficult = new HashMap<>();
        kataDifficult = new ArrayList<>();

        readFromFile(R.raw.vocab_easy, kamusEasy, kataEasy);
        readFromFile(R.raw.vocab_medium, kamusMedium, kataMedium);
        readFromFile(R.raw.vocab_difficult, kamusDifficult, kataDifficult);
        kamus = kamusEasy;
        kata = kataEasy;
        textSkor = findViewById(R.id.skor);
        updateSkor();
        textWaktu = findViewById(R.id.waktu);

        radioGroupLevel = findViewById(R.id.radioGroupLevel);


        radioGroupLevel.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                pilihLevel(checkedId);
                letsPlay();
            }
        });

        if (savedInstanceState != null)
            Log.d(TAG_LC, "onCreate, Grouplevel " + savedInstanceState.getInt(KEY_LEVEL));


        if (savedInstanceState != null) {
            skorBenar = savedInstanceState.getInt(KEY_SKOR_BENAR);
            skorSalah = savedInstanceState.getInt(KEY_SKOR_SALAH);
            radioGroupLevel.check(savedInstanceState.getInt(KEY_LEVEL));
            updateSkor();

        }



        letsPlay();
    }

    private String kodeLevel() {
        int id = radioGroupLevel.getCheckedRadioButtonId();
        if (id == R.id.radioEasy) return "Easy";
        if (id == R.id.radioMedium) return "Medium";
        return "Hard";
    }

    private void mulaiSesiBaru() {
        soalke = 0;
        skorBenar = 0;
        skorSalah = 0;
        letsPlay();
    }

    private void selesaiSesi() {
        hentikanTimer();
        sudahDijawab = true;
        tampilkanRingkasan();
    }

    private void tampilkanRingkasan () {
        int nilai = skorBenar * 100 / JUMLAH_SOAL;
        new AlertDialog.Builder(this)
                .setTitle("Sesi Selesai")
                .setMessage("Level: " + kodeLevel() + " Nilai: " + nilai)
                .setPositiveButton("Mau main lagi?", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialoginterface, int i) {
                        mulaiSesiBaru();
                    }
                }).show();


    }

    private void pilihLevel(int checkedId) {
        if (checkedId == R.id.radioEasy) {
            kamus = kamusEasy;
            kata = kataEasy;
        } else if (checkedId == R.id.radioMedium) {
            kamus = kamusMedium;
            kata = kataMedium;
        } else if (checkedId == R.id.radioDifficult) {
            kamus = kamusDifficult;
            kata = kataDifficult;
        }

    }

    private void letsPlay() {
        if (soalke >= JUMLAH_SOAL){
            selesaiSesi();
            return;
        }
        soalke++;
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

        TextView textSoal = findViewById(R.id.vocab);
        textSoal.setText(soal);
        // adapter.setOpsi(opsiJawaban);
        textHasil.setText("");
        adapter.setOpsi(opsiJawaban, opsiJawaban.indexOf(kamus.get(soal)));

        sisaMs = DURASI_SOAL;
        mulaiTimer(sisaMs);


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
        textSkor.setText("Soal no: " + (soalke+1) + " Benar: " + skorBenar + "  Salah: " + skorSalah);
    }

    private void mulaiTimer(long durasi) {
        hentikanTimer();
        timer = new CountDownTimer(durasi, 1000) {
            @Override
            public void onTick(long ms) {
                sisaMs = ms;
                textWaktu.setText((ms + 999) / 1000 + " detik");
                Log.d(TAG_TIMER, "tick " + (ms + 999) / 1000
                        + " dari activity " + Integer.toHexString(MainActivity.this.hashCode()));
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
    protected void onStart() {
        super.onStart();
        Log.d(TAG_LC, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG_LC, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG_LC, "onResume");
        if (!sudahDijawab && sisaMs > 0) {
            mulaiTimer(sisaMs);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG_LC, "onPause");
        hentikanTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG_LC, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG_LC, "onDestroy, isFinishing=" + isFinishing()
                + ", isChangingConfigurations=" + isChangingConfigurations());
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SKOR_BENAR, skorBenar);
        outState.putInt(KEY_SKOR_SALAH, skorSalah);

        outState.putString(KEY_SOAL, soal);
        outState.putStringArrayList(KEY_OPSI, opsiJawaban);
        outState.putLong(KEY_SISA_MS, sisaMs);
        outState.putInt(KEY_LEVEL, radioGroupLevel.getCheckedRadioButtonId() );
        Log.d(TAG_LC, "onSaveInstanceState, skor=" + skorBenar + "/" + skorSalah
                + radioGroupLevel.getCheckedRadioButtonId());
    }

}