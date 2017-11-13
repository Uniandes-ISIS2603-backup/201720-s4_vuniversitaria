(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenesContext", "api/origenes");
    mod.controller('origenCreateCtrl', ['$scope', '$http', '$state', 'origenesContext', '$rootScope',
        function ($scope, $http, origenesContext, $state,$rootScope) {
            $rootScope.edit = false;
            $scope.createOrigen = function () {
                $http.post(origenesContext, {
                    name: $scope.origenName
                }).then(function (response) {
                    $state.go('origenesList',{origenId: response.data.id},{reload: true});
                });
            };
        }
    ]);
}
)(window.angular);
