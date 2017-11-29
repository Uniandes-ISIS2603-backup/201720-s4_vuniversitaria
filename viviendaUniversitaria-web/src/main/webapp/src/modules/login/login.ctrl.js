(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("loginContext", "api/validar");
    mod.controller('loginControlador', ['$scope', '$http', 'loginContext', '$state', '$rootScope',
        function ($scope, $http, loginContext, $state, $rootScope) {

            $rootScope.rolActivo = "No registrado";
            $rootScope.idActivo = "";
            $scope.estado = true;

            $scope.valudarUsuario = function (nombreUsuario, contrasenia) {
                $scope.estado = false;
                $rootScope.idActivo = "";
                $rootScope.rolActivo = "No registrado";
                $http.get('resources/data/ussers.json').then(function (response) {
                    var data = response.data.admins;
                    for (i = 0; i < data.length; i++) {
                        if (data[i].nombreUsuario === nombreUsuario) {
                            if (data[i].contrasenia === contrasenia) {
                                $rootScope.rolActivo = "Administrador";
                                $rootScope.idActivo = "";
                                $scope.estado = true;
                                $state.go('home');
                            }
                        }
                    }
                    $http.get(loginContext + '/' + nombreUsuario).then(function (response) {
                        if (!$scope.estado) {
                            var data = response.data;
                            if (data.rol !== 'Error') {
                                if (data.contrasenia === contrasenia) {
                                    $rootScope.rolActivo = data.rol;
                                    $rootScope.idActivo = data.id;
                                    $scope.estado = true;
                                    $state.go('home');
                                } else {
                                    $rootScope.rolActivo = "No registrado";
                                    $scope.estado = false;
                                }
                            } else {
                                $rootScope.rolActivo = "No registrado";
                                $scope.estado = false;
                            }
                        }
                    }).then(function (response) {});     
                }).then(function (response) {});
            };
        }
    ]);
}
)(angular);

