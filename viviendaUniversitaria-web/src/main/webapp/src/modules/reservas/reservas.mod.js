(function (ng) {
    var mod = ng.module("reservaModule", ['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';
            $urlRouterProvider.otherwise("/reservasList");

            $stateProvider.state('reservas', {
                url: '/reservas',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservasList', {
                url: '/list',
                parent: 'reservas',
                views: {
                    'listView': {
                        templateUrl: basePath + 'reservas.list.html'
                    }
                }
            }).state('reservasDetail', {
                url: '/{reservaId:int}/detail',
                parent: 'reservas',
                param: {
                    facturaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('createReserva', {
                url: '/create',
                parent: 'reservas',
                param: {
                    facturaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.new.ctrl.html',
                        controller: 'reservaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });            
        }]);
})(window.angular);