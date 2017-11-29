(function (ng) {
    var mod = ng.module("arrendadorModule");
    mod.constant("arrendadoresContext", "api/arrendadores");
    mod.controller('arrendadorNewCtrl', ['$scope', '$http', 'arrendadoresContext', '$state', 'hospedajeContext', '$rootScope',
        function ($scope, $http, arrendadoresContext, $state, hospedajeContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createArrendador = function () {
                $http.post(arrendadoresContext, {
                    id: $scope.arrendadorId,
                    nombre: $scope.arrendadorName,
                    ruta: $scope.arrendadorRutaImagen
                }).then(function (response) {
                    $state.go('arrendadoresList', {arrendadorId: response.data.id}, {reload: true});
                });
            };

            $scope.createArrendador = function () {
                var r = false;
                $http.get('resources/data/ussers.json').then(function (response) {
                    var data = response.data.admins;
                    var i = 0;
                    for (i = 0; i < data.length; i++) {
                        if (data[i].nombreUsuario === $scope.arrendadorNombreUsuario) {
                            r = true;
                        }
                    }
                    $http.get('api/validar' + '/' + $scope.arrendadorNombreUsuario).then(function (response) {
                        if (!r) {
                            var data = response.data;
                            if (data.rol === 'Error') {
                                r = false;
                            } else {
                                r = true;
                            }
                        }
                        if ($scope.arrendadorContrasenia1 !== $scope.arrendadorContrasenia2) {
                            $scope.validEstado = 1;
                        } else if (r) {
                            $scope.validEstado = 2;
                        } else {
                            $scope.validEstado = 0;
                            $http.post(arrendadoresContext, {
                                id: $scope.arrendadorId,
                                nombre: $scope.arrendadorName,
                                ruta: $scope.arrendadorRutaImagen,
                                contrasenia:$scope.arrendadorContrasenia2,
                                nombreUsuario:$scope.arrendadorNombreUsuario
                            }).then(function (response) {
                                $state.go('home');
                            });
                        }
                    }).then(function (response) {});
                }).then(function (response) {});
            };
        }
    ]);
}
)(window.angular);