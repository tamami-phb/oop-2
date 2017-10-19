var userApp = angular.module('userApp', []);

userApp.controller('UserController', function($scope) {
    $scope.daftarUser = [
        'tamami',
        'tamu',
        'jack'
    ];

    $scope.tambah = function() {
        var idx = $scope.daftarUser.indexOf($scope.nama);
        if(idx === -1)
            $scope.daftarUser.push($scope.nama);
    };

    $scope.hapus = function(x) {
        var idx = $scope.daftarUser.indexOf(x);
        if(idx > -1)
            $scope.daftarUser.splice(idx, 1);
    };
});

userApp.controller('MainController', function($scope) {
    $scope.title = '';
});

userApp.controller('ApiController', function($http, $scope, $window) {

    $scope.daftarUser = {};

    $scope.updateDaftarUser = function() {
        $http.get('daftar-user').then(sukses, gagal);

        function sukses(response) { // sukses
            //console.log('sukses');
            //console.log(response.data);
            $scope.daftarUser = response.data;
        };

        function gagal(response) { // gagal
            //console.log('gagal');
            console.log(response);
        };
    };

    $scope.hapus = function(user) {
        $http.delete('/hapus/' + user.id).then(sukses, gagal);

        function sukses(response) {
            $scope.updateDaftarUser();
        };

        function gagal(response) {
            console.log(response);
        };
    };

    $scope.ubah = function(user) {
        $window.location.href = 'form?id=' + user.id;
    }

    $scope.updateDaftarUser();
});

userApp.controller('FormController', function($http, $scope, $window, $location) {
    $scope.dataUser = {};
    $scope.status; // true = edit, false = add data

    $scope.simpan = function() {
        if(status) {
            $scope.update();
        } else {
            $scope.tambah();
        }
    }

    $scope.update = function() {
        $http.put('update-user', $scope.dataUser).then(sukses, gagal);

        function sukses(response) {
            $window.location.href = 'crud-angular';
        }

        function gagal(response) {}
    }

    $scope.tambah = function() {
        $http.post('tambah-user', $scope.dataUser).then(sukses, gagal);

        function sukses(response) {
            $window.location.href = 'crud-angular';
        }

        function gagal(response) {}
    }

    $scope.updateId = function() {
        url = $window.location;
        if(url.search) {
            param = url.search.split('?')[1].split('=')[1];
            $scope.status = true;
            $scope.dataUser.id = param;
            $scope.updateById(param);
            alert('param ada : ' + param);
        } else {
            $http.get('get-new-id').then(sukses, gagal);
            $scope.status = false;
        }

        function sukses(response) {
            $scope.dataUser.id = response.data.id;
        }

        function gagal(response) {

        }
    }

    $scope.updateById = function(id) {
        $http.get('/get-user-by-id/' + id).then(sukses, gagal);

        function sukses(response) {
            $scope.dataUser.name = response.data.name;
            $scope.dataUser.age = response.data.age;
            $scope.dataUser.salary = response.data.salary;
        }

        function gagal(response) {
        }
    }

    $scope.updateId();
});