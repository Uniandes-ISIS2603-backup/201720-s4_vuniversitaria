(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturaNewCtrl', ['$scope', '$http', 'facturasContext', '$state', 'hospedajeContext', '$rootScope', 
        function ($scope, $http, facturasContext, $state, hospedajeContext, $rootScope) {
           $rootScope.edit=false;
           $http.get("api/reservas").then(function (response) {
                $scope.reservasRecords = response.data;
            });
           $scope.createFactura = function (idEstudiante, idHospedaje) {
            $http.post(facturasContext + '/' + $state.params.idEstudiante+'/'+$state.params.idHospedaje, {
                id : Math.floor((Math.random() * 100) + 1),
                fecha: $scope.fecha,
                iva: $scope.iva,
                total:$scope.total
            }).then(function (response)
            {
                $state.go("facturasDetail",{facturaId:response.data.id}, {reload:true});
               
            
            });
        };
  
    }
    ]);
}
)(window.angular);