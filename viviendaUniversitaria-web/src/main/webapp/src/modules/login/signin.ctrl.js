(function (ng) {
    var mod = ng.module("loginModule");
    mod.controller('singinCtrl', ['$scope', '$http', 'loginContext', '$state', '$rootScope',
        function ($scope, $http, loginContext, $state, $rootScope) {

            $scope.cerrarSesion = function () {
                $rootScope.rolActivo = "No registrado";
                $rootScope.idActivo = "";
                $scope.estado = true;
            };

            swal({
                    title: 'Registrate',
                    text: "Como quieres iniciar sesion",
                    type: 'info',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#3085d6',
                    confirmButtonText: 'Arrendador',
                    cancelButtonText: 'Estudiante',
                    confirmButtonClass: 'btn btn-success',
                    cancelButtonClass: 'btn btn-success',
                    buttonsStyling: false
                }).then((result) => {
                    if (result.value) {
                        $state.go('arrendadoresCreate');
                    } else if (result.dismiss === 'cancel') {
                        $state.go('estudiantesCreate');
                    } else {
                        $state.go('home');
                    }
                });


        }
    ]);
}
)(angular);

