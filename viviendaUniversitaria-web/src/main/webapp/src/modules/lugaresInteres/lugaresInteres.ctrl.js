(function (ng) {
    var mod = ng.module("hospedajeModule");
     mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('lugaresInteresCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http,hospedajeContext, $state) {
            
            $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/' + 'lugaresInteres'
                    + '/' + $state.params.idLugarInteres).then(function (response) {
                $scope.idHospedajeActual = $state.params.idHospedaje;
                $scope.lugarInteresActivo = response.data;
            });
        }
    ]);
}
)(angular);


