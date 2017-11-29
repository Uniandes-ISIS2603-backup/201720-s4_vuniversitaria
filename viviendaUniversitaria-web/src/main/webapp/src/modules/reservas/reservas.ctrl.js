(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservaCtrl', ['$scope', '$http', 'reservasContext', '$state',
        function ($scope, $http, reservasContext, $state) {
            $http.get(reservasContext).then(function (response) {
                $scope.reservasRecords = response.data;
           });
            if (($state.params.reservaId !== undefined) && ($state.params.reservaId !== null)) {
                $http.get(reservasContext + '/' + $state.params.reservaId).then(function (response) {
                    $scope.currentReserva = response.data;
                });
            }
            $scope.orderByMe = function(x) {
            $scope.myOrderBy = x;
        }
       $scope.filterByMe = function(x) {
            $scope.myFilter = x;
            
        }
        $scope.criteriaMatch = function( criteria ) {
    return function( item ) {
         var ano=item.fechaFin.slice(0,4);
         var mes=item.fechaFin.slice(5,7);
         var fecha=""+ano+""+mes;
         var dia=item.fechaFin.slice(8,10);
        if(criteria == "Y"){
           return fecha>=201711;
        }
        else {
            return !(ano>=201711);
        }
    };
  };
        }
    ]);
}
)(angular);

