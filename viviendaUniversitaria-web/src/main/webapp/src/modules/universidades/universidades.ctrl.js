(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadCtrl', ['$scope', '$http', 'universidadesContext', '$state',
        function ($scope, $http, universidadesContext, $state) {
            $http.get(universidadesContext).then(function (response) {
                $scope.universidadRecords = response.data;
            });
            
            if ($state.params.universidadId !== undefined) {
                $http.get(universidadesContext + '/' + $state.params.universidadId).then(function (response) {
                    $scope.currentUniversidad = response.data;
                });
            }
        }
    ]);
}
)(angular);