
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
| 20/11/2026 | Jeremy | Membuat Layout fragment_skor_terbaik.xml dengan layout height 0dp | Menggunakan tinggil 0dp (constraint layout), sehingga daftar kosakata menumpuk | Membuat Fragment untuk bagian Skor terbaik dan memindah kode pembacaan data ke onViewCreated |
| 20/11/2026 | Jeremy | Membuat kelas SkorTerbaikFragment.java dan memindahkan pembacaan data ke onViewCreated | Perlu adanya requireContext() pada onViewCreated agar tidak memicu NullPointerException saat perpindahan tab | Membuat layout bottom_sheet untuk menampilkan rincian kata |
| 20/11/2026 | Jeremy | Membuat layout bottom_sheet_detail_kata.xml untuk menampikan rincian dari kata | Pewarnaan masih memakai token tema material 3, agar selaras dengan colors.xml tanpa adanya error referensi warna yang belum didefinisikan | Membuat kelas DetailKataBottomSheet menggunakan Bundle |
| 20/11/2026 | Jeremy | Membuat kelas DetailKataBottomSheet.java menggunakan bundle (untuk menerima data) | Bundle wajib memakai newInstance agar aman saat rotasi layar | Menambahkan listener klik pada kata untuk menampilkan detail kata |
| 20/11/2026b | Jeremy | Menambahkan Listener Klik untuk menampilkan DetailKataBottomSheet |  String riwayat perlu dipisah menjadi kata, arti, dan level agar parameter DetailKataBottomSheet terisi lengkap | Kedepannya akan menambahkan SkorTerbaikFragment di nav_graph sesuai ID di bottom_nav_menu.xml |
| 20/11/2026 | Jeremy | Menambah SkorTerbaikFragment di navgraph dan menyesuaikan ID nya di bottom_nav_graph.xml | Atribut pada bottom_nav_menu dan nav_graph akan gagal jika terdapat typo | Menggabungkan kode bersama semua anggota tim |
| 20/11/2026 | Semua Tim | Menggabungkan semua bagian dari tiap tim| Masih terdapat beberapa bug| Memperbaiki bug dan mengevaluasi |
| 26/11/2026 | Rubai | Menambahkan informasi versi v.1.1 apps dan menambahkan informasi credit dibuttom navigation|Tab credit belum bisa dibuka| Mebuat fragment credit dan class credit fragment |
| 26/11/2026 | Rubai | Membuat fragment credit dan class credit fragment|Tab credit masih belum bisa di klik/buka| Memperbaiki supaya tab credit bisa diklik |
| 26/11/2026 | Rubai | Memperbaiki supaya tab credit bisa diklik dengan cara menambahkan syntax di navigation| sempat terjdi error| Menambahkan konfirmasi keluar didalam game untuk menghidari ketidaksengajaan oleh user |
| 26/11/2026 | Rubai | Menambahkan class konfirmasi keluar saat game berjalan untuk menghindari human error pemain| tidak ada | Menambahkan input nama pemain diawal |

