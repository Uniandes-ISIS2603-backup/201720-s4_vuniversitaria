(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("loginContext", "api/validar");
    mod.controller('loginControlador', ['$scope', '$http', 'loginContext', '$state', '$rootScope',
        function ($scope, $http, loginContext, $state, $rootScope) {

            $rootScope.rolActivo = "No registrado";
            $scope.estado = false;

            $scope.valudarUsuario = function (nombreUsuario, contrasenia) {
                $http.get(loginContext + '/' + nombreUsuario).then(function (response) {
                    var data = response.data;
                    alert(data.rol);
                    alert(data.contrasenia);
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
                });
            };
        }
    ]);
}
)(angular);