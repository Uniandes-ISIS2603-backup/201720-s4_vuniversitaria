(function (ng) {
    var mod = ng.module("lugaresInteresModule");
    mod.constant("lugaresInteresContext", "api/lugaresInteres");
    mod.controller('lugaresInteresCreateCtrl', ['$scope', '$http', 'lugaresInteresContext', '$state',
        function ($scope, $http, lugaresInteresContext, $state) {         
            $http.post(lugaresInteresContext + '/' + $state.params.idUbicacion, {
                descripcion : $scope.descripcion,
                distancia: $scope.distancia,
                rutaImagen: $scope.rutaImagen
            }).then(function (response)
            {
                $state.go("lugarInteresEspecifico",{idLugarInteres:response.data.id}, {reload:true});
                
            });
        }]);
}
)(angular);


