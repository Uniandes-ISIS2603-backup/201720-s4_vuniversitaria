(
        function (ng) {
            var mod = ng.module("arrendadorModule");
            mod.constant("arrendadoresContext", "api/arrendadores");
            mod.controller('arrendadorUpdateCtrl', ['$scope', '$http', 'arrendadoresContext', '$state', 'hospedajeContext', '$rootScope', '$filter',
                function ($scope, $http, arrendadoresContext, $state, hospedajeContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idArrendador = $state.params.arrendadorId;                    

                    //Consulto el arrendador a editar.
                    $http.get(arrendadoresContext + '/' + idArrendador).then(function (response) {
                        var arrendador = response.data;
                        $scope.arrendadorId = arrendador.id;
                        $scope.arrendadorName = arrendador.nombre;
                        $scope.arrendadorRutaImagen = arrendador.ruta;
                    });


                    $scope.updateArrendador = function () {
                        $http.put(arrendadoresContext + "/" + idArrendador, {
                            id: $scope.arrendadorId,
                            nombre: $scope.arrendadorName,
                            ruta: $scope.arrendadorRutaImagen
                        }).then(function (response) {
                            $state.go('arrendadoresList', {authorId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);