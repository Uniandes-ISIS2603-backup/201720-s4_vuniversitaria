(function (ng) {
    var mod = ng.module("origenModule");
    mod.constant("origenContext", "api/origenes");
    mod.controller('origenUpdateCtrl', ['$scope', '$http', 'origenContext', '$state',
        function ($scope, $http,origenContext, $state){
        
            if($state.params.origenId !== undefined) {
                $http.get(origenContext+'/'+$state.params.origenId).then(function (response) {    
                    $scope.origenActivo = response.data;
                });
                
                $http.get(origenContext + '/' + $state.params.origenId + '/' + 'estudiantes').then(function (response) {
                    $scope.estudiantesOrigin = response.data;
                });
                
            };
            
            $scope.actualizar = function () {
                $http.put(origenContext+'/'+$state.params.origenId, {
                    name: $scope.origenActivo.nombre
                    ,estudiantes: $scope.estudiantesOrigin
                }).then(function (response) {
                    $state.go('origenesList',{origenesId: response.data.id},{reload:true});
                });
            };
            
        }
    ]);
}
)(angular);