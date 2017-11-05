(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteCtrl', ['$scope', '$http', 'estudiantesContext', '$state',
        function ($scope, $http, estudiantesContext, $state) {
            $http.get(estudiantesContext).then(function (response) {
                $scope.estudiantesRecords = response.data;
            });
            
        }
    ]);
}
)(angular);