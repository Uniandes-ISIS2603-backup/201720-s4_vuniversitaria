(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenContext", "api/origenes");
    mod.controller('origenCtrl', ['$scope', '$http', 'origenContext', '$state',
        function ($scope, $http,origenContext, $state) {
            $http.get(origenContext).then(function (response) {
                $scope.origenesRecords = response.data;
            });

            if ($state.params.origenesId !== undefined) {
                $http.get(origenContext + '/' + $state.params.origenesId).then(function (response) {
                    $scope.estudiantesRecords = response.data.estudiantes;
                    $scope.currentOrigen = response.data;
                });
            }
        }
    ]);
}
)(angular);

//onclick="{{$scope.idHospedaje = h.id}}"  
/*
 * 

if($state.params.idHospedaje !== undefined){
                $http.get(hospedajeContext+"/"+$state.params.idHospedaje).then(function (response) {
                $scope.hospedajeActivo = response.data;
            });
            }
 */