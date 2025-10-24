## Identitas
| Keterangan | Data |
|-------------|------|
| **Nama** | Bunga Devina Firdaus |
| **NIM** | H1D023051 |
| **Shift Asal** | Shift A |
| **Shift Baru** | Shift D |

## Demo Aplikasi
Berikut video demo aplikasi:  
[video demo](https://github.com/user-attachments/assets/3f2d6e8b-9a12-4559-9e87-e4fcc3ca9040)

## Alur Data (Dari API ke Tampilan)
API diperoleh dari football-data.org, setelah itu menggunakan Postman untuk mendapatkan data-datanya menggunakan API Key yang telah terdaftar.

Setelah itu dibuat package utils yang berisi file Constants untuk menyimpan Base URL API dan API Key agar lebih rapi dan mudah digunakan di seluruh proyek.

Kemudian dibuat package network yang berisi dua file penting:
- ApiService, berfungsi untuk mendefinisikan endpoint atau alamat yang akan dipanggil dari API (misalnya mengambil data tim berdasarkan ID).
- RetrofitInstance, digunakan untuk mengatur koneksi API menggunakan library Retrofit, termasuk mengonversi data JSON menjadi objek Kotlin agar bisa diolah di aplikasi.

Selanjutnya, di package model, dibuat file TeamResponse.
Di sini dideklarasikan struktur data yang sesuai dengan file JSON dari API — seperti TeamResponse, Coach, Player, Contract
Model ini berfungsi sebagai wadah data yang diterima dari server agar bisa dibaca dan ditampilkan dengan mudah.

Lalu di package viewmodel, terdapat TeamViewModel yang berfungsi untuk mengolah data dari API sebelum dikirim ke tampilan (UI).
ViewModel inilah yang memanggil fungsi dari RetrofitInstance untuk mengambil data tim dan menyimpannya di LiveData, supaya bisa dipantau dan diperbarui otomatis oleh Activity.

Contoh kasus di fragment Player:
Untuk menampilkan daftar pemain di layar, digunakan PlayerAdapter, yang akan menampilkan data setiap pemain dalam bentuk list (RecyclerView).
Setiap item pemain memiliki warna latar berbeda berdasarkan posisinya:

🟡 Goalkeeper → Kuning
🔵 Defender / Defence / Centre-Back / Right-Back / Left-Back → Biru
🟢 Midfielder / Midfield / Central Midfield / Attacking Midfield / Defensive Midfield → Hijau
🔴 Forward / Offence / Winger / Centre-Forward → Merah

Ketika pengguna mengetuk salah satu pemain, data dari adapter dikirim ke PlayerDetailFragment, yang akan menampilkan pop-up (BottomSheetDialogFragment) berisi informasi detail pemain seperti:
Nama, Posisi, Tanggal lahir, Kewarganegaraan

Dengan begitu, pengguna bisa langsung melihat detail pemain tanpa harus berpindah halaman.
