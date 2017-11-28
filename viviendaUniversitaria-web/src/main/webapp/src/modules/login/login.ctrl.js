(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("loginContext", "api/validar");
    mod.controller('loginControlador', ['$scope', '$http', 'loginContext', '$state', '$rootScope',
        function ($scope, $http, loginContext, $state, $rootScope) {

            $rootScope.rolActivo = "No registrado";
            $scope.estado = true;

            $scope.valudarUsuario = function (nombreUsuario, contrasenia) {
                $http.get('resources/data/ussers.json').then(function (response) {
                    $scope.estado = false;
                    $rootScope.rolActivo = "No registrado";
                    var data = response.data.admins;
                    for (i = 0; i < data.length; i++) {
                        if (data[i].nombreUsuario === nombreUsuario) {
                            $rootScope.rolActivo = "Administrador";
                            $scope.estado = true;
                        }
                    }
                });
                $http.get(loginContext + '/' + nombreUsuario).then(function (response) {
                    
                    if (!$scope.estado) {
                        var data = response.data;
                        if (data.rol !== 'Error') {
                            if (data.contrasenia === contrasenia) {
                                $rootScope.rolActivo = data.rol;
                                $scope.estado = true;
                            } else {
                                $rootScope.rolActivo = "No registrado";
                                $scope.estado = false;
                            }
                        } else {
                            $rootScope.rolActivo = "No registrado";
                            $scope.estado = false;
                        }
                    }
                });
            };
        }
    ]);
}
)(angular);

