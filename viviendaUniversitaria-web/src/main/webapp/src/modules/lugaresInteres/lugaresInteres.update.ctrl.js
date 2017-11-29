(function (ng) {
    var mod = ng.module("hospedajeModule");
     mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('lugaresInteresUpdateCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            
                $http.get(hospedajeContext+'/' + $state.params.idHospedaje + '/lugaresInteres/'+$state.params.idLugarInteresUpdate).then(function (response) {
                    $scope.lugarInteresActivo = response.data;
                     $scope.idHospedajeActual = $state.params.idHospedaje;
                });
            $scope.actualizarLugar = function(){          
            $http.put(hospedajeContext + '/' + $state.params.idHospedaje + '/lugaresInteres/'+ $state.params.idLugarInteresUpdate, {
                descripcion : $scope.descripcion,
                name: $scope.name,
                rutaImagen: $scope.rutaImagen,
                ubicacion : $scope.lugarInteresActivo.ubicacion
            }).then(function (response)
            {
                $state.go("hospedajeEspecifico",{idHospedaje:$state.params.idHospedaje}, {reload:true});
                
            });
        };
        }]);
}
)(angular);


