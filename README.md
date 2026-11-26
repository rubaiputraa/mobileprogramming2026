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

- **Perpindahan Menu Satu Layar:** Berganti antar tab Menu Utama, Skor Terbaik, dan Credit dalam satu layar utama, serta menu bawah otomatis tersembunyi saat kuis dimulai.
- **Panel Bawah Layar:** Muncul dari bawah untuk menampilkan arti kosakata yang dipilih dan panduan permainan.
- **Jendela Pesan Melayang:** Kotak dialog untuk ringkasan skor akhir, konfirmasi reset data, serta peringatan sebelum keluar dari permainan atau aplikasi.
- **Pembaruan Langsung:** Soal, acakan jawaban, penghitung waktu, dan nama pemegang rekor otomatis berubah mengikuti interaksi pemain.
  
| Anggota | Peran | Fokus Fitur |
| :--- | :--- | :--- |
| **Rubai** | Core Architecture, Exit Dialog & Credit | Setup Navigation Component, BottomNavigationView (3 tab), host MainActivity, DialogFragment konfirmasi keluar aplikasi, DialogFragment konfirmasi keluar game, dan pembuatan CreditFragment |
| **Aang** | Menu, Quiz Flow & About Sheet | Pembuatan MenuFragment, input nama pemain, logika kuis & waktu pengerjaan di QuizFragment, dialog keluar kuis, serta BottomSheetDialogFragment About |
| **Jeremy** | High Score, Word Detail & Reset Feature | Pembuatan SkorTerbaikFragment (tampilan skor, nama, & waktu), BottomSheetDialogFragment detail kata, serta fitur Reset data dengan DialogFragment konfirmasi |
