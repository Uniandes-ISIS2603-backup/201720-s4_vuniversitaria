(function (ng) {
    var mod = ng.module("lugaresInteresModule");
    mod.constant("lugaresInteresContext", "api/lugaresInteres");
    mod.controller('lugaresInteresCtrl', ['$scope', '$http', 'lugaresInteresContext', '$state',
        function ($scope, $http,lugaresInteresContext, $state) {
            $http.get(lugaresInteresContext).then(function (response) {
                $scope.lugaresInteresList = response.data;
            });
            if($state.params.idLugarInteres !== undefined) {
                $http.get(lugaresInteresContext+'/'+$state.params.idLugarInteres).then(function (response) {
                    $scope.lugarInteresActivo = response.data;
                });
            }; 
        }
    ]);
}
)(angular);


