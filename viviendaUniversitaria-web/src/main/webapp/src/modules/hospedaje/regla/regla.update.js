(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('reglaUpdate', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            $scope.reglaActiva = {};
            
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/reglas/'+$state.params.idRegla).then(function (response) {
                    $scope.reglaActiva =  response.data;
                });
            
            $scope.updateRegla = function () {
                $http.put(hospedajeContext + '/' + $state.params.idHospedaje + '/reglas/'+$state.params.idRegla, {
                    regla:$scope.regla
                }).then(function (response) {
                    alert(response.data.regla);
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
        }
    ]);
}
)(angular);

            
            