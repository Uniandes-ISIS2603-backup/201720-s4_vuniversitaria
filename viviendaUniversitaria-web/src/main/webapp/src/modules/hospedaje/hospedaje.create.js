(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeCreateCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            this.registrar = function () {
                $http.post(hospedajeContext, {
                    tipoArrendamiento: $scope.tipoArrendamiento,
                    descripcion: $scope.descripcion
                }).then(function (response) {
                    $scope.hospedajeActivo = response.data;
                    $state.go('hospedaje');
                });
            }
        }
    ]);
}
)(angular);