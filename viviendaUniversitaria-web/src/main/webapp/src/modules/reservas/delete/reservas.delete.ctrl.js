(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");
    mod.controller('reservaDeleteCtrl', ['$scope', '$http', 'reservasContext', '$state',
        function ($scope, $http, reservasContext, $state) {
            var idReserva = $state.params.reservaId;
            $scope.deleteReserva = function () {
                $http.delete(reservasContext + '/' + idReserva, {}).then(function (response) {
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

