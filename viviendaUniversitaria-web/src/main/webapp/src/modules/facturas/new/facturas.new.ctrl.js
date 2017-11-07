(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturaNewCtrl', ['$scope', '$http', 'facturasContext', '$state', 'hospedajeContext', '$rootScope', 
        function ($scope, $http, facturasContext, $state, hospedajeContext, $rootScope) {
           $rootScope.edit=false;
           $http.get("api/reservas").then(function (response) {
                $scope.reservasRecords = response.data;
            });
           $scope.createFactura = function () {
            $http.post(facturasContext + '/123/1', {
                id : Math.floor((Math.random() * 100) + 1),
                fecha: $scope.fecha,
                iva: $scope.iva,
                total:$scope.total
            });
        };
  
    }
    ]);
}
)(window.angular);