(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturaCtrl', ['$scope', '$http', 'facturasContext', '$state',
        function ($scope, $http, facturasContext, $state) {
            $http.get(facturasContext).then(function (response) {
                $scope.facturasRecords = response.data;
           });
            if (($state.params.facturaId !== undefined) && ($state.params.facturaId !== null)) {
                $http.get(facturasContext + '/' + $state.params.facturaId).then(function (response) {
                    $scope.listaDetallesReserva = response.data.detalleReserva;
                    $scope.listaDetallesServicio = response.data.detalleServicio;
                    $scope.currentFactura = response.data;
                });
            }

            
        }
        
    ]);
}
)(angular);
