(function (ng) {
    var mod = ng.module("reservaModule", ['ui.router']);
    mod.constant("reservasContext", "api/reservas");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/reservas/';

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
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservasCreate', {
                url: '/create',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/reservas.new.html',
                        controller: 'reservaNewCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('reservaDelete', {
                url: '/delete/{reservaId:int}',
                parent: 'reservas',
                param: {
                   reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/reservas.delete.html',
                        controller: 'reservaDeleteCtrl'
                    }
                }
            }).state('reservaUpdate', {
                url: '/update/{reservaId:int}',
                parent: 'reservas',
                param: {
                    reservaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'new/reservas.new.html',
                        controller: 'reservaUpdateCtrl'
                    }
                }
            });            
        }]);
})(window.angular);