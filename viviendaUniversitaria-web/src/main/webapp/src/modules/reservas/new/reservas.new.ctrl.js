(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");

    mod.controller('reservaNewCtrl', ['$scope', '$http', '$state', 'reservasContext', '$rootScope','estudiantesContext',
        
        function ($scope, $http, $state, reservasContext, $rootScope,estudiantesContext) {
  
                $scope.createReserva = function () {
                $http.post("api/reservas/123/1", {
                    id:Math.floor((Math.random() * 100) + 1),
                    cedulaHuesped: $scope.cedulaHuesped,
                    fechaInicio: $scope.fechaInicio,
                    fechaFin: $scope.fechaFin,
                    idHospedaje: $scope.idHospedaje
                });
            };
             
            
        }
        
    ]);
}
)(window.angular);


