(function(ng){
    var mod = ng.module ('universidadModule');
    mod.constant('universidadesContext','/api/universidades');
    mod.controller('universidadEditCtrl',['$scope','$state','$http','universidadesContext',
        function($scope,$state,$http,universidadesContext){
            
            var idUni = $state.params.universidadId;
            
            if(idUni !== undefined) {
                $http.get(universidadesContext+'/'+ idUni,{}).then(function (response) {    
                    $scope.universidadActual = response.data;
                });
            };
            $scope.editUniversidad = function(){
                $http.put(universidadesContext +'/'+ idUni,{
                    
                    nombre: $scope.nombre,
                    direccion: $scope.direccion,
                    latitud: $scope.latitud,
                    altitud:$scope.altitud
                    
                }).then(function(response){
                    $state.go('universidadesList',{},{reload:true});
                });
            }; 
        }
    ]);
})(window.angular);