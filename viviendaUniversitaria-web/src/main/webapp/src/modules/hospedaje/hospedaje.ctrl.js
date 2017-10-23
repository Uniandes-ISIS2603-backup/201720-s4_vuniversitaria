(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http,hospedajeContext, $state) {
            $scope.hospedajeList = [];
            $http.get(hospedajeContext).then(function (response) {
                $scope.hospedajeList = response.data;
            });
        }
    ]);
}
)(angular);