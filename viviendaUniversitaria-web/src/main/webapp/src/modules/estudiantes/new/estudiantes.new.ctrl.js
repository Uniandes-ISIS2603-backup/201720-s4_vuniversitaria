(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteNewCtrl', ['$scope', '$http', 'estudiantesContext', '$state', 'origenesContext', '$rootScope',
        function ($scope, $http, estudiantesContext, $state, booksContext, $rootScope) {
            $rootScope.edit = false;
            $scope.validEstado = 0;

            $scope.createEstudiante = function () {
                var r = false;
                $http.get('resources/data/ussers.json').then(function (response) {
                    var data = response.data.admins;
                    var i = 0;
                    for (i = 0; i < data.length; i++) {
                        if (data[i].nombreUsuario === $scope.estudianteUsuario) {
                            r = true;
                        }
                    }
                    $http.get('api/validar' + '/' + $scope.estudianteUsuario).then(function (response) {
                        if (!r) {
                            var data = response.data;
                            if (data.rol === 'Error') {
                                r = false;
                            } else {
                                r = true;
                            }
                        }
                        if ($scope.estudianteContrasenia1 !== $scope.estudianteContrasenia2) {
                            $scope.validEstado = 1;
                        } else if (r) {
                            $scope.validEstado = 2;
                        } else {
                            $scope.validEstado = 0;
                            $http.post(estudiantesContext, {
                                nombre: $scope.estudianteNombre,
                                cedula: $scope.estudianteCedula,
                                rutaImagen: $scope.estudianteRutaImagen,
                                nombreUsuario: $scope.estudianteUsuario,
                                contrasenia: $scope.estudianteContrasenia1,
                                nombreOrigen: $scope.nombreOrigen
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