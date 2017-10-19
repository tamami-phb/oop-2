## langkah pengerjaan


1. cek pom.xml
2. buat application.properties
3. buat entity AppUser
4. buat repo AppUserRepo
5. buat service AppUserService
6. buat controller AppController
7. tambahin di pom.xml security (test di browser, harusnya tampilkan login)
8. ubah login dengan kelas config.SecurityConfig (masih statis / inMemory)
9. ubah login dengan data dari db di config.SecurityConfig ditambahkan script SQL dan DataSource
    a. buat view dulu login.html
    b. ubah SecurityConfig, tambahkan configure(HttpSecurity)
    c. buat WebConfig untuk register login.html
    d. buat limiter akses berdasarkan role dengan antMatchers,
       cara coba dengan postman,
       1) get dulu halaman login untuk ambil ambil token csrf
       2) taruh token csrf di header dengan nama variabel X-CSRF-TOKEN
       3) akses ke kondisi yang di tutup, hasil harusnya forbidden
10.buat test-angular1.html, lakukan dengan pelan
    a. test parameter nama (ng-model)
    b. test controller (ng-controller, ng-repeat, dan ng-app terisi)
    c. tambah data dengan ng-click, ubah juga dalam controller-nya
    d. hapus data dengan ng-click, ubah juga dalam controller-nya
11. buat crud-angular.html, lakukan ini perlahan
    a. tampilkan list dari rest
    b. tambahkan tombol delete, pastikan di function gagal saat hapus data tampil di console.log, karna ada masalah
       Csrf
    c. Buat kelas util.CsrfFilter
    d. lengkapi dengan form isian tambahkan tombol "hapus", (form.html) sesuaikan controller angularjs-nya
    e. lengkapi dengan tombol "tambah", lengkapi controller angularjs-nya
    f. lengkapi dengan tombol "ubah", lengkapi juga controller angularjs-nya serta service di backend