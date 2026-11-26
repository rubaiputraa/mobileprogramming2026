# Dynamic UI — Vocabulary Games v.1.1
Pemrograman Mobile 2026

### Daftar Anggota Kelompok

- **Anggota 1: Imam Rubai Putra 312410009**
- **Anggota 2: Muhammad Anggoro Binadro 312410017**
- **Anggota 3: Jeremy Marcellino Limantoro 312410010**

### Fitur Utama

- **Navigasi Terpusat (Navigation Component)**
- **Menu Utama Bawah 3 Tab (Bottom Navigation: Menu Utama, Skor Terbaik, Credit)**
- **Layar Menu Berbasis Fragment & Input Nama Pemain**
- **Layar Kuis Berbasis Fragment & Catatan Waktu Pengerjaan**
- **Layar Skor Terbaik (Nama Pemegang Rekor & Catatan Waktu)**
- **Layar Credit & Catatan Developer (CreditFragment)**
- **Detail Kata & Tentang Permainan / About (BottomSheetDialogFragment)**
- **Konfirmasi Keluar Aplikasi, Keluar Kuis & Reset Data (DialogFragment)**

### Letak Penerapan Dynamic UI

- **Perpindahan Layar Satu Activity (NavHostFragment & BottomNavigationView):** Pergantian halaman antara tab **Menu Utama**, **Skor Terbaik**, dan **Credit** berjalan secara dinamis di dalam satu `MainActivity`, disertai penyembunyian bilah navigasi bawah secara otomatis saat kuis berlangsung.
- **Panel Bawah Dinamis (BottomSheetDialogFragment):** Muncul dari bagian bawah layar saat pengguna menekan item riwayat kosakata untuk melihat artinya (`DetailKataBottomSheet`) maupun saat membuka panduan permainan (`AboutBottomSheet`).
- **Dialog Pop-up Dinamis (DialogFragment):** Muncul melayang di atas layar untuk menampilkan ringkasan skor akhir kuis (`HasilKuisDialogFragment`), konfirmasi keluar aplikasi (`KonfirmasiKeluarDialogFragment`), konfirmasi keluar saat bermain (`KonfirmasiKeluarKuisDialogFragment`), dan konfirmasi hapus data (`KonfirmasiResetDialogFragment`).
- **Pembaruan Tampilan Kuis & Rekor Secara Langsung (RecyclerView & CountDownTimer):** Pergantian soal, pengacakan opsi jawaban, hitung mundur waktu tiap soal, catatan total waktu pengerjaan, serta pembaruan nama pemegang rekor diperbarui secara langsung mengikuti interaksi pemain.

| Anggota | Peran | Fokus Fitur |
| :--- | :--- | :--- |
| **Rubai** | Core Architecture, Exit Dialog & Credit | Setup Navigation Component, BottomNavigationView (3 tab), host MainActivity, DialogFragment konfirmasi keluar aplikasi, dan pembuatan CreditFragment |
| **Aang** | Menu, Quiz Flow & About Sheet | Pembuatan MenuFragment, input nama pemain, logika kuis & waktu pengerjaan di QuizFragment, dialog keluar kuis, serta BottomSheetDialogFragment About |
| **Jeremy** | High Score, Word Detail & Reset Feature | Pembuatan SkorTerbaikFragment (tampilan skor, nama, & waktu), BottomSheetDialogFragment detail kata, serta fitur Reset data dengan DialogFragment konfirmasi |
