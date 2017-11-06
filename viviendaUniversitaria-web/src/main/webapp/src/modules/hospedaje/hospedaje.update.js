(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeUpdateCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            
            if($state.params.idHospedaje !== undefined) {
                $http.get(hospedajeContext+'/'+$state.params.idHospedaje).then(function (response) {    
                    $scope.hospedajeActivo = response.data;
                });
            };
            
            $scope.actualizar = function () {
                $http.put(hospedajeContext+'/'+$state.params.idHospedaje, {
                    tipoArrendamiento: $scope.tipoArrendamiento,
                    descripcion: $scope.descripcion,
                    rutaImagen: $scope.rutaImagen
                }).then(function (response) {
                    $state.go('hospedaje');
                });
            }
        }
    ]);
}
)(angular);