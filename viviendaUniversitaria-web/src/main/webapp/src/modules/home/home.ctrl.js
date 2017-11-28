(function (ng) {
    var mod = ng.module("homeModule");
    mod.controller('homeCtrl', ['$scope', '$http', '$state', '$rootScope',
        function ($scope, $http, $state, $rootScope) {

            $rootScope.rolActivo = "No registrado";
            $rootScope.idActivo = "";
            $scope.estado = true;

        }
    ]);
}
)(angular);

