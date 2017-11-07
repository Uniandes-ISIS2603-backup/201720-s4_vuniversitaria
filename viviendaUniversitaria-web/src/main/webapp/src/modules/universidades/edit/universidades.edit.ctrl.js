(function (ng) {
    var mod = ng.module('universidadModule');
    mod.constant('universidadesContext', '/api/universidades');
    mod.constant('ubicacionesContext', '/api/ubicaciones');
    mod.controller('universidadEditCtrl', ['$scope', '$state', '$http', 'universidadesContext', 'ubicacionesContext', 'ubicacionesEditCtrl',
        function ($scope, $state, $http, universidadesContext, ubicacionesContext, ubicacionesEditCtrl) {

            var idUni = $state.params.universidadId;

            if ((idUni !== undefined) && (idUni !== null)) {
                $http.get(universidadesContext + '/' + idUni).then(function (response) {
                    $scope.uniActual = response.data;
                    $scope.ubicacion = response.data.ubicacion.id;
                });
            }
            ;

            $scope.editUniversidad = function () {
                var nombre = $scope.name;
                
                 $http.put(ubicacionesContext + '/' + ubi, {
                            id: ubi,
                            direccion: $scope.direccion,
                            longitud: $scope.longitud,
                            latitud: $scope.latitud
                               
                }),$http.put(universidadesContext + '/' + idUni, {
                    nombre: $scope.name,
                    ubicacion: {
                        id: ubi
                    }
                        }).then(function (response) {
                    $state.go('universidadesList', {}, {reload: true});
                });
            };
        }
    ]);
})(window.angular);