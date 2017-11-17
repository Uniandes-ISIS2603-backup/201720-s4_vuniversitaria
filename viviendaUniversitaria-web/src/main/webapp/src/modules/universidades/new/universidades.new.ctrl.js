(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("ubicacionContext","api/ubicaciones");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadNewCtrl', ['$scope', '$http', 'universidadesContext','$state','ubicacionContext',
        function ($scope, $http, universidadesContext, $state,ubicacionContext ) {
             
            var ubi = $scope.ubi;
             
            $scope.createUniversidad = function () {
                console.log("Entre en el metodo");
                $http.post(ubicacionContext,{
                    direccion: $scope.universidadDireccion,
                    longitud: $scope.universidadLongitud,
                    latitud: $scope.universidadLatitud
                    
                }),
               $http.post(universidadesContext, {
                    name: $scope.universidadNombre,
                    ubicacion:{
                    id: ubi
                    }
                    
                }) .then(function (response) {
                    //universidad created successfully
            console.log("Sali exitosamente");
                    $state.go('universidadesList', {}, {reload: true});
                });  
            };
        }
    ]);
}
)(window.angular);