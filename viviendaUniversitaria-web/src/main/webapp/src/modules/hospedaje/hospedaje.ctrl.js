(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('hospedajeCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http,hospedajeContext, $state) {
            
            $http.get(hospedajeContext).then(function (response) {
                $scope.hospedajeList = response.data;
            });
            
            if($state.params.idHospedaje !== undefined) {
                $http.get(hospedajeContext+'/'+$state.params.idHospedaje).then(function (response) { 
                    $scope.hospedajeActivo = response.data;                    
                });
            };
            
            $scope.eliminarRegla = function(idHospedaje,idRegla){
                $http.delete(hospedajeContext+'/'+idHospedaje+'/reglas/'+idRegla).then(function (response) { 
                    $scope.hospedajeActivo = response.data;                    
                });
                $http.get(hospedajeContext+'/'+idHospedaje).then(function (response) { 
                    $scope.hospedajeActivo = response.data;                    
                });
                alert($scope.hospedajeActivo);
            };
        }
    ]);
}
)(angular);