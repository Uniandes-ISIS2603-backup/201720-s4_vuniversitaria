(function (ng) {
    var mod = ng.module("mapaModule");
    mod.constant("mapaContext", "api/ubicaciones");
    mod.controller('mapaCtrl', ['$scope','$state', '$http','mapaContext',
        function ($scope,$state, $http,mapaContext) {
            $scope.map = {center: {latitude: 38.90, longitude: -77.016 }, zoom: 12 };
            $scope.show = true;
        }
    ]);
})(window.angular);
