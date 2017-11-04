(
        function (ng) {
            var mod = ng.module("arrendadorModule");
            mod.constant("arrendadoresContext", "api/arrendadores");
            mod.constant("hospedajeContext", "api/hospedajes");
            mod.controller('arrendadorUpdateCtrl', ['$scope', '$http', 'arrendadoresContext', '$state', 'hospedajeContext', '$rootScope', '$filter',
                function ($scope, $http, arrendadoresContext, $state, hospedajeContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idArrendador = $state.params.arrendadorId;

                    // Este arreglo guardara los ids de los hospedajes asociados y por asociar al arrendador.
                    var idsHospedaje = [];

                    // Este arreglo mostrará los hospedajes que el arrendador ya tiene asociado.
                    $scope.allHospedajesShow = [];

                    //Consulto el arrendador a editar.
                    $http.get(arrendadoresContext + '/' + idArrendador).then(function (response) {
                        var arrendador = response.data;
                        $scope.arrendadorId = arrendador.id;
                        $scope.arrendadorName = arrendador.nombre;
                        $scope.arrendadorRutaImagen = arrendador.ruta;
                        $scope.allHospedajesArrendador = arrendador.hospedajes;
                        $scope.mergeHospedajes($scope.allHospedajesArrendador);
                    });

                    /*
                     * Agrega los ids de los hospedajes que ya tiene el arrendador asociado.
                     */
                    $scope.mergeHospedajes = function (hospedajes) {
                        for (var item in hospedajes) {
                            idsHospedaje.push("" + hospedajes[item].id);
                        }
                        $scope.getHospedajes(hospedajes);
                    };

                    /*
                     * Esta función obtiene los hospedajes asociados
                     */
                    $scope.getHospedajes = function (hospedajes) {
                        $http.get(hospedajeContext).then(function (response) {
                            $scope.allHospedajes = response.data;
                            $scope.hospedajesArrendador = hospedajes;

                            var filteredHospedajes = $scope.allHospedajes.filter(function (allHospedajes) {
                                return $scope.hospedajesArrendador.filter(function (hospedajesArrendador) {
                                    return hospedajesArrendador.id == allHospedajes.id;
                                }).length == 0
                            });

                            $scope.allHospedajesShow = filteredHospedajes;

                        });
                    };
                    
                    $scope.allowDrop = function (ev) {
                        ev.preventDefault();
                    };

                    $scope.drag = function (ev) {
                        ev.dataTransfer.setData("text", ev.target.id);
                    };

                    $scope.dropAdd = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        idsHospedaje.push("" + data);
                    };

                    $scope.dropDelete = function (ev) {
                        ev.preventDefault();
                        var data = ev.dataTransfer.getData("text");
                        ev.target.appendChild(document.getElementById(data));
                        var index = idsHospedaje.indexOf(data);
                        if (index > -1) {
                            idsHospedaje.splice(index, 1);
                        }
                    };

                    $scope.createArrendador = function () {
                        $scope.newHospedajes();
                        $http.put(arrendadoresContext + "/" + idArrendador, {
                            id: $scope.arrendadorId,
                            nombre: $scope.arrendadorName,
                            ruta: $scope.arrendadorRutaImagen
                        }).then(function (response) {
                            if (idsHospedaje.length >= 0) {
                                $http.put(arrendadoresContext + "/" + response.data.id + "/hospedajes", $scope.allHospedajes).then(function (response) {
                                });
                            }
                            //Author created successfully
                            $state.go('arrendadoresList', {authorId: response.data.id}, {reload: true});
                        });
                    };

                    $scope.newHospedajes = function () {
                        $scope.allHospedajesArrendador = [];
                        for (var ite in idsHospedaje) {
                            for (var all in $scope.allHospedajes) {
                                if ($scope.allHospedajes[all].id === parseInt(idsHospedaje[ite])) {
                                    $scope.allHospedajesArrendador.push($scope.allHospedajes[all]);
                                }
                            }
                        }
                    };
                }
            ]);
        }
)(window.angular);