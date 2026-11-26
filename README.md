# Dynamic UI — Vocabulary Games v.1.1
Pemrograman Mobile 2026

### Daftar Anggota Kelompok
- **Anggota 1:** Imam Rubai Putra (312410009)
- **Anggota 2:** Muhammad Anggoro Binadro (312410017)
- **Anggota 3:** Jeremy Marcellino Limantoro (312410010)

### Fitur Utama Aplikasi
- **Kuis Kosakata Multi-Level:** Pilihan tingkat kesulitan *Easy*, *Medium*, dan *Difficult* dengan hitung mundur 15 detik per soal.
- **Identitas Pemain & Waktu Pengerjaan:** Input nama pemain sebelum bermain serta pencatatan total durasi penyelesaian kuis sebagai penentu rekor.
- **Papan Skor Terbaik & Reset Data:** Menyimpan nilai tertinggi beserta nama peraih dan catatan waktunya secara permanen, dilengkapi tombol reset untuk mengosongkan data.
- **Panduan & Credit:** Halaman informasi tentang cara bermain (*About*) dan profil tim pengembang (*Credit*).

### Letak Penerapan Dynamic UI
- **Perpindahan Halaman Dinamis (Bottom Navigation):** Berpindah antara tab **Menu Utama**, **Skor Terbaik**, dan **Credit** secara langsung di dalam satu layar utama, serta bilah navigasi otomatis menghilang saat kuis dimulai agar layar fokus ke soal.
- **Panel Bawah Dinamis (Bottom Sheet):** Muncul dari bawah layar saat pemain menekan salah satu kosakata di daftar riwayat untuk melihat artinya, maupun saat membuka informasi *About*.
- **Pop-up Dialog Dinamis:** Muncul melayang di atas layar untuk menampilkan ringkasan skor akhir kuis, konfirmasi sebelum mereset skor, serta konfirmasi keluar agar pemain tidak keluar secara tidak sengaja di tengah permainan.

### Pembagian Peran Tim

| Anggota | Peran | Fokus Fitur |
| :--- | :--- | :--- |
| **Rubai** | Arsitektur Utama & Navigasi | Kerangka navigasi 3 tab, konfirmasi keluar aplikasi, dan halaman Credit |
| **Aang** | Menu & Alur Permainan | Menu utama, input nama pemain, logika kuis & waktu pengerjaan, serta info About |
| **Jeremy** | Skor & Riwayat Kata | Halaman skor terbaik, panel detail arti kata, dan fitur reset data |
