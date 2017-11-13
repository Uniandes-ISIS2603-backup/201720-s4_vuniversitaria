(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenesContext", "api/origenes");
    mod.controller('origenDeleteCtrl', ['$scope', '$http', 'origenesContext', '$state',
        function ($scope, $http, origenesContext, $state) {
            var idOrigen = $state.params.origenId;
            $scope.deleteOrigen = function () {
                $http.delete(origenesContext + '/' + idOrigen, {}).then(function (response) {
                    $state.go('origenesList',{origenId: response.data.id},{reload: true});
                });
            };
        }
    ]);
}
)(window.angular);