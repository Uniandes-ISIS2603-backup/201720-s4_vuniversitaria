(function (ng) {
    var mod = ng.module("arrendadorModule");
    mod.constant("arrendadoresContext", "api/arrendadores");
    mod.controller('arrendadorDeleteCtrl', ['$scope', '$http', 'arrendadoresContext', '$state',
        function ($scope, $http, arrendadoresContext, $state) {
            var idArrendador = $state.params.arrendadorId;
            $scope.deleteArrendador = function () {
                $http.delete(arrendadoresContext + '/' + idArrendador, {}).then(function (response) {
                    $state.go('arrendadoresList', {arrendadorId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);