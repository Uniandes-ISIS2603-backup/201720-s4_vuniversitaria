(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenContext", "api/origenes");

    mod.controller('origenNewCtrl', ['$scope', '$http', '$state', 'origenContext', '$rootScope','estudiantesContext',
        
        function ($scope, $http, $state, origenesContext, $rootScope,estudiantesContext) {
            $scope.origenesId = $state.params.origenesId;
            $http.get(estudiantesContext).then(function (response) {
                $scope.estudiantes = response.data;
            });
            
              $scope.agregarEstudiantes = function(idEstudiante){
                   $http.get(origenesContext + '/' + $state.params.origenesId + '/' + 'estudiantes').then(function (response) {
                     $scope.estudiantesOrigin = response.data;
                      });
                      
                      $http.post(origenesContext+'/'+ $state.params.origenesId +'/'+ 'estudiantes' +'/' + idEstudiante).then(function(response){
                          $state.go('agregarEstudiante',{},{reload: true});
                      });
                      
                    
              };
        }
        
    ]);
}
)(window.angular);