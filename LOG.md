| Tanggal | Nama | Yang dikerjakan | Kendala | Rencana berikutnya |
|---|---|---|---|---|
| 15/11/2026 | Rubai | Membuat repository dan menginvite dosen serta anggota kelompok sebagai kolaborator, menentukan fitur, dan membagi tugas | Tidak ada| Mengerjakan task yang telah dibagi |
| 17/11/2026 | Rubai | Menambahkan library navigasi komponem dan desian material di build.gradle | Tidak ada| Sinkronisasi Gradle dan pastikan tidak ada konflik versi|
| 17/11/2026 | Rubai | Sinkronisasi Gradle dan pastikan tidak ada konflik versi | Menu bar atas tersembunyi sehingga proses build dijalankan melalui ikon palu di toolbar, pintasan Ctrl + F9| Buat item menu bottom_nav_menu.xml|
| 17/11/2026 | Rubai | Buat item menu bottom_nav_menu.xml | Direktori menu belum tersedia sehingga perlu dibuat terlebih dahulu|Buat kerangka awal navigation nav_graph.xml|
| 17/11/2026 | Rubai | Buat kerangka awal navigation nav_graph.xml | Tidak ada |Ubah activity_main.xml menjadi wadah FragmentContainerView dan BottomNavigationView|
| 18/11/2026 | Rubai | Mengubah activity_main.xml menjadi wadah FragmentContainerView dan BottomNavigationView | Saat dijalankan aplikasi terforce close |Buat kelas KonfirmasiKeluarDialogFragment.java dan pasang di OnBackPressedCallback|
| 19/11/2026 | Rubai | Membuat kelas KonfirmasiKeluarDialogFragment.java dan pasang di OnBackPressedCallback | aplikasi masih terforce close |memindahkan desain layout menu lama ke fragment_menu.xml |
| 19/11/2026 | Aang | memindahkan desain layout menu lama ke fragment_menu.xml | Referensi action di MenuFragment masih merah karena belum didaftarkan pada nav_graph.xml | membuat kelas MenuFragment dan memindahkan inisialisasi UI ke onViewCreated |
| 19/11/2026 | Aang | membuat kelas MenuFragment dan memindahkan inisialisasi UI ke onViewCreated | Pemanggilan findViewByid dan konteks Activity wajib diubah ke view.findViewByid serta requireContext di onViewcreated agar tidak NullPointterException | Mengganti konteks this menjadi requireContext dan menyambungkan tombol menu |
| 20/11/2026 | Aang | Mengganti konteks this menjadi requireContext dan menyambungkan tombol menu | Perbedaan nam kunc parameter antar kelas beresiko menyebabkan nilai level bernilai null jika tidak diseragamkan menjadi KEY_LEVEL | Mendaftarkan MenuFragment sebagai startDestination di nav_graph.xml |
| 20/11/2026 | Aang | Mendaftarkan MenuFragment sebagai startDestination di nav_graph.xml | ID fragment di nav_graph.xml wajib sama persisi dengan ID item di bottom_nav_menu.xml agar tab aktif secara otomatis | Memindahkan desain layout skor lama ke fragment_skor_terbaik.xml |
| 20/11/2026 | Jeremy | Menambahkan fitur pada menu Skor Terbaik untuk menampilkan skor tertinggi pada local (tidak tersimpan di database) |
| 20/11/2026 | Semua Tim |Menggabungkan semua bagian dari tiap tim| Masih terdapat beberapa bug| Memperbaiki bug dan mengevaluasi |
