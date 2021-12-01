Proyek: Program untuk merekap data pemesanan kaos

Latar belakang: Bantu orang tua urus rekapan pemesanan kaos untuk kegiatan gereja

Fungsi/alur program:
	-Menerima input nama, alamat, dan nomor telfon
	-Menghitung jumlah yang butuh dibayar
	-Menyimpan data dalam file
	
Komponen:
	-Elemen GUI untuk menginput data
	-Metode untuk menangkap data input
	-Metode-metode untuk menghitung perhitungan yang diperlukan
	-Metode untuk menulis data di suatu file eksternal

Breakdown alur program:


main()<br/>| UTS()
<br/>| | gridPlace(int x, int y, double weight): GridBagConstraints
<br/>| | writer(String x)
<br/>| | | textFieldInput(int order): String
<br/>| | | | sizeFieldInput(): String
<br/>| | | | shipTotalPrice(): int
<br/>| | | | | redTotal(): int
<br/>| | | | | blueTotal(): int
<br/>| | | | | regionShipPrice(): int
<br/>| | | | shirtPrice(): int
<br/>| | | | | redTotal(): int
<br/>| | | | | blueTotal(): int
<br/>| | | | totalPayment(): int
<br/>| | | | | shipTotalPrice(): int
<br/>| | | | |shirtPrice();

Deskripsi program

Program terdiri dari 12 subprogram dan 1 constructor
Urutan dijalankannya program dan fungsi

1. main(String[] args)
	Memanggil constructor untuk menjalankan program

2. UTS()
Constructor untuk membangun gui. Fungsi gui adalah menampilkan text box untuk input data dari user dan juga menyediakan tombol untuk menyimpan data.
Tombol akan menggunakan ActionListener untuk menerima input tekan. Apabila sudah ditekan, maka akan menjalankan sebuah inner method untuk menjalankan method actionPerformed(ActionEvent e). Method tersebut jalan saat ada ActionEvent.
Method akan memanggil method writer() dengan parameter method textFieldInput(++order).
Setelah selesai, method resetTF() akan dipanggil
3.  gridPlace(int x, int y, double weight): GridBagConstraints
Method yang berfungsi sebagai parameter diletakkannya komponen-komponen GUI pada layar. GUI Java diletakkan pada layar sebagai tabel. 
Parameter berfungsi untuk menentukan lokasi pada sumbu x dan y, dan juga menentukan lebar komponen. 
Method akan mengembalikan nilai dalam bentuk GridBagConstraints
4. writer(String x)
Method yang berfungsi untuk menuliskan parameter x dengan jenis String ke sebuah file bernama ouput.csv
5. textFieldInput(int order): String
Method yang berfungsi untuk menjadikan semua input dan perhitungan-perhitungan yang dilakukan ke dalam bentuk String yang dipisahkan dengan koma agar bisa dibaca sebagai CSV. Parameter int order adalah untuk menambah angka urutan
6. sizeFieldInput(): String
Method untuk menjadikan semua input ukuran menjadi bentuk String yang dipisahkan  tanda koma.
Method akan mengebalikan nilai dalam bentuk String
7. shipTotalPrice(): int
Meghitung harga pengiriman total berdasarkan return dari metode regionShipPrice(). Biaya pengiriman hanya akan bertambah untuk tiap 3 baju, oleh karena itu dilakukan loop utuk menaikkan harga tiap pertambahan 3.
Method akan mengembalikan return dalam bentuk int.
8. redTotal(): int DAN blueTotal():int
Method menghitung jumlah baju untuk masing-masing warna.
Method akan mengembalikan nilai dalam bentuk int
9. regionShipPrice(): int
Method untuk menentukan harga dasar untuk pengiriman tiap wilayah. Method menerima input dari ComboBox, lalu memasukkannya dalam switch case yang memuat harga.
Method akan mengembalikan nilai dalam bentuk int.
10. totalPayment(): int
Method untuk menghitung total yang butuh dibayarkan oleh user.
Method akan mengembalikan nilai dalam bentuk int
