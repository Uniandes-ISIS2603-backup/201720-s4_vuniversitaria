(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadCtrl', ['$scope', '$http', 'universidadesContext', '$state',
        function ($scope, $http, universidadesContext, $state) {
            var idUni = $state.params.universidadId;
            $http.get(universidadesContext).then(function (response) {
                $scope.universidadesRecords = response.data;
            });

            if ((idUni !== undefined) && (idUni !== null)) {
                $http.get(universidadesContext + '/' + idUni).then(function (response) {
                    $scope.currentUniversidad = response.data;
                });
            }
        }
    ]);
}
)(window.angular);