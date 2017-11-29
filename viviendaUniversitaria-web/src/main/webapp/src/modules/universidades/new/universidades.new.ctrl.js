(function (ng) {
    var mod = ng.module("universidadModule");
    mod.constant("ubicacionContext", "api/ubicaciones");
    mod.constant("universidadesContext", "api/universidades");
    mod.controller('universidadNewCtrl', ['$log', '$scope', '$http', 'universidadesContext', '$state', 'ubicacionContext',
        function ($log, $scope, $http, universidadesContext, $state, ubicacionContext) {

            var lat = 0;
            var lon = 0;
            angular.extend($scope, {
                map: {
                    center: {
                        latitude: 4.711245, 
                        longitude: -74.072797
                    },
                    zoom: 11,
                    markers: [],
                    events: {
                        click: function (map, eventName, originalEventArgs) {
                            var e = originalEventArgs[0];
                            lat = e.latLng.lat();
                            localStorage.setItem("lat",e.latLng.lat());
                            lon = e.latLng.lng();
                            localStorage.setItem("lon",e.latLng.lng());
                            var marker = {
                                id: Date.now(),
                                coords: {
                                    latitude: lat,
                                    longitude: lon
                                }
                            };
                            $scope.map.markers.push(marker);
                            $scope.$apply();
                            $scope.map.markers = [];
                            
                        }
                    }
                }
            });
            $scope.show = true;
            $scope.createUniversidad = function () {
                $http.post(ubicacionContext, {
                    direccion: $scope.universidadDireccion,
                    longitud: localStorage.getItem("lon"),
                    latitud: localStorage.getItem("lat")
                }).then(function (response) {
                    $http.post(universidadesContext, {
                        name: $scope.universidadNombre,
                        imagen: $scope.universidadImagen,
                        ubicacion: {
                            id: response.data.id
                        }
                    }).then(function(response){
                         $state.go('universidadesList', {}, {reload: true});
                    });
                   
                });
            };
        }]);
}
)(window.angular);