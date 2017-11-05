(function (ng) {
    var mod = ng.module("estudianteModule");
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.controller('estudianteUpdateCtrl', ['$scope', '$http', 'estudiantesContext', '$state',
        function ($scope, $http, estudiantesContext, $state) {
            
            if($state.params.idEstudiante !== undefined) {
                $http.get(estudiantesContext+'/'+$state.params.idEstudiante).then(function (response) {    
                    $scope.estudianteActivo = response.data;
                    console.log($scope.estudianteActivo);
                });
            };
            
            $scope.actualizar = function () {
                $http.put(estudiantesContext+'/'+$state.params.idEstudiante, {
                    nombre: $scope.estudianteActivo.nombre
                }).then(function (response) {
                    $state.go('estudiantesList',{idEstudiante: response.data.id},{reload:true});
                });
            };
        }
    ]);
}
)(angular);