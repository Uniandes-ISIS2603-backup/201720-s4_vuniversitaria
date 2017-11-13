(function (ng) {
    var mod = ng.module("facturaModule");
    mod.constant("facturasContext", "api/facturas");
    mod.controller('facturaDeleteCtrl', ['$scope', '$http', 'facturasContext', '$state',
        function ($scope, $http, facturasContext, $state) {
            var idFactura = $state.params.facturaId;
            $scope.deleteFactura = function () {
                $http.delete(facturasContext + '/' + idFactura, {}).then(function (response) {
                    $state.go('facturasList', {facturaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);


