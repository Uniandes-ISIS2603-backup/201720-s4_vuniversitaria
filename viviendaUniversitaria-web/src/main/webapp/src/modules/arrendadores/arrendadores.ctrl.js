(function (ng) {
    var mod = ng.module("arrendadorModule");
    mod.constant("arrendadoresContext", "api/arrendadores");
    mod.controller('arrendadorCtrl', ['$scope', '$http', 'arrendadoresContext', '$state',
        function ($scope, $http, arrendadoresContext, $state) {
            $http.get(arrendadoresContext).then(function (response) {
                $scope.arrendadoresRecords = response.data;
            });

            if (($state.params.arrendadorId !== undefined) && ($state.params.arrendadorId !== null)) {
                $http.get(arrendadoresContext + '/' + $state.params.arrendadorId).then(function (response) {
                    $scope.currentArrendador = response.data;
                });
            }
        }
    ]);
}
)(window.angular);