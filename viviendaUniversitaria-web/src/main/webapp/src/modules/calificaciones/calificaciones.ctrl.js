(function (ng) {
    var mod = ng.module("calificacionModule");
    mod.constant("calificacionesContext", "calificaciones");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('calificacionesCtrl', ['$scope', '$http', 'hospedajeContext', '$state', 'calificacionesContext',
        function ($scope, $http, hospedajeContext, $state, calificacionesContext) {
            $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/' + calificacionesContext).then(function (response) {
                $scope.calificacionesRecords = response.data;
            });
        }
    ]);
}
)(window.angular);