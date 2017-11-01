(function (ng) {
    var mod = ng.module("ubicacionModule");
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.controller('ubicacionCtrl', ['$scope', '$http', 'ubicacionesContext',
        function ($scope, $http,ubicacionesContext) {
            $http.get(ubicacionesContext).then(function (response) {
                $scope.ubicacionesRecords = response.data;
            });

//            if ($state.params.ubicacionesId !== undefined) {
//                $http.get(ubicacionesContext + '/' + $state.params.ubicacionesId).then(function (response) {
//                    $scope.universidadRecords = response.data.universidades;
//                    $scope.currentUbicacion = response.data;
//                });
//            }
        }
    ]);
}
)(angular);