(function (ng) {
    var mod = ng.module("lugaresInteresModule");
    mod.constant("lugaresInteresContext", "api/lugaresInteres");
    mod.controller('lugaresInteresUpdateCtrl', ['$scope', '$http', 'lugaresInteresContext', '$state',
        function ($scope, $http, lugaresInteresContext, $state) {
            
                $http.get(lugaresInteresContext+'/'+$state.params.idLugarInteresUpdate).then(function (response) {
                    $scope.lugarInteresActivo = response.data;
                });
            $scope.actualizarLugar = function(){          
            $http.put(lugaresInteresContext + '/' + $state.params.idLugarInteresUpdate, {
                descripcion : $scope.descripcion,
                distancia: $scope.distancia,
                rutaImagen: $scope.rutaImagen,
                ubicacion : $scope.lugarInteresActivo.ubicacion
            }).then(function (response)
            {
                $state.go("lugarInteresEspecifico",{idLugarInteres:response.data.id}, {reload:true});
                
            });
        };
        }]);
}
)(angular);


