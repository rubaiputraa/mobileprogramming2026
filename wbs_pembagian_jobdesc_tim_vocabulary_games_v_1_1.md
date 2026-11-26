# Dokumen Perencanaan & WBS: Implementasi Dynamic UI

**Proyek:** Aplikasi Kuis Kosakata (**Vocabulary Games v.1.1**)  
**Target Waktu:** 3 Minggu (+1 Minggu sebagai waktu cadangan)  
**Jumlah Tim:** 3 Orang  
**Anggota Tim:**
- **Anggota 1:** Imam Rubai Putra (312410009)
- **Anggota 2:** Muhammad Anggoro Binadro (312410017)
- **Anggota 3:** Jeremy Marcellino Limantoro (312410010)

---

## 1. Pembagian Peran & Tanggung Jawab Tim

Agar pengerjaan berjalan paralel tanpa saling menghambat dan menghindari konflik kode pada berkas yang sama, tanggung jawab dibagi secara merata pada Fase 1 (*Refactor Single-Activity*) maupun Fase 2 (*Pembaruan Vocabulary Games v.1.1 & Fitur Revisi Dosen*):

| Anggota | Peran | Fokus Fitur (Fase 1 & Fase 2) | Berkas Tanggung Jawab |
| :---- | :---- | :---- | :---- |
| **Anggota 1** *(Imam Rubai Putra)* | *Core Architecture, Exit Dialog & Credit Fragment* | **Fase 1:** Setup Navigation Component, `BottomNavigationView`, `MainActivity`, & `KonfirmasiKeluarDialogFragment`.<br>**Fase 2:** Pembaruan identitas **Vocabulary Games v.1.1**, perluasan navigasi 3 tab (`Menu Utama – Skor Terbaik – Credit`), dan pembuatan halaman `CreditFragment` (profil tim & catatan developer). | `build.gradle.kts`, `strings.xml`, `bottom_nav_menu.xml`, `nav_graph.xml`, `activity_main.xml`, `MainActivity.java`, `KonfirmasiKeluarDialogFragment.java`, `fragment_credit.xml`, `CreditFragment.java` |
| **Anggota 2** *(Muhammad Anggoro Binadro)* | *Menu Flow, Quiz Logic, Player Identity, Timer & About Sheet* | **Fase 1:** Layar beranda `MenuFragment` & migrasi logika permainan ke `QuizFragment`.<br>**Fase 2:** Lencana versi **v.1.1** & input nama pemain pada beranda, pencatatan total waktu pengerjaan kuis, sinkronisasi `RingkasanHasil`, serta panel bawah dinamis `AboutBottomSheet` (Tentang Permainan). | `fragment_menu.xml`, `MenuFragment.java`, `fragment_quiz.xml`, `QuizFragment.java`, `RingkasanHasil.java`, `bottom_sheet_about.xml`, `AboutBottomSheet.java` |
| **Anggota 3** *(Jeremy Marcellino Limantoro)* | *High Score Leaderboard, Word Detail & Reset Feature* | **Fase 1:** `SkorTerbaikFragment` dengan penyimpanan permanen & `DetailKataBottomSheet`.<br>**Fase 2:** Tampilan pemegang rekor (`100 — oleh [Nama]`) beserta catatan waktu di `SkorTerbaikFragment`, serta fitur **Reset** dengan `KonfirmasiResetDialogFragment`. | `fragment_skor_terbaik.xml`, `SkorTerbaikFragment.java`, `bottom_sheet_detail_kata.xml`, `DetailKataBottomSheet.java`, `KonfirmasiResetDialogFragment.java` |

---

## 2. Jadwal Pengerjaan (Timeline 3 Minggu)

| Periode | Kode WBS | Fokus Pengerjaan | PIC | Target Capaian |
| :---- | :---- | :---- | :---- | :---- |
| **Minggu 1** (Hari 1–2) | 1.1 – 1.2 | Setup dependensi `build.gradle`, pembuatan `bottom_nav_menu.xml`, dan kerangka `nav_graph.xml` | Anggota 1 | Fondasi navigasi proyek siap digunakan oleh seluruh tim |
| **Minggu 1** (Hari 3–4) | 1.3, 2.1, 3.1 | Anggota 1 merombak `MainActivity` & membuat `KonfirmasiKeluarDialogFragment`; Anggota 2 & 3 menyiapkan layout XML fragment | Semua Anggota *(Paralel)* | Wadah navigasi utama dan seluruh tata letak XML fragment selesai |
| **Minggu 1** (Hari 5–7) | 2.2, 3.2 | Migrasi logika Java ke `MenuFragment`, `QuizFragment`, dan `SkorTerbaikFragment` serta penyesuaian konteks `requireContext()` | Anggota 2 & 3 | Seluruh halaman utama berjalan dalam bentuk Fragment |
| **Minggu 2** (Hari 8–10) | 3.3, 2.3, 3.4 | Pembuatan `DetailKataBottomSheet` + layoutnya, serta pendaftaran rute destinasi ke `nav_graph.xml` | Anggota 2 & 3 *(Anggota 1 review graph)* | Seluruh fitur Dynamic UI dasar selesai diimplementasikan |
| **Minggu 2** (Hari 11–14) | 4.1 – 4.2 | Penggabungan kode (*merge*), pembersihan resource ID, dan pengujian alur dasar | Semua Anggota | Fase 1 terintegrasi tanpa error kompilasi |
| **Minggu 3** (Hari 15–17) | 5.1, 5.2, 5.3 | **Fase 2 (Vocabulary Games v.1.1):** Anggota 1 membuat `CreditFragment` & tab ke-3; Anggota 2 membuat input nama, catatan waktu pengerjaan, & `AboutBottomSheet`; Anggota 3 membuat tampilan rekor lengkap & fitur Reset | Semua Anggota *(Paralel)* | Kelima fitur tambahan dan pembaruan versi 1.1 terpasang pada masing-masing modul |
| **Minggu 3** (Hari 18–21) | 5.4 *(Buffer)* | Penggabungan akhir Fase 2, penyamaan kunci `SharedPreferences`, serta pengujian penuh seluruh alur Dynamic UI | Semua Anggota | Aplikasi stabil, bebas bug, dan siap dipresentasikan ke dosen |

---

## 3. Work Breakdown Structure (WBS) Detail: Sebelum vs Sesudah

### Paket Kerja 1.0: Inisiasi & Setup Fondasi Navigasi (Anggota 1)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Awal)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **1.1.1** | Tambah library Navigation Component dan Material Design di `build.gradle` | Tema aplikasi di `themes.xml` sudah memakai `Theme.Material3.DayNight.NoActionBar`, namun `build.gradle` belum memasang dependensi Navigation Component. | Menambahkan `androidx.navigation:navigation-fragment` dan `androidx.navigation:navigation-ui` pada blok `dependencies` di `build.gradle` tingkat modul. | Pustaka `NavHostFragment`, `NavController`, dan `NavigationUI` dapat diimpor di Java tanpa error kompilasi. | Selesai |
| **1.1.2** | Sinkronisasi Gradle dan pastikan tidak ada konflik versi | Konfigurasi proyek baru memuat library standar untuk `AppCompatActivity`, `RecyclerView`, dan `MaterialCardView`. | Menjalankan *Sync Now* di Android Studio serta menyelaraskan versi AGP dan `compileSdk` dengan pustaka Navigation. | Proses *Gradle Sync* dan *Build Project* selesai sukses tanpa konflik versi dependensi. | Selesai |
| **1.2.1** | Buat item menu bawah di `res/menu/bottom_nav_menu.xml` | Belum ada direktori `res/menu`, dan `strings.xml` baru berisi `<string name="app_name">My Application</string>`. | Menambahkan string judul tab di `strings.xml`, lalu membuat `res/menu/bottom_nav_menu.xml` berisi `@+id/menuFragment` dan `@+id/skorTerbaikFragment`. | File XML menu valid dan ID kedua item sudah disepakati bersama Anggota 2 dan Anggota 3. | Selesai |
| **1.2.2** | Buat kerangka awal `res/navigation/nav_graph.xml` | Perpindahan layar dilakukan secara manual menggunakan `Intent(this, RingkasanHasil.class)` di dalam `MainActivity.java`. | Membuat `res/navigation/nav_graph.xml` sebagai peta navigasi terpusat yang memuat destinasi `MenuFragment`, `QuizFragment`, dan `SkorTerbaikFragment`. | Tab *Design* dan *Code* pada `nav_graph.xml` terbuka normal tanpa error referensi kelas atau layout. | Selesai |
| **1.3.1** | Ubah `activity_main.xml` menjadi wadah `FragmentContainerView` dan `BottomNavigationView` | `activity_main.xml` berisi komponen tampilan kuis (`skor`, `waktu`, `radioGroupLevel`, `vocab`, `hasil`, `RecyclerView` `opsi`, dan `tombolBerikutnya`). | Memindahkan seluruh elemen UI kuis ke `fragment_quiz.xml`, lalu mengganti isi `activity_main.xml` menjadi `FragmentContainerView` (`NavHostFragment`) dan `BottomNavigationView`. | Preview `activity_main.xml` menampilkan wadah fragment di atas dan bilah navigasi bawah menempel rapi di bawah layar. | Selesai |
| **1.3.2** | Hubungkan `NavController` ke `BottomNavigationView` di `MainActivity.java` | `MainActivity.java` menjalankan logika permainan kuis, `OpsiAdapter`, pembacaan `R.raw.vocab_*`, dan `CountDownTimer`. | Memindahkan logika kuis keluar dari `MainActivity.java` agar kelas ini fokus menghubungkan `NavController` ke `BottomNavigationView` via `NavigationUI.setupWithNavController()`. | Menekan tab Menu dan Skor Terbaik di bilah navigasi bawah langsung mengganti fragment secara otomatis. | Selesai |
| **1.3.3** | Buat kelas `KonfirmasiKeluarDialogFragment.java` dan pasang di `OnBackPressedCallback` | `MainActivity.java` belum memiliki penanganan tombol kembali khusus; dialog hanya berupa `AlertDialog` biasa di `tampilkanRingkasan()`. | Membuat `KonfirmasiKeluarDialogFragment extends DialogFragment` dengan `MaterialAlertDialogBuilder`, lalu memasangnya pada `OnBackPressedCallback` di `MainActivity.java`. | Menekan tombol *Back* di layar utama memunculkan pop-up konfirmasi keluar; "Keluar" menutup aplikasi dan "Batal" menutup dialog. | Selesai |

---

### Paket Kerja 2.0: Pengembangan Layar Menu & Alur Kuis (Anggota 2)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Awal)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **2.1.1** | Pindahkan desain layout menu lama ke `fragment_menu.xml` | Belum ada layout menu terpisah; pemilih level (`radioGroupLevel` berisi `radioEasy`, `radioMedium`, `radioDifficult`) menempel langsung di `activity_main.xml`. | Membuat `fragment_menu.xml` sebagai beranda yang memuat judul aplikasi, pilihan tingkat kesulitan (`RadioGroup`), dan tombol "Mulai Kuis", serta menyiapkan `fragment_quiz.xml`. | Tampilan `fragment_menu.xml` terpisah bersih dari komponen timer/soal dan siap dijadikan halaman awal aplikasi. | Selesai |
| **2.2.1** | Buat kelas `MenuFragment.java` dan pindahkan inisialisasi UI ke `onViewCreated` | Seluruh `findViewById` dan `setOnCheckedChangeListener` berada di dalam metode `onCreate()` milik `MainActivity.java`. | Membuat `MenuFragment.java` yang memuat layout di `onCreateView()`, lalu memindahkan `view.findViewById()` dan listener ke `onViewCreated()` (serta merapikan logika kuis ke `QuizFragment.java`). | Tidak terjadi `NullPointerException` saat membuka tab Menu maupun saat berpindah antar-tab berulang kali. | Selesai |
| **2.2.2** | Ganti konteks `this` menjadi `requireContext()` dan sambungkan aksi tombol menu | `MainActivity.java` memakai konteks `this` (`LinearLayoutManager(this)`, `Intent(this, ...)`) dan kunci `"LEVEL"` yang tidak seragam dengan `RingkasanHasil.java` (`"Level"`). | Mengganti `this` menjadi `requireContext()`, menyeragamkan kunci parameter menjadi `"KEY_LEVEL"`, dan menggunakan `Navigation.findNavController(view).navigate(...)` menuju `QuizFragment`. | Memilih level Easy/Medium/Difficult di `MenuFragment` dan menekan tombol mulai membuka layar kuis dengan bank soal sesuai level. | Selesai |
| **2.3.1** | Daftarkan `MenuFragment` sebagai `startDestination` di `nav_graph.xml` | `MainActivity` langsung memanggil `letsPlay()` saat aplikasi dibuka sehingga pengguna langsung masuk ke soal tanpa menu. | Mendaftarkan `<fragment android:id="@+id/menuFragment" ... />` beserta aksi menuju `QuizFragment`, lalu mengatur `app:startDestination="@id/menuFragment"` di `nav_graph.xml`. | Saat aplikasi dijalankan pertama kali, layar yang tampil adalah `MenuFragment` dengan ikon Menu aktif di `BottomNavigationView`. | Selesai |

---

### Paket Kerja 3.0: Pengembangan Layar Skor Terbaik & Detail Kata (Anggota 3)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Awal)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **3.1.1** | Pindahkan desain layout skor lama ke `fragment_skor_terbaik.xml` | Tampilan skor hanya ada di `activity_ringkasan_hasil.xml` yang memuat `judulHasil`, `ringkasan` sesi berjalan, `ListView` `listSalah`, dan `btnMainLagi`. | Membuat `fragment_skor_terbaik.xml` berisi tampilan rekor skor tertinggi tiap level (Easy, Medium, Difficult) serta daftar kosakata yang dapat diklik untuk melihat rinciannya. | Seluruh elemen di `fragment_skor_terbaik.xml` tampil proporsional di atas `BottomNavigationView` tanpa terpotong. | Selesai |
| **3.2.1** | Buat kelas `SkorTerbaikFragment.java` dan pindahkan pembacaan data skor ke `onViewCreated` | `RingkasanHasil.java` hanya membaca skor sementara dari `getIntent()` dan belum menyimpan skor secara permanen maupun mengisi `listSalah`. | Menyimpan rekor skor ke `SharedPreferences` saat sesi kuis selesai, lalu membuat `SkorTerbaikFragment.java` untuk membaca skor dan riwayat kata via `requireContext()` di `onViewCreated()`. | Data skor tertinggi tetap tersimpan meskipun aplikasi ditutup dan dibuka kembali, serta tampil rapi di `SkorTerbaikFragment`. | Selesai |
| **3.3.1** | Buat layout `bottom_sheet_detail_kata.xml` untuk menampilkan rincian kata | Belum ada layout panel bawah; kosakata dari `vocab_easy.txt`, `vocab_medium.txt`, dan `vocab_difficult.txt` hanya tampil sekilas saat kuis berlangsung. | Membuat `bottom_sheet_detail_kata.xml` berisi komponen `TextView` untuk kata, arti/definisi dari `vocab_*.txt`, dan label level dengan palet warna dari `colors.xml` serta gaya `Theme.Material3`. | Panel *bottom sheet* muncul dengan sudut membulat khas Material 3 dan seluruh rincian kata terbaca jelas. | Selesai |
| **3.3.2** | Buat kelas `DetailKataBottomSheet.java` menggunakan `Bundle` untuk menerima data kata | Pasangan kata dan artinya yang dijawab salah hanya digabung menjadi satu string `"soal + \": \" + benar"` di dalam `listsalah` pada `MainActivity.java`. | Membuat `DetailKataBottomSheet extends BottomSheetDialogFragment` dengan `newInstance(String kata, String arti, String level)` yang menyimpan data ke `Bundle` dan menampilkannya di `onViewCreated()`. | `DetailKataBottomSheet` menampilkan kata dan arti secara dinamis sesuai item yang dipilih dan aman terhadap perubahan orientasi layar. | Selesai |
| **3.3.3** | Pasang listener klik pada item kata untuk menampilkan `DetailKataBottomSheet` | Komponen `listSalah` di `activity_ringkasan_hasil.xml` belum terhubung ke adapter maupun `OnItemClickListener` di `RingkasanHasil.java`. | Memasang adapter dan listener klik pada daftar kata di `SkorTerbaikFragment` untuk memanggil `DetailKataBottomSheet.newInstance(...).show(getParentFragmentManager(), "DetailKata")`. | Menekan item kata pada daftar langsung memunculkan `DetailKataBottomSheet` dari bawah layar berisi arti kata tersebut. | Selesai |
| **3.4.1** | Daftarkan `SkorTerbaikFragment` di `nav_graph.xml` sesuai ID di `bottom_nav_menu.xml` | `RingkasanHasil` merupakan `Activity` terpisah yang dibuka dengan `Intent` dan ditutup menggunakan `finish()`. | Mendaftarkan `<fragment android:id="@+id/skorTerbaikFragment" ... />` di `nav_graph.xml` dengan `android:id` yang identik dengan item kedua di `bottom_nav_menu.xml`. | Menekan tab Skor Terbaik di `BottomNavigationView` langsung membuka `SkorTerbaikFragment` dan memindahkan indikator tab aktif. | Selesai |

---

### Paket Kerja 4.0: Integrasi & Pengujian Awal Aplikasi (Semua Anggota)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Awal)* | Perubahan Sesudah *(Target Dynamic UI)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **4.1.1** | Merge hasil kerja Anggota 1, 2, dan 3 lalu cek kesesuaian seluruh ID XML | Terdapat deklarasi manual `<item name="judulHasil" type="id" />` di `ids.xml` serta perbedaan kunci `"LEVEL"` vs `"Level"` antara `QuizFragment` dan `RingkasanHasil.java`. | Menggabungkan kode seluruh anggota, menghapus ID yatim di `ids.xml`, menyamakan kunci `"KEY_LEVEL"`, dan menambahkan `popBackStack()` sebelum membuka `RingkasanHasil`. | Proyek berhasil dibangun tanpa konflik *merge* maupun error `Duplicate resources` / `Cannot resolve symbol`. | Selesai |
| **4.2.1** | Uji perpindahan tab Bottom Navigation, kemunculan detail kata, dan dialog keluar | Aplikasi belum diuji dalam arsitektur *single-activity* berbasis fragment dan dialog dinamis. | Menguji alur penuh: perpindahan tab Menu ↔ Skor Terbaik, jalannya kuis dan penyimpanan skor, klik item kata untuk `DetailKataBottomSheet`, serta tombol Back untuk `KonfirmasiKeluarDialogFragment`. | Seluruh fitur berjalan stabil tanpa *force close*, kebocoran `CountDownTimer`, atau data skor yang hilang. | Selesai |

---

### Paket Kerja 5.0: Implementasi Fitur Tambahan & Pembaruan Vocabulary Games v.1.1 (Semua Anggota)

#### Sub-Paket 5.1: Branding v.1.1, Navigasi 3 Tab, & Halaman Credit Pengembang (Anggota 1 — Imam Rubai Putra)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Fitur Dosen)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **5.1.1** | Perbarui nama & versi ke **Vocabulary Games v.1.1** serta tambah tab ketiga **Credit** | `app_name` di `strings.xml` belum mencantumkan identitas **Vocabulary Games v.1.1**, `versionName` di `build.gradle.kts` masih `"1.0"`, dan `BottomNavigationView` baru memiliki 2 item menu (`menuFragment` dan `skorTerbaikFragment`). | Mengubah `app_name` di `strings.xml` menjadi `Vocabulary Games v.1.1`, memperbarui `versionName = "1.1"` di `build.gradle.kts`, menambah `<string name="nav_credit">Credit</string>`, dan mendaftarkan `<item android:id="@+id/creditFragment" ... />` di `bottom_nav_menu.xml`. | Identitas aplikasi tampil sebagai **Vocabulary Games v.1.1** dan bilah navigasi bawah menampilkan 3 tab sejajar: **Menu Utama**, **Skor Terbaik**, dan **Credit**. | |
| **5.1.2** | Buat layout `fragment_credit.xml` dan kelas `CreditFragment.java` | Belum terdapat halaman khusus yang memuat identitas tim pembuat aplikasi maupun catatan pengembangan versi 1.1. | Membuat `fragment_credit.xml` (memuat tajuk **Vocabulary Games v.1.1**, kartu profil 3 anggota tim beserta NIM, peran pembagian tugas, dan catatan pembaruan developer) serta kelas `CreditFragment extends Fragment`. | Tampilan `CreditFragment` tersusun rapi dengan komponen Material 3 dan terbaca jelas di atas `BottomNavigationView`. | |
| **5.1.3** | Daftarkan `CreditFragment` di `nav_graph.xml` dan atur visibilitas tab saat kuis | `nav_graph.xml` baru memuat 3 destinasi (`menuFragment`, `quizFragment`, `skorTerbaikFragment`) dan bilah bawah tetap terlihat saat kuis berlangsung. | Menambahkan `<fragment android:id="@+id/creditFragment" ... />` di `nav_graph.xml` dengan ID identik dengan menu bawah, serta menyembunyikan `BottomNavigationView` (`View.GONE`) saat pengguna berada di `QuizFragment`. | Menekan tab **Menu Utama – Skor Terbaik – Credit** langsung mengganti *Fragment* secara dinamis dan bilah bawah tidak mengganggu layar kuis. | |

#### Sub-Paket 5.2: Input Nama Pemain, Catatan Waktu Pengerjaan, & Fitur About (Anggota 2 — Muhammad Anggoro Binadro)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Fitur Dosen)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **5.2.1** | Tambahkan lencana versi **v.1.1** dan kolom input nama pemain pada `fragment_menu.xml` & `MenuFragment.java` | `MenuFragment` hanya memiliki pemilih level (`RadioGroup`) dan tombol mulai, sehingga sistem tidak mengetahui siapa pemain yang mencetak rekor skor. | Menampilkan judul **Vocabulary Games v.1.1**, menambahkan `TextInputLayout` / `EditText` nama pemain pada `fragment_menu.xml`, memvalidasi agar nama tidak kosong (atau memakai default `"Anonim"`), lalu mengirimnya ke `QuizFragment` via `Bundle` (`"KEY_NAMA"`). | Nama pemain berhasil dikirim dari `MenuFragment` menuju `QuizFragment` setiap kali sesi kuis dimulai. | |
| **5.2.2** | Hitung total waktu pengerjaan kuis dan simpan nama serta durasi rekor di `QuizFragment.java` | `QuizFragment` memiliki `CountDownTimer` 15 detik per soal, namun total waktu penyelesaian seluruh soal dalam satu sesi belum dihitung maupun disimpan. | Mencatat akumulasi waktu pengerjaan (dalam detik) dari soal pertama hingga selesai, mengirim `"KEY_NAMA"` dan `"WAKTU_PENGERJAAN"` ke `RingkasanHasil`, serta memperbarui nama pemegang rekor & waktu terbaik di `SharedPreferences` saat skor lebih tinggi (atau skor sama dengan waktu lebih cepat). | `RingkasanHasil` menampilkan nama pemain dan total detik pengerjaan, serta `SharedPreferences` menyimpan identitas pemegang rekor secara akurat. | |
| **5.2.3** | Buat fitur **About / Tentang Permainan** menggunakan `AboutBottomSheet.java` | Belum ada panduan cara bermain, aturan waktu, informasi versi **v.1.1**, maupun penjelasan tingkat kesulitan di dalam aplikasi. | Membuat `bottom_sheet_about.xml` dan `AboutBottomSheet extends BottomSheetDialogFragment` (berisi informasi **Vocabulary Games v.1.1**, cara bermain, aturan waktu 15 detik/soal, dan penjelasan level), lalu memasang tombol/ikon **Tentang Permainan** di `MenuFragment`. | Menekan tombol **Tentang Permainan** di menu utama memunculkan panel bawah dinamis berisi aturan kuis dan info versi tanpa keluar dari `MenuFragment`. | |

#### Sub-Paket 5.3: Tampilan Pemegang Rekor, Catatan Waktu, & Fitur Reset (Anggota 3 — Jeremy Marcellino Limantoro)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Fitur Dosen)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **5.3.1** | Perbarui `fragment_skor_terbaik.xml` dan `SkorTerbaikFragment.java` untuk menampilkan nama & waktu | Halaman `SkorTerbaikFragment` hanya menampilkan teks angka skor (`Easy: 100`) tanpa keterangan siapa pemegang rekornya dan berapa lama waktu pengerjaannya. | Membaca kunci nama (`NAMA_EASY/MEDIUM/DIFFICULT`) dan waktu (`WAKTU_EASY/MEDIUM/DIFFICULT`) dari `SharedPreferences`, lalu menampilkannya dalam format informatif seperti `Easy: 100 — oleh Rubai (18 detik)` (atau `Belum ada rekor` jika masih 0). | Setiap tingkat kesulitan di `SkorTerbaikFragment` menampilkan skor tertinggi beserta pemilik rekor dan catatan waktu pengerjaannya. | |
| **5.3.2** | Tambahkan tombol **Reset** dan dialog konfirmasi `KonfirmasiResetDialogFragment.java` | Pengguna tidak memiliki cara menghapus rekor skor maupun daftar riwayat kosakata salah dari dalam aplikasi. | Menambahkan tombol **Reset Data** di `fragment_skor_terbaik.xml` dan membuat `KonfirmasiResetDialogFragment extends DialogFragment` dengan `MaterialAlertDialogBuilder` yang menghapus seluruh data skor, nama, waktu, dan `RIWAYAT_KATA` dari `SharedPreferences` serta menyegarkan tampilan layar secara langsung. | Menekan tombol **Reset Data** memunculkan dialog konfirmasi dinamis; jika dikonfirmasi, seluruh rekor kembali ke `0` dan daftar kosakata langsung kosong. | |

#### Sub-Paket 5.4: Integrasi & Pengujian Fitur Tambahan (Semua Anggota)

| Kode WBS | Aktivitas | Kondisi Sebelum *(Kode Saat Ini)* | Perubahan Sesudah *(Target Fitur Dosen)* | Validasi Tujuan | Status |
| :---- | :---- | :---- | :---- | :---- | :----: |
| **5.4.1** | Integrasi modul 5.1 – 5.3 dan pengujian alur lengkap **Vocabulary Games v.1.1** | Kelima fitur tambahan dikerjakan terpisah oleh Anggota 1, 2, dan 3. | Melakukan *merge* seluruh cabang ke repositori utama dan menguji skenario: cek versi **v.1.1** → input nama → buka About → main kuis & cek waktu di `RingkasanHasil` → cek nama & waktu di `SkorTerbaikFragment` → klik detail kata → buka tab `Credit` → jalankan fitur `Reset`. | Seluruh fitur berjalan sinkron tanpa error kompilasi, *force close*, maupun ketidaksesuaian kunci `SharedPreferences`. | |

---

## 4. Kesepakatan Standar Teknis Tim

Untuk mencegah bug saat penggabungan kode pada tahap 5.4.1, seluruh anggota wajib mematuhi konvensi penamaan berikut:

1. **Identitas & Versi Aplikasi:**
   * Nama Resmi Aplikasi: `Vocabulary Games v.1.1`
   * Versi Gradle (`build.gradle.kts`): `versionName = "1.1"`
2. **ID Navigasi Wajib Identik (`bottom_nav_menu.xml` & `nav_graph.xml`):**
   * Tab 1 — Menu Utama: `@+id/menuFragment`
   * Tab 2 — Skor Terbaik: `@+id/skorTerbaikFragment`
   * Tab 3 — Credit: `@+id/creditFragment`
3. **Konstanta Kunci `Bundle` & `Intent`:**
   * Kunci Level: `"KEY_LEVEL"` *(nilai: `"Easy"`, `"Medium"`, `"Difficult"`)*
   * Kunci Nama Pemain: `"KEY_NAMA"`
   * Kunci Waktu Pengerjaan Sesi: `"WAKTU_PENGERJAAN"` *(tipe `int` / `long`, satuan detik)*
   * Kunci Skor `RingkasanHasil`: `"JUMLAH_BENAR"`, `"JUMLAH_SALAH"`, `"JUMLAH_SOAL"`, `"DAFTAR_SALAH"`
4. **Konstanta Kunci `SharedPreferences` (Nama Preference: `"PREF_SKOR_TERBAIK"`):**
   * Skor Tertinggi: `"SKOR_EASY"`, `"SKOR_MEDIUM"`, `"SKOR_DIFFICULT"`
   * Pemegang Rekor: `"NAMA_EASY"`, `"NAMA_MEDIUM"`, `"NAMA_DIFFICULT"`
   * Catatan Waktu Rekor: `"WAKTU_EASY"`, `"WAKTU_MEDIUM"`, `"WAKTU_DIFFICULT"`
   * Riwayat Kata Salah: `"RIWAYAT_KATA"` *(format item: `"kata: arti|level"`)*