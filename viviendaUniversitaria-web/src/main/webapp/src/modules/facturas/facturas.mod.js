(function (ng) {
    var mod = ng.module("facturaModule", ['ui.router']);
    mod.constant("facturasContext", "api/facturas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/facturas/';

            $stateProvider.state('facturas', {
                url: '/facturas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'facturas.html',
                        controller: 'facturaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('facturasList', {
                url: '/list',
                parent: 'facturas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'facturas.list.html'
                    }
                }
            }).state('facturasDetail', {
                url: '/{facturaId:int}/detail',
                parent: 'facturas',
                param: {
                    facturaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'facturas.detail.html',
                        controller: 'facturaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('facturasCreate', {
                url: '/create',
                parent: 'facturas',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/facturas.new.html',
                        controller: 'facturaNewCtrl'
                    }
                }
            }).state('facturaDelete', {
                url: '/delete/{facturaId:int}',
                parent: 'facturas',
                param: {
                   facturaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/facturas.delete.html',
                        controller: 'facturaDeleteCtrl'
                    }
                }
            }).state('facturaUpdate', {
                url: '/update/{facturaId:int}',
                parent: 'facturas',
                param: {
                    facturaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/facturas.new.html',
                        controller: 'facturaUpdateCtrl'
                    }
                }
            });            
        }]);
})(window.angular);

