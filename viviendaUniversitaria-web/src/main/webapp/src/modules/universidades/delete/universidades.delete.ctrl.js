(function(ng){
    var mod = ng.module('universidadModule');
    mod.constant('universidadesContext', 'api/universidades');
    mod.controller('universidadesDeleteCtrl', ['$scope', '$state','$http' ,'universidadesContext',
        function ($scope, $state, $http, universidadesContext) {
            var idUni = $state.params.universidadId;
            $scope.deleteUniversidad = function () {
                $http.delete(universidadesContext + '/' + idUni, {}).then(function (response) {
                    $state.go('universidadesList', {}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);