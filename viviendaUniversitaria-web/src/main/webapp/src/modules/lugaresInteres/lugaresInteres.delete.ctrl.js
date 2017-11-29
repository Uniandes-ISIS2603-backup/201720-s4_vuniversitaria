(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");   
    mod.controller('lugaresInteresDeleteCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            $scope.idActual = $state.params.idLugarInteresDelete;
            $scope.idHospedajeActual = $state.params.idHospedaje;
            $scope.eliminarLugarInteres = function (){
            $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/lugaresInteres'+ $state.params.idLugarInteresDelete).then(function (response)
            {
                $state.go("hospedajeEspecifico",{idHospedaje:idHospedajeActual},{reload:true});
            });
        };
        }
    ]);
}
)(angular);


