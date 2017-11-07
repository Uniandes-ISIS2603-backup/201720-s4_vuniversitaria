(function (ng) {
    var mod = ng.module('universidadModule');
    mod.constant('universidadesContext', '/api/universidades');
    mod.constant('ubicacionesContext', '/api/ubicaciones');
    mod.controller('universidadEditCtrl', ['$scope', '$state', '$http', 'universidadesContext', 'ubicacionesContext',
        function ($scope, $state, $http, universidadesContext, ubicacionesContext) {

            var idUni = $state.params.universidadId;
            var ubi =$scope.ubi;
            if ((idUni !== undefined) && (idUni !== null)) {
                $http.get(universidadesContext + '/' + idUni).then(function (response) {
                    $scope.uniActual = response.data;
                    ubi =  response.data.ubicacion.id;
                });  
                   
                    $scope.editUniversidad = function () { 
                    $http.put(ubicacionesContext + '/' + ubi, {
                            id: ubi,
                            direccion: $scope.direccion,
                            longitud: $scope.longitud,
                            latitud: $scope.latitud
                     });
                    $http.put(universidadesContext + '/' + idUni, {
                    name: $scope.name,
                    ubicacion: {
                        id: ubi
                    }
                        }).then(function (response) {
                    $state.go('universidadesList', {}, {reload: true});
                });
            }
            };
        }
    ]);
})(window.angular);