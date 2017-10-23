(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteCtrl', ['$scope', '$http', 'estudiantesContext', '$state',
        function ($scope, $http, estudiantesContext, $state) {
            $http.get(estudiantesContext).then(function (response) {
                $scope.estudiantesRecords = response.data;
            });
            
            if ($state.params.estudianteId !== undefined) {
                $http.get(estudiantesContext + '/' + $state.params.estudianteId).then(function (response) {
                    $scope.currentEstudiante = response.data;
                });
            }
        }
    ]);
}
)(angular);