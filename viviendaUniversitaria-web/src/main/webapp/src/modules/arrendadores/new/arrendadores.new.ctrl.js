(function (ng) {
    var mod = ng.module("arrendadorModule");
    mod.constant("arrendadoresContext", "api/arrendadores");
    mod.controller('arrendadorNewCtrl', ['$scope', '$http', 'arrendadoresContext', '$state', 'hospedajeContext', '$rootScope',
        function ($scope, $http, arrendadoresContext, $state, hospedajeContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createArrendador = function () {
                $http.post(arrendadoresContext, {
                    id: $scope.arrendadorId,
                    nombre: $scope.arrendadorName,
                    ruta: $scope.arrendadorRutaImagen
                }).then(function (response) {
                    $state.go('arrendadoresList', {arrendadorId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);