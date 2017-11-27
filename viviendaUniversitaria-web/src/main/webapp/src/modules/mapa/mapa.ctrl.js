(function (ng) {
    var mod = ng.module("mapaModule");
    mod.controller('mapaCtrl', ['$scope','$state', '$http',
        function ($scope,$state, $http) {
            $scope.map = {center: {latitude: 38.90, longitude: -77.016 }, zoom: 12 };
            $scope.show = true;
        }
    ]);
})(window.angular);
