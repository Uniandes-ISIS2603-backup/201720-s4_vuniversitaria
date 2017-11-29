(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('logoutControlador', ['$scope', '$http', 'loginContext', '$state', '$rootScope',
        function ($scope, $http, loginContext, $state, $rootScope) {

            $scope.cerrarSesion = function () {
                $rootScope.rolActivo = "No registrado";
                $rootScope.idActivo = "";
                $scope.estado = true;
            };

            swal({
                title: '¿Está seguro que desea cerrar sesion?',
                type: 'info',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Cerrar sesion'
            }).then((result) => {
                if (result.value) {
                    $scope.cerrarSesion();
                }
                $state.go('home');
            });


        }
    ]);
}
)(angular);

