(function (ng) {
    var mod = ng.module("mapaModule");
    mod.constant("mapaContext", "api/ubicaciones");
    mod.controller('mapaCtrl', ['$scope','$state', '$http','mapaContext',
        function ($scope,$state, $http,mapaContext) {
            $scope.map = {center: {latitude:4.706454, longitude: -74.074172 }, zoom: 12,  markers: [
        {
          id: 1,
          latitude: 45,
          longitude: -74,
          showWindow: false,
          options: {
            animation: 1,
            labelContent: 'Markers id 1',
            labelAnchor: "22 0",
            labelClass: "marker-labels"
          }
        }],
            };
            $scope.show = true;
        }
    ]);
})(window.angular);
