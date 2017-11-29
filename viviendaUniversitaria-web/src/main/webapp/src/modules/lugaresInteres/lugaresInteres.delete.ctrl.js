(function (ng) {
    var mod = ng.module("hospedajeModule");
    mod.constant("hospedajeContext", "api/hospedajes");
    mod.controller('lugaresInteresDeleteCtrl', ['$scope', '$http', 'hospedajeContext', '$state',
        function ($scope, $http, hospedajeContext, $state) {
            swal({
                title: 'Eliminar lugarInteres',
                text: "¿Esta seguro de que quiere eliminar el lugar de Interes?",
                type: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.value) {
                    $scope.idActual = $state.params.idLugarInteresDelete;
                    $scope.idHospedajeActual = $state.params.idHospedaje;
                    $scope.eliminarLugarInteres = function () {
                        $http.delete(hospedajeContext + '/' + $state.params.idHospedaje + '/lugaresInteres' + $state.params.idLugarInteresDelete).then(function (response)
                        {
                            $state.go("hospedajeEspecifico", {idHospedaje: idHospedajeActual}, {reload: true});
                        });
                    };
                    swal(
                            'Lugar de Interes eliminado!',
                            'El lugar de interes fue eliminado correctamente',
                            'success'
                            );
                }
            });
        }
    ]);
}
)(angular);


