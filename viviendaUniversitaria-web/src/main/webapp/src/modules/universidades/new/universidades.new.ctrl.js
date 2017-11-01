(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadNewCtrl', ['$scope', '$http', 'universidadesContext', '$state', 'ubicacionContext', '$rootScope',
        function ($scope, $http, universidadesContext, $state, ubicacionContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createUniversidad = function () {
                $http.post(universidadesContext, {
                    nombre: $scope.universidadNombre,
                    direccion: $scope.universidadDireccion,
                    altitud: $scope.universidadAltitud,
                    latitud: $scope.universidadLatitud
                }).then(function (response) {
                    //universidad created successfully
                    $state.go('universidadesList', {universidadId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);