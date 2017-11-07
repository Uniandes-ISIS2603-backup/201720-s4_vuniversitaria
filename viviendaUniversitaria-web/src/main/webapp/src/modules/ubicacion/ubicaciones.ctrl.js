(function (ng) {
    var mod = ng.module("ubicacionModule");
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.controller('ubicacionCtrl', ['$scope','$state', '$http','ubicacionesContext',
        function ($scope,$state, $http,ubicacionesContext) {
            $http.get(ubicacionesContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });

            if ($state.params.ubicacionId !== undefined) {
                $http.get(ubicacionesContext + '/' + $state.params.ubicacionId).then(function (response) {
                    $scope.currentUbicacion = response.data;
                });
            }
        }
    ]);
}
)(window.angular);