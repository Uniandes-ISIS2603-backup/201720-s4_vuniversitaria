(function (ng) {
    var mod = ng.module("hospedajeModule");
     mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('lugaresInteresCreateCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {   
            $scope.idHospedajeActual = $state.params.idHospedaje;
            $scope.create = function(){
            $http.post(hospedajeContext + '/' + $state.params.idHospedaje + '/'+ 'lugaresInteres', {
                descripcion : $scope.descripcion,
                distancia: $scope.distancia,
                rutaImagen: $scope.rutaImagen
            }).then(function (response)
            {
                $state.go("lugarInteresEspecifico",{idLugarInteres:response.data.id}, {reload:true});  
            });
        };
        }]);
}
)(angular);


