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

<h2>Spesifikasi API dalam Sistem Pembayaran Subscription</h2>
<h3>GET</h3>
-GET/customers => daftar semua pelanggan<br>
<code>http://localhost:9056/customer</code><br><br>
<a href="url"><img src="https://https://github.com/dindadimitri/TUGAS-2-PBO/blob/main/img/get%20customer.jpg" height="500" width="300" style="border-radius:10%"></a>


-GET/customers/{id}=> informasi pelanggan dan alamatnya<br>
<code>http://localhost:9056/customer/1</code><br><br>
<a href="url"><img src="![img/get customer 1.jpg](https://github.com/dindadimitri/TUGAS-2-PBO/blob/main/img/get%20customer%201.jpg)" height="auto" width="300" style="border-radius:10%"></a>


<h3>POST</h3>
-POST/customers=> buat pelanggan baru<br>
<code>http://localhost:9056/customer</code><br><br>
<a href="url"><img src="https://github.com/dindadimitri/TUGAS-2-PBO/blob/main/img/post%20customer.jpg" height="auto" width="300" style="border-radius:10%"></a>


<h3>PUT</h3>
-PUT/customers/{id}<br>
<code>localhost:8100/customers</code><br><br>
<a href="url"><img src="url gambar" height="auto" width="300" style="border-radius:10%"></a>

-PUT/customers/{id}/shipping_addresses<br>
<code>localhost:8100/customers</code><br><br>
<a href="url"><img src="url gambar" height="auto" width="300" style="border-radius:10%"></a>

-PUT/item/{id}<br><br>
<code>localhost:8100/customers</code><br><br>
<a href="url"><img src="url gambar" height="auto" width="300" style="border-radius:10%"></a>

<h3>DELETE</h3>
-DELETE/customer/{id}=> menghapus data baru<br>
<code>localhost:8100/customers</code><br><br>
<a href="url"><img src="https://github.com/dindadimitri/TUGAS-2-PBO/blob/main/img/delete%20customer.jpg" height="auto" width="300" style="border-radius:10%"></a>
