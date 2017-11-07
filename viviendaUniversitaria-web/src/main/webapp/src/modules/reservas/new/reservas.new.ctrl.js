(function (ng) {
    var mod = ng.module("reservaModule");
    mod.constant("reservasContext", "api/reservas");

    mod.controller('reservaNewCtrl', ['$scope', '$http', '$state', 'reservasContext', '$rootScope','estudiantesContext',
        
        function ($scope, $http, $state, origenesContext, $rootScope,estudiantesContext) {
            $scope.reservasId = $state.params.reservasId;
            $http.get(estudiantesContext).then(function (response) {
                $scope.estudiantes = response.data;
            });
            $http.get(hospedajesContext).then(function (response) {
                $scope.hospedajes = response.data;
            });
                $scope.createReserva = function (idEstudiante) {
                $http.post(reservasContext+'/'+ idEstudiante +'/'+ 'estudiantes' +'/' +Math.floor((Math.random() * 10) + 1), {
                    id:1,
                    cedulaHuesped: $scope.cedulaHuesped,
                    fechaInicio: $scope.fechaInicio,
                    fechaFin: $scope.fechaFin,
                    idHospedaje: $scope.idHospedaje
                }).then(function (response) {
                    $state.go('reservasList', {reservaId: response.data.id}, {reload: true});
                });
            };
             
            
        }
        
    ]);
}
)(window.angular);


