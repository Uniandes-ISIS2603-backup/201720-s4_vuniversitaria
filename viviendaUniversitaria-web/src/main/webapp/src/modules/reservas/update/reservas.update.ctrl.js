(
        function (ng) {
            var mod = ng.module("reservaModule");
            mod.constant("reservasContext", "api/reservas");
            mod.controller('reservaUpdateCtrl', ['$scope', '$http', 'reservasContext', '$state', 'hospedajeContext', '$rootScope', '$filter',
                function ($scope, $http, reservasContext, $state, hospedajeContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idReserva = $state.params.reservaId;                    

                    //Consulto la reserva a editar.
                    $http.get(reservasContext + '/' + idReserva).then(function (response) {
                        var reserva = response.data;
                        $scope.reservaId = reserva.id;
                        $scope.reservaFechaInicio = reserva.fechaInicio;
                        $scope.reservaFechaFin= reserva.fechaFin;
                        $scope.cedulaHuesped = reserva.cedulaHuesped;
                        $scope.idHospedaje = reserva.idHospedaje;
                    });


                    $scope.createReserva = function () {
                        $http.put(reservasContext + "/" + idReserva, {
                            id: $scope.reservaId,
                            fechaInicio: $scope.reservaFechaInicio,
                            fechaFin: $scope.reservaFechaFin,
                            cedulaHuesped: $scope.cedulaHuesped,
                            idHospedaje:$scope.idHospedaje
                        }).then(function (response) {
                            $state.go('reservasList', {authorId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);


