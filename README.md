<h1>Tugas2 Sistem Pembayaran Subscription</h1>
 
<h2>Nama Anggota Kelompok:</h2>
1.  <b>Adinda Chandra Dimitri</b> 	(2305551055)<br>
2.  <b>Putu Aulia Devina Armana</b> 	(2305551056)
 
<h2>Tentang Proyek</h2>
Project ini bertujuan untuk membuat backend API untuk sistem pembayaran pembayaran subscription sederhana yang nantinya memberikan response dengan format JSON. Adapun request method pada API yaitu : <br>
<b>GET</b>: untuk mendapatkan list atau detail data dari entitas. <br>
<b>POST</b>: untuk membuat data entitas baru. <br>
<b>PUT</b>: untuk mengubah data dari entitas. <br>
<b>DELETE</b> : untuk menghapus data dari entitas. <br>

Data-data yang digunakan dalam sistem pembayaran subscription sederhana ini disimpan dalam database SQLite. Kemudian API yang telah dibuat akan dilakukan suatu pengujian menggunakan aplikasi Postman.<br>

<h2>Spesifikasi API dalam Sistem Pembayaran Subscription</h2>
<h3>GET</h3>
<b>GET/customers</b> => mendapatkan daftar semua pelanggan<br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/get customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan daftar semua data customer yang ada pada table customers dengan menggunakan method GET dengan pengujian pada Postman.<br><br> 

<b>GET/customers/{id}</b>=> mendapatkan informasi pelanggan dan alamatnya<br>
<code>http://localhost:9056/customer/1</code><br>
<a href="url"><img src="img/get customer 1.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari salah satu data customer yang terdapat pada table customer dengan nomor id 1 dengan menggunakan method GET dengan pengujian pada Postman.<br>

<b>GET/customers/{id}/cards</b>=> mendapatkan daftar kartu kredit/debit milik pelanggan<br>
<code>http://localhost:9056/customers_cards/1</code><br>
<a href="url"><img src="img/get customer_cards.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari data kartu kredit/debit salah satu pelanggan dengan menggunakan method GET dan melakukan pengujian di Postman.<br>

<b>GET/customers/{id}/subscriptions</b>=> mendapatkan daftar semua subscriptions milik pelanggan<br>
<code>http://localhost:9056/customer_subscriptions/1</code><br>
<a href="url"><img src="img/get customer subscriptions .jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari data subscriptions milik pelanggan nomor id 1 dengan method GET dan melakukan pengujian pada Postman.<br>

<b>GET/subscriptions</b>=> mendapatkan daftar semua data subscriptions<br>
<code>http://localhost:9056/subscriptions</code><br>
<a href="url"><img src="img/get subscriptions.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan daftar semua data subscription yang ada pada table subscription dengan menggunakan method GET dengan pengujian pada Postman.<br> 

<b>GET/subscriptions?sort_by=current_term_end&sort_type=desc</b>=> mendapatkan daftar semua data subscriptions diurutkan berdasarkan current_term_end secara descending<br>
<code>http://localhost:9056/subscriptions_current_term_end</code><br>
<a href="url"><img src="img/get subscriptions descending.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari daftar semua data subscription diurutlan berdasarkan current_term_end secara descending dengan method GET dan dilakukan pengujian pada Postman.<br>

<b>GET/subscriptions/{id}</b>=> mendapatkan informasi subscription, customer, subscription_items, item<br>
<code>http://localhost:9056/subscriptions/1</code><br>
<a href="url"><img src="img/get subscriptions id.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari salah satu data subscription yang terdapat pada table subscrio=ption dengan nomor id 1 dengan menggunakan method GET dengan pengujian pada Postman.<br>

<b>GET/items</b>=> mendapatkan daftar semua produk<br>
<code>http://localhost:9056/items</code><br>
<a href="url"><img src="img/get items.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan daftar semua data produk yang ada pada table items dengan menggunakan method GET dengan pengujian pada Postman.<br> 

<b>GET/items?is_active=true</b>=> mendapatkan daftar semua produk yg memiliki status aktif<br>
<code>http://localhost:9056/items_is_active?is_active=true</code><br>
<a href="url"><img src="img/get item active.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari daftar semua produk yang memiliki status aktif menggunakan method GET dan melakukan pengujian pada Postman.<br>

<b>GET/items/{id}</b>=> mendapatkan informasi produk<br>
<code>http://localhost:9056/items/1</code><br>
<a href="url"><img src="img/get item id.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari salah satu informasi produk dalam table items pada nomor id 1 dengan menggunakan method GET dengan pengujian pada Postman.<br>

<h3>POST</h3>
<b>POST/customers</b>=> buat pelanggan baru<br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/post customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari pengujian method POST di Postman dengan menambahkan data customer baru.<br><br>

<b>POST/subscriptions</b>=> buat subscription baru beserta dengan id customer, shipping address, card, dan item yg dibeli<br>
<code>http://localhost:9056/subscriptions</code><br>
<a href="url"><img src="img/post subscription.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan berhasil dari membuat subscriptions baru dengan method POST dan melakukan pengujian di Postman.<br> 

<b>POST/items</b>=> buat item baru<br>
<code>http://localhost:9056/items</code><br>
<a href="url"><img src="img/post items.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan berhasil dari membuat item baru dengan method POST dan melakukan pengujian di Postman.<br> 

<h3>PUT</h3>
<b>PUT/customers/{id}</b><br>
<code>http://localhost:9056/customer</code><br>
<a href="url"><img src="img/put customer.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari mengubah salah satu data customer dengan menggunakan method PUT dengan pengujian pada Postman.<br><br>

<b>PUT/items/{id} </b><br>
<code>http://localhost:9056/items/6</code><br>
<a href="url"><img src="img/put items id.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari mengupdate data pada table item pada nomor id enam yg sudah berhasil dengan method PUT dan melakukan pengujian di Postman.<br>

<h3>DELETE</h3>
<b>DELETE/items/{id}</b>=> mengapus data items<br>
<code>localhost:9056/items/6</code><br>
<a href="url"><img src="img/delete item id.jpg" height="300" width="600" style="border-radius:10%"></a><br>
Gambar diatas merupakan tampilan dari pengujian method DELETE di Postman dengan menghapus salah satu data items dengan id 6. 
