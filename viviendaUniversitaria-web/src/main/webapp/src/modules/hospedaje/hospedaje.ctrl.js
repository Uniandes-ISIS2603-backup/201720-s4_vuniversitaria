(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {

            $scope.filtroActivo = false;
            $scope.listaFiltro = [];

            $scope.filtrarValoracion = function (valoracion) {
                $scope.filtroActivo = true;
                $scope.listaFiltro = [];
                var aux = 0;
                for (var i = 0; i < $scope.hospedajeList.length; i++) {
                    if ($scope.hospedajeList[i].valoracion >= valoracion && $scope.hospedajeList[i].valoracion < (valoracion + 1)) {
                        $scope.listaFiltro[aux] = $scope.hospedajeList[i];
                        aux = aux + 1;
                    }
                }
            };

            $scope.filtrartipo = function (tipo) {
                $scope.filtroActivo = true;
                $scope.listaFiltro = [];
                var aux = 0;
                for (var i = 0; i < $scope.hospedajeList.length; i++) {
                    if ($scope.hospedajeList[i].tipoArrendamiento === tipo) {
                        $scope.listaFiltro[aux] = $scope.hospedajeList[i];
                        aux = aux + 1;
                    }
                }
            };

            $http.get(hospedajeContext).then(function (response) {
                $scope.hospedajeList = response.data;
            });

            var lat = $scope.latitud;
            var long = $scope.longitud;
            if ($state.params.idHospedaje !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje).then(function (response) {
                    $scope.hospedajeActivo = response.data;
                    lat = response.data.ubicacion.latitud;
                    long = response.data.ubicacion.longitud;
                    $scope.map = {
                        center: {latitude: lat, longitude: long},
                        zoom: 17,
                        markers: [
                            {
                                id: 1,
                                latitude: lat,
                                longitude: long,
                                showWindow: false,

                                options: {
                                    icon: "resources/images/icoHosp.png",
                                    animation: 1,
                                    labelAnchor: "22 0",
                                    labelClass: "marker-labels"
                                }
                            }]
                    };
                    $scope.show = true;
                });
            }
            ;

            if ($state.params.idHospedaje !== undefined && $state.params.idRegla !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/reglas/' + $state.params.idRegla).then(function (response) {
                    $scope.regla = response.data.regla;
                });
            }
            ;
            if ($state.params.idServicio !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/servicios/' + $state.params.idServicio).then(function (response) {
                    $scope.servicioActivo = response.data;
                });
            }
            ;

            if ($state.params.idCalificacion !== undefined) {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + '/calificaciones/' + $state.params.idCalificacion).then(function (response) {
                    $scope.calificacionActivo = response.data;
                });
            }
            ;
            $scope.darLugares = function () {
                $http.get(hospedajeContext + '/' + $state.params.idHospedaje + 'lugaresInteres'
                        ).then(function (response) {
                    $scope.lugares = response.data;
                });
            };
            $scope.eliminarRegla = function (idHospedaje, idRegla) {
                swal({
                    title: 'Eliminar regla',
                    text: "¿Esta seguro de que quiere eliminar la regla?",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.value) {
                        $http.delete(hospedajeContext + '/' + idHospedaje + '/reglas/' + idRegla).then(function (response) {
                            $http.get(hospedajeContext + '/' + $state.params.idHospedaje).then(function (response) {
                                $scope.hospedajeActivo = response.data;
                            });
                            $state.reload();
                        });
                        swal(
                                'Regla eliminada!',
                                'La regla fue eliminada correctamente',
                                'success'
                                );
                    }
                });
            };
            $scope.crearRegla = function () {
                $http.post(hospedajeContext + '/' + $state.params.idHospedaje + '/reglas', {
                    regla: $scope.regla
                }).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };

            $scope.actualizarServicio = function (idHospedaje, idServicio)
            {
                if ($scope.costo === undefined)
                {
                    $scope.costo = $scope.servicioActivo.costo;
                }
                $http.put(hospedajeContext + '/' + idHospedaje + '/servicios/' + idServicio, {
                    descripcion: $scope.descripcion,
                    costo: $scope.costo
                }).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.actualServicioId = $state.params.idServicio;
            $scope.eliminarServicio = function (idServicio)
            {
                swal({
                    title: 'Eliminar servicio',
                    text: "¿Esta seguro de que quiere eliminar el servicio?",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Yes, delete it!'
                }).then((result) => {
                    if (result.value) {
                        $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/servicios/' + idServicio
                                ).then(function (response) {
                            $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                            $state.reload();
                        });
                        swal(
                                'Servicio eliminado!',
                                'El servicio fue eliminado correctamente',
                                'success'
                                );
                    }
                });

            };
            $scope.crearServicio = function () {
                $http.post(hospedajeContext + '/' + $state.params.idHospedaje + '/servicios', {
                    id: 9,
                    descripcion: $scope.descripcion,
                    costo: $scope.costos
                }).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };

            $scope.actualCalificacionId = $state.params.idCalificacion;
            $scope.eliminarCalificacion = function ()
            {

                $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/calificaciones/' + $state.params.idCalificacion
                        ).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
            $scope.crearCalificacion = function () {
                $http.post(hospedajeContext + '/' + $state.params.idHospedaje + '/calificaciones', {
                    id: 200,
                    valoracion: $scope.valoracion,
                    comentario: $scope.comentario,
                    fecha: $scope.fecha
                }).then(function (response) {
                    $state.go('hospedajeEspecifico', {idHospedaje: $state.params.idHospedaje});
                });
            };
        }
    ]);
}
)(angular);