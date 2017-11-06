(function (ng) {
    var mod = ng.module("lugaresInteresModule");
    mod.constant("lugaresInteresContext", "api/lugaresInteres");
    mod.controller('lugaresInteresDeleteCtrl', ['$scope', '$http', 'lugaresInteresContext', '$state',
        function ($scope, $http, lugaresInteresContext, $state) {
            $scope.idActual = $state.params.idLugarInteresDelete;
            $scope.eliminarLugarInteres = function (){
            $http.delete(lugaresInteresContext + '/' + $state.params.idLugarInteresDelete).then(function (response)
            {
                $state.go("lugaresInteres");
            });
        };
        }
    ]);
}
)(angular);


