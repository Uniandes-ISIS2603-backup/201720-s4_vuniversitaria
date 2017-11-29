(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteNewCtrl', ['$scope', '$http', 'estudiantesContext', '$state', 'origenesContext', '$rootScope',
        function ($scope, $http, estudiantesContext, $state, booksContext, $rootScope) {
            $rootScope.edit = false;
            $scope.validEstado = 0;
            
            $scope.createEstudiante = function () {
                $http.get(estudiantesContext);
                
                
                if($scope.estudianteContrasenia1 !== $scope.estudianteContrasenia2) {
                    $scope.validEstado = 0;
                }
            };
            
            
            $scope.createEstudiante2 = function () {
                $http.post(estudiantesContext, {
                    nombre: $scope.estudianteNombre,
                    cedula: $scope.estudianteCedula,
                    rutaImagen: $scope.estudianteRutaImagen,
                    nombreUsuario: $scope.estudianteUsuario,
                    contrasenia: $scope.estudianteContrasenia1
                }).then(function (response) {
                    $state.go('estudiantesList',{estudianteId: response.data.id},{reload: true});
                });
            };
            
           $scope.valudarUsuario = function (nombreUsuario) {
                $scope.estado = false;
                $http.get('resources/data/ussers.json').then(function (response) {

                    var data = response.data.admins;
                    var i = 0;
                    for (i = 0; i < data.length; i++) {
                        if (data[i].nombreUsuario === nombreUsuario) {
                                $scope.estado = true;
                        }
                    }
                });
                $http.get('api/validar' + '/' + nombreUsuario).then(function (response) {

                    if (!$scope.estado) {
                        var data = response.data;
                        if (data.rol === 'Error') {
                           $scope.estado = false;
                        } else {
                            $scope.estado = false;
                        }
                    }
                });
            };
            
            
            
        }
    ]);
}
)(window.angular);