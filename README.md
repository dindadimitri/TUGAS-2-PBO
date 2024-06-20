<h1>Tugas2 Sistem Pembayaran Subscription</h1>
 
<h2>Nama Anggota Kelompok:</h2>
1.  <b>Adinda Chandra Dimitri</b> 	(2305551055)<br>
2.  <b>Putu Aulia Devina Armana</b> 	(2305551056)
 
<h2>Tentang Proyek</h2>
Project ini bertujuan untuk membuat backend API untuk sistem pembayaran pembayaran subscription sederhana yang nantinya memberikan response dengan format JSON. Adapun request method pada API yaitu : <br>
<b>GET</b>: untuk mendapatkan list atau detail data dari entitas. <br>
<b>POST</b>: untuk membuat data entitas baru. <br>
<b>PUT</b>: untuk mengubah data dari entitas. <br>
<b>DELETE</b> : untuk menghapus data dari entitas. <br><br>

Data-data yang digunakan dalam sistem pembayaran subscription sederhana ini disimpan dalam database SQLite. Kemudian API yang telah dibuat akan dilakukan suatu pengujian menggunakan aplikasi Postman.<br>

<h2>Spesifikasi API dalam Sistem Pembayaran Subscription</h2>
<h3>GET</h3>
<b>GET/customers</b> => mendapatkan daftar semua customer<br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/get customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan daftar semua data customer yang ada pada table customers dengan menggunakan method GET dengan pengujian pada Postman.<br><br> 

<b>GET/customers/{id}</b>=> mendapatkan informasi customer<br>
<code>http://localhost:9056/customer/1</code><br>
<a href="url"><img src="img/get customer 1.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari salah satu data customer yang terdapat pada table customer dengan nomor id 1 dengan menggunakan method GET dengan pengujian pada Postman.<br>


<h3>POST</h3>
<b>POST/customers</b>=> untuk menambahkan customer baru<br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/post customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari pengujian method POST di Postman dengan menambahkan data customer baru.<br>

<h3>PUT</h3>
<b>PUT/customers/{id}</b>=> mengubah data customer<br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/put customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari mengubah salah satu data customer dengan menggunakan method PUT dengan pengujian pada Postman.<br>

<h3>DELETE</h3>
<b>DELETE/customer/{id}</b>=> menghapus data baru<br>
<code>localhost:8100/customers</code><br>
<a href="url"><img src="img/delete customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari pengujian method DELETE di Postman dengan menghapus salah satu data customer dengan id 6. 
