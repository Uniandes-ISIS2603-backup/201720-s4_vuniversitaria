(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.constant("origenContext", "api/origenes");
    mod.controller('estudianteCtrl', ['$scope', '$http', 'estudiantesContext', 'origenContext', '$state',
        function ($scope, $http, estudiantesContext, origenContext, $state) {
            $http.get(estudiantesContext).then(function (response) {
                $scope.estudiantesRecords = response.data;
            });
            $http.get(origenContext).then(function (response) {
                $scope.origenesRecords = response.data;
            });
            
            if (($scope.idActivo !== undefined) && ($scope.idActivo !== null)) {
                $http.get(estudiantesContext + '/' + $scope.idActivo).then(function (response) {
                    $scope.currentEstudiante = response.data;
                });}
        
            
            $scope.crearFiltro = function (origenId) {
                $http.get(origenContext + '/' + origenId + "/estudiantes").then(function (response) {
                    $scope.estudiantesRecords = response.data;
                });
            };
        }
    ]);
}
)(angular);