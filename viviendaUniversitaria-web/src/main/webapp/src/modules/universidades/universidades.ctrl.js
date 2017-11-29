(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadCtrl', ['$scope', '$http', 'universidadesContext', '$state',
        function ($scope, $http, universidadesContext, $state) {
            var idUni = $state.params.universidadId;
            $http.get(universidadesContext).then(function (response) {
                $scope.universidadesRecords = response.data;
            });

            var lat = $scope.latitud;
            var long = $scope.longitud;
            if ((idUni !== undefined) && (idUni !== null)) {

                $http.get(universidadesContext + '/' + idUni).then(function (response) {
                    $scope.currentUniversidad = response.data;
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
                                    animation: 1,
                                    labelAnchor: "22 0",
                                    labelClass: "marker-labels"
                                }
                            }],
                    };
                    $scope.show = true;
                });
            }


        }
    ]);
}
)(window.angular);