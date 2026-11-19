# Dokumen Perencanaan & WBS: Implementasi Dynamic UI

**Proyek:** Aplikasi Kuis Kosakata  
**Target Waktu:** 3 Minggu (21 Hari)  
**Jumlah Tim:** 3 Orang

---

## 1\. Pembagian Peran & Tanggung Jawab Tim

Agar pengerjaan berjalan paralel tanpa saling menghambat dan menghindari konflik kode pada berkas yang sama, tugas dibagi secara merata menjadi tiga fokus utama:

| Anggota | Peran | Fokus Fitur | Berkas Tanggung Jawab |
| :---- | :---- | :---- | :---- |
| **Anggota 1** | *Core Architecture & Exit Dialog* | Setup Navigation Component, `BottomNavigationView`, host `MainActivity`, dan `DialogFragment` konfirmasi keluar | `build.gradle`, `strings.xml`, `bottom_nav_menu.xml`, `nav_graph.xml` (kerangka), `activity_main.xml`, `MainActivity.java`, `KonfirmasiKeluarDialogFragment.java` |
| **Anggota 2** | *Menu & Quiz Flow* | Pembuatan layar beranda `MenuFragment` dan migrasi logika permainan dari `MainActivity` lama ke `QuizFragment` | `fragment_menu.xml`, `MenuFragment.java`, `fragment_quiz.xml`, `QuizFragment.java`, registrasi rute Menu di `nav_graph.xml` |
| **Anggota 3** | *High Score & Word Detail* | Pembuatan `SkorTerbaikFragment` dengan penyimpanan permanen serta `BottomSheetDialogFragment` detail kata | `fragment_skor_terbaik.xml`, `SkorTerbaikFragment.java`, `bottom_sheet_detail_kata.xml`, `DetailKataBottomSheet.java`, registrasi rute Skor di `nav_graph.xml` |

---

## 2\. Jadwal Pengerjaan (Timeline 2 Minggu)

| Periode | Kode WBS | Fokus Pengerjaan | PIC | Target Capaian |
| :---- | :---- | :---- | :---- | :---- |
| **Minggu** (Hari 1–2) | 1.1 – 1.2 | Setup dependensi `build.gradle`, pembuatan `bottom_nav_menu.xml`, dan kerangka `nav_graph.xml` | Anggota 1 | Fondasi navigasi proyek siap digunakan oleh seluruh tim |
| **Minggu 1**(Hari 3–4) | 1.3, 2.1, 3.1 | Anggota 1 merombak `MainActivity` & membuat `KonfirmasiKeluarDialogFragment`; Anggota 2 & 3 menyiapkan layout XML fragment | Semua Anggota *(Paralel)* | Wadah navigasi utama dan seluruh tata letak XML fragment selesai |
| **Minggu 1** (*Hari 5–7)* | 2.2, 3.2 | Migrasi logika Java ke `MenuFragment`, `QuizFragment`, dan `SkorTerbaikFragment` serta penyesuaian konteks `requireContext()` | Anggota 2 & 3 | Seluruh halaman utama berjalan dalam bentuk Fragment |
| **Minggu 2**(Hari 8–10) | 3.3, 2.3, 3.4 | Pembuatan `DetailKataBottomSheet` \+ layoutnya, serta pendaftaran seluruh rute destinasi ke `nav_graph.xml` | Anggota 2 & 3 *(Anggota 1 review graph)* | Seluruh fitur Dynamic UI selesai diimplementasikan |
| **Minggu 2**(Hari 11–12) | 4.1 | Penggabungan kode seluruh anggota (*merge*), pembersihan resource ID, dan penyamaan kunci data | Semua Anggota | Kode terintegrasi di branch utama tanpa error kompilasi |
| **Minggu 2**(Hari 13–14) | 4.2 *(Buffer)* | Pengujian menyeluruh alur navigasi, dialog, bottom sheet, dan perbaikan bug sebelum pengumpulan | Semua Anggota | Aplikasi stabil dan siap dikumpulkan |

---

## 3\. Work Breakdown Structure (WBS) Detail: Sebelum vs Sesudah

### Paket Kerja 1.0: Inisiasi & Setup Fondasi Navigasi (Anggota 1\)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan |
| :---- | :---- | :---- | :---- | :---- |
| **1.1.1** | Tambah library Navigation Component dan Material Design di `build.gradle` | Tema aplikasi di `themes.xml` sudah memakai `Theme.Material3.DayNight.NoActionBar`, namun `build.gradle` belum memasang dependensi Navigation Component. | Menambahkan `androidx.navigation:navigation-fragment` dan `androidx.navigation:navigation-ui` pada blok `dependencies` di `build.gradle` tingkat modul. | Pustaka `NavHostFragment`, `NavController`, dan `NavigationUI` dapat diimpor di Java tanpa error kompilasi. |
| **1.1.2** | Sinkronisasi Gradle dan pastikan tidak ada konflik versi | Konfigurasi proyek baru memuat library standar untuk `AppCompatActivity`, `RecyclerView`, dan `MaterialCardView`. | Menjalankan *Sync Now* di Android Studio serta menyelaraskan versi AGP dan `compileSdk` dengan pustaka Navigation. | Proses *Gradle Sync* dan *Build Project* selesai sukses tanpa konflik versi dependensi. |
| **1.2.1** | Buat item menu bawah di `res/menu/bottom_nav_menu.xml` | Belum ada direktori `res/menu`, dan `strings.xml` baru berisi `<string name="app_name">My Application</string>`. | Menambahkan string judul tab di `strings.xml`, lalu membuat `res/menu/bottom_nav_menu.xml` berisi 2 item: `@+id/menuFragment` dan `@+id/skorTerbaikFragment`. | File XML menu valid dan ID kedua item sudah disepakati bersama Anggota 2 dan Anggota 3\. |
| **1.2.2** | Buat kerangka awal `res/navigation/nav_graph.xml` | Perpindahan layar dilakukan secara manual menggunakan `Intent(this, RingkasanHasil.class)` di dalam `MainActivity.java`. | Membuat `res/navigation/nav_graph.xml` sebagai peta navigasi terpusat yang memuat destinasi `MenuFragment`, `QuizFragment`, dan `SkorTerbaikFragment`. | Tab *Design* dan *Code* pada `nav_graph.xml` terbuka normal tanpa error referensi kelas atau layout. |
| **1.3.1** | Ubah `activity_main.xml` menjadi wadah `FragmentContainerView` dan `BottomNavigationView` | `activity_main.xml` berisi komponen tampilan kuis (`skor`, `waktu`, `radioGroupLevel`, `vocab`, `hasil`, `RecyclerView` `opsi`, dan `tombolBerikutnya`). | Memindahkan seluruh elemen UI kuis ke `fragment_quiz.xml`, lalu mengganti isi `activity_main.xml` menjadi `FragmentContainerView` (`NavHostFragment`) dan `BottomNavigationView`. | Preview `activity_main.xml` menampilkan wadah fragment di atas dan bilah navigasi bawah menempel rapi di bawah layar. |
| **1.3.2** | Hubungkan `NavController` ke `BottomNavigationView` di `MainActivity.java` | `MainActivity.java` menjalankan logika permainan kuis, `OpsiAdapter`, pembacaan `R.raw.vocab_*`, dan `CountDownTimer`. | Memindahkan logika kuis keluar dari `MainActivity.java` agar kelas ini fokus menghubungkan `NavController` ke `BottomNavigationView` via `NavigationUI.setupWithNavController()`. | Menekan tab Menu dan Skor Terbaik di bilah navigasi bawah langsung mengganti fragment secara otomatis. |
| **1.3.3** | Buat kelas `KonfirmasiKeluarDialogFragment.java` dan pasang di `OnBackPressedCallback` | `MainActivity.java` belum memiliki penanganan tombol kembali khusus; dialog hanya berupa `AlertDialog` biasa di `tampilkanRingkasan()`. | Membuat `KonfirmasiKeluarDialogFragment extends DialogFragment` dengan `MaterialAlertDialogBuilder`, lalu memasangnya pada `OnBackPressedCallback` di `MainActivity.java`. | Menekan tombol *Back* di layar utama memunculkan pop-up konfirmasi keluar; "Keluar" menutup aplikasi dan "Batal" menutup dialog. |

---

### Paket Kerja 2.0: Pengembangan Layar Menu & Alur Kuis (Anggota 2\)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan |
| :---- | :---- | :---- | :---- | :---- |
| **2.1.1** | Pindahkan desain layout menu lama ke `fragment_menu.xml` | Belum ada layout menu terpisah; pemilih level (`radioGroupLevel` berisi `radioEasy`, `radioMedium`, `radioDifficult`) menempel langsung di `activity_main.xml`. | Membuat `fragment_menu.xml` sebagai beranda yang memuat judul aplikasi, pilihan tingkat kesulitan (`RadioGroup`), dan tombol "Mulai Kuis", serta menyiapkan `fragment_quiz.xml`. | Tampilan `fragment_menu.xml` terpisah bersih dari komponen timer/soal dan siap dijadikan halaman awal aplikasi. |
| **2.2.1** | Buat kelas `MenuFragment.java` dan pindahkan inisialisasi UI ke `onViewCreated` | Seluruh `findViewById` dan `setOnCheckedChangeListener` berada di dalam metode `onCreate()` milik `MainActivity.java`. | Membuat `MenuFragment.java` yang memuat layout di `onCreateView()`, lalu memindahkan `view.findViewById()` dan listener ke `onViewCreated()` (serta merapikan logika kuis ke `QuizFragment.java`). | Tidak terjadi `NullPointerException` saat membuka tab Menu maupun saat berpindah antar-tab berulang kali. |
| **2.2.2** | Ganti konteks `this` menjadi `requireContext()` dan sambungkan aksi tombol menu | `MainActivity.java` memakai konteks `this` (`LinearLayoutManager(this)`, `Intent(this, ...)`) dan kunci `"LEVEL"` yang tidak seragam dengan `RingkasanHasil.java` (`"Level"`). | Mengganti `this` menjadi `requireContext()`, menyeragamkan kunci parameter menjadi `"KEY_LEVEL"`, dan menggunakan `Navigation.findNavController(view).navigate(...)` menuju `QuizFragment`. | Memilih level Easy/Medium/Difficult di `MenuFragment` dan menekan tombol mulai membuka layar kuis dengan bank soal sesuai level. |
| **2.3.1** | Daftarkan `MenuFragment` sebagai `startDestination` di `nav_graph.xml` | `MainActivity` langsung memanggil `letsPlay()` saat aplikasi dibuka sehingga pengguna langsung masuk ke soal tanpa menu. | Mendaftarkan `<fragment android:id="@+id/menuFragment" ... />` beserta aksi menuju `QuizFragment`, lalu mengatur `app:startDestination="@id/menuFragment"` di `nav_graph.xml`. | Saat aplikasi dijalankan pertama kali, layar yang tampil adalah `MenuFragment` dengan ikon Menu aktif di `BottomNavigationView`. |

---

### Paket Kerja 3.0: Pengembangan Layar Skor Terbaik & Detail Kata (Anggota 3\)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan |
| :---- | :---- | :---- | :---- | :---- |
| **3.1.1** | Pindahkan desain layout skor lama ke `fragment_skor_terbaik.xml` | Tampilan skor hanya ada di `activity_ringkasan_hasil.xml` yang memuat `judulHasil`, `ringkasan` sesi berjalan, `ListView` `listSalah`, dan `btnMainLagi`. | Membuat `fragment_skor_terbaik.xml` berisi tampilan rekor skor tertinggi tiap level (Easy, Medium, Difficult) serta daftar kosakata yang dapat diklik untuk melihat rinciannya. | Seluruh elemen di `fragment_skor_terbaik.xml` tampil proporsional di atas `BottomNavigationView` tanpa terpotong. |
| **3.2.1** | Buat kelas `SkorTerbaikFragment.java` dan pindahkan pembacaan data skor ke `onViewCreated` | `RingkasanHasil.java` hanya membaca skor sementara dari `getIntent()` dan belum menyimpan skor secara permanen maupun mengisi `listSalah`. | Menyimpan rekor skor ke `SharedPreferences` saat sesi kuis selesai, lalu membuat `SkorTerbaikFragment.java` untuk membaca skor dan riwayat kata via `requireContext()` di `onViewCreated()`. | Data skor tertinggi tetap tersimpan meskipun aplikasi ditutup dan dibuka kembali, serta tampil rapi di `SkorTerbaikFragment`. |
| **3.3.1** | Buat layout `bottom_sheet_detail_kata.xml` untuk menampilkan rincian kata | Belum ada layout panel bawah; kosakata dari `vocab_easy.txt`, `vocab_medium.txt`, dan `vocab_difficult.txt` hanya tampil sekilas saat kuis berlangsung. | Membuat `bottom_sheet_detail_kata.xml` berisi komponen `TextView` untuk kata, arti/definisi dari `vocab_*.txt`, dan label level dengan palet warna dari `colors.xml` serta gaya `Theme.Material3`. | Panel *bottom sheet* muncul dengan sudut membulat khas Material 3 dan seluruh rincian kata terbaca jelas. |
| **3.3.2** | Buat kelas `DetailKataBottomSheet.java` menggunakan `Bundle` untuk menerima data kata | Pasangan kata dan artinya yang dijawab salah hanya digabung menjadi satu string `"soal + \": \" + benar"` di dalam `listsalah` pada `MainActivity.java`. | Membuat `DetailKataBottomSheet extends BottomSheetDialogFragment` dengan `newInstance(String kata, String arti, String level)` yang menyimpan data ke `Bundle` dan menampilkannya di `onViewCreated()`. | `DetailKataBottomSheet` menampilkan kata dan arti secara dinamis sesuai item yang dipilih dan aman terhadap perubahan orientasi layar. |
| **3.3.3** | Pasang listener klik pada item kata untuk menampilkan `DetailKataBottomSheet` | Komponen `listSalah` di `activity_ringkasan_hasil.xml` belum terhubung ke adapter maupun `OnItemClickListener` di `RingkasanHasil.java`. | Memasang adapter dan listener klik pada daftar kata di `SkorTerbaikFragment` untuk memanggil `DetailKataBottomSheet.newInstance(...).show(getParentFragmentManager(), "DetailKata")`. | Menekan item kata pada daftar langsung memunculkan `DetailKataBottomSheet` dari bawah layar berisi arti kata tersebut. |
| **3.4.1** | Daftarkan `SkorTerbaikFragment` di `nav_graph.xml` sesuai ID di `bottom_nav_menu.xml` | `RingkasanHasil` merupakan `Activity` terpisah yang dibuka dengan `Intent` dan ditutup menggunakan `finish()`. | Mendaftarkan `<fragment android:id="@+id/skorTerbaikFragment" ... />` di `nav_graph.xml` dengan `android:id` yang identik dengan item kedua di `bottom_nav_menu.xml`. | Menekan tab Skor Terbaik di `BottomNavigationView` langsung membuka `SkorTerbaikFragment` dan memindahkan indikator tab aktif. |

---

### Paket Kerja 4.0: Integrasi & Pengujian Aplikasi (Semua Anggota)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan |
| :---- | :---- | :---- | :---- | :---- |
| **4.1.1** | Merge hasil kerja Anggota 1, 2, dan 3 lalu cek kesesuaian seluruh ID XML | Terdapat deklarasi manual `<item name="judulHasil" type="id" />` di `ids.xml` serta perbedaan kunci `"LEVEL"` vs `"Level"` antara `MainActivity.java` dan `RingkasanHasil.java`. | Menggabungkan kode seluruh anggota, menghapus ID yatim di `ids.xml`, menyamakan seluruh kunci `Bundle`/`SharedPreferences`, dan memverifikasi kecocokan ID menu dan `nav_graph.xml`. | Proyek berhasil dibangun tanpa konflik *merge* maupun error `Duplicate resources` / `Cannot resolve symbol`. |
| **4.2.1** | Uji perpindahan tab Bottom Navigation, kemunculan detail kata, dan dialog keluar | Aplikasi belum diuji dalam arsitektur *single-activity* berbasis fragment dan dialog dinamis. | Menguji alur penuh: perpindahan tab Menu ↔ Skor Terbaik, jalannya kuis dan penyimpanan skor, klik item kata untuk `DetailKataBottomSheet`, serta tombol Back untuk `KonfirmasiKeluarDialogFragment`. | Seluruh fitur berjalan stabil tanpa *force close*, kebocoran `CountDownTimer`, atau data skor yang hilang. |

---

## 4\. Kesepakatan Standar Teknis Tim

Untuk mencegah bug saat penggabungan kode pada tahap 4.1.1, seluruh anggota wajib mematuhi konvensi penamaan berikut:

1. **ID Navigasi Wajib Identik (`bottom_nav_menu.xml` & `nav_graph.xml`):**  
   * Tab Menu: `@+id/menuFragment`  
   * Tab Skor Terbaik: `@+id/skorTerbaikFragment`  
2. **Konstanta Kunci `Bundle` & `SharedPreferences`:**  
   * Nama Preference: `"PREF_VOCAB_QUIZ"`  
   * Kunci Level: `"KEY_LEVEL"` *(nilai: `"Easy"`, `"Medium"`, `"Difficult"`)*  
   * Kunci Kata & Arti: `"KEY_KATA"` dan `"KEY_ARTI"`  
   * Kunci Skor Tertinggi: `"HIGH_SCORE_EASY"`, `"HIGH_SCORE_MEDIUM"`, `"HIGH_SCORE_DIFFICULT"`  
3. **Pembersihan Resource Lama:**  
   * Hapus `<item name="judulHasil" type="id" />` dari `res/values/ids.xml` setelah `RingkasanHasil` selesai dimigrasi ke fragment.
