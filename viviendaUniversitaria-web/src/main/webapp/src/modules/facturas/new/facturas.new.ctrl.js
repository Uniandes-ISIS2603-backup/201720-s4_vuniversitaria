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
            $http.post(facturasContext + '/'+$scope.reservaSeleccionada.estudiante.id+'/'+$scope.reservaSeleccionada.hospedaje.id, {
                id : Math.floor((Math.random() * 1000) + 1),
                fecha: $scope.fecha,
                iva: $scope.iva,
                total:$scope.total
            });
        };
                $scope.calcularTotal= function(){
                    var inicio=$scope.reservaSeleccionada.fechaInicio;
                    var fin=$scope.reservaSeleccionada.fechaFin;
                    var inicioDef=inicio.replace("-","");
                    var finDef=fin.replace("-","");
                    return (finDef-inicioDef)*19532;
                   
                };
    }
    ]);
}
)(window.angular);