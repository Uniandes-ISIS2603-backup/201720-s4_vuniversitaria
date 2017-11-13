(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenesContext", "api/origenes");
    mod.controller('origenCreateCtrl', ['$scope', '$http', 'estudiantesContext', '$state', 'origenesContext', '$rootScope',
        function ($scope, $http, origenesContext, $state, booksContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createOrigen = function () {
                $http.post(origenesContext, {
                    name: $scope.origenName
                }).then(function (response) {
                    $state.go('origenesList',{origenesId: response.data.id},{reload: true});
                });
            };
        }
    ]);
}
)(window.angular);