(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("ubicacionContext","api/ubicaciones");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadNewCtrl', ['$scope', '$http', 'universidadesContext','$state','ubicacionContext',
        function ($scope, $http, universidadesContext, $state,ubicacionContext ) {
            $scope.createUniversidad = function () {
                $http.post(ubicacionContext,{
                    direccion: $scope.universidadDireccion,
                    altitud: $scope.universidadAltitud,
                    latitud: $scope.universidadLatitud
                }).then(function(response){
                    $scope.ubicacion = response.data;
                }),
                $http.post(universidadesContext, {
                    nombre: $scope.universidadNombre,
                    ubicacion: $scope.ubicacion.id
                }).then(function (response) {
                    //universidad created successfully
                    $state.go('universidadesList', {}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);