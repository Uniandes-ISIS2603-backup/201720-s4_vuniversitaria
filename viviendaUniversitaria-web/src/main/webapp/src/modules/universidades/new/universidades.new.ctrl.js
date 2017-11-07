(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("ubicacionContext","api/ubicaciones");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadNewCtrl', ['$scope', '$http', 'universidadesContext','$state','ubicacionContext',
        function ($scope, $http, universidadesContext, $state,ubicacionContext ) {
            $scope.createUniversidad = function () {
                
                var ubi = $scope.ubi;
                $http.post(ubicacionContext,{
                    direccion: $scope.universidadDireccion,
                    longitud: $scope.universidadLongitud,
                    latitud: $scope.universidadLatitud
                }).then(function(response){
                    ubi = response.data.id;
                });
                $http.post(universidadesContext, {
                    name: $scope.universidadNombre,
                    ubicacion: ubi
                }).then(function (response) {
                    //universidad created successfully
                    $state.go('universidadesList', {}, {reload: true});
                }); 
            };
        }
    ]);
}
)(window.angular);