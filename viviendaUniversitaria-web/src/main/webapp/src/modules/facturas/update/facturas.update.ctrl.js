(
        function (ng) {
            var mod = ng.module("facturaModule");
            mod.constant("facturasContext", "api/facturas");
            mod.controller('facturaUpdateCtrl', ['$scope', '$http', 'facturasContext', '$state', 'hospedajeContext', '$rootScope', '$filter',
                function ($scope, $http, facturasContext, $state, hospedajeContext, $rootScope, $filter) {
                    $rootScope.edit = true;

                    var idFactura = $state.params.facturaId;                    

                    //Consulto la factura a editar.
                    $http.get(facturasContext + '/' + idFactura).then(function (response) {
                        var factura = response.data;
                        $scope.facturaId = factura.id;
                        $scope.facturaFecha = factura.fecha;
                        $scope.facturaIva = factura.iva;
                        $scope.facturaTotal = factura.total;
                    });


                    $scope.createFactura = function () {
                        $http.put(facturasContext + "/" + idFactura, {
                            id: $scope.facturaId,
                            fecha: $scope.facturaFecha,
                            iva: $scope.facturaIva,
                            total:$scope.facturaTotal
                        }).then(function (response) {
                            $state.go('facturasList', {authorId: response.data.id}, {reload: true});
                        });
                    };

                }
            ]);
        }
)(window.angular);

