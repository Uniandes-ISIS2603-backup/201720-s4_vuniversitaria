(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteNewCtrl', ['$scope', '$http', 'estudiantesContext', '$state', 'origenesContext', '$rootScope',
        function ($scope, $http, estudiantesContext, $state, booksContext, $rootScope) {
            $rootScope.edit = false;
            $scope.createEstudiante = function () {
                $http.post(estudiantesContext, {
                    nombre: $scope.estudianteNombre,
                    cedula: $scope.estudianteCedula
                }).then(function (response) {
                    $state.go('estudiantesList',{estudianteId: response.data.id},{reload: true});
                });
            };
        }
    ]);
}
)(window.angular);