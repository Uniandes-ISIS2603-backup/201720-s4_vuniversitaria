(function (ng) {
    var mod = ng.module("arrendadorModule", ['ui.router']);
    mod.constant("arrendadoresContext", "api/arrendadores");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/arrendadores/';

            $stateProvider.state('arrendadores', {
                url: '/arrendadores',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'arrendadores.html',
                        controller: 'arrendadorCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('arrendadoresList', {
                url: '/list',
                parent: 'arrendadores',
                views: {
                    'listView': {
                        templateUrl: basePath + 'arrendadores.list.html'
                    }
                }
            }).state('arrendadorDetail', {
                url: '/{arrendadorId:int}/detail',
                parent: 'arrendadores',
                param: {
                    arrendadorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'arrendadores.detail.html',
                        controller: 'arrendadorCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('arrendadoresCreate', {
                url: '/create',
                parent: 'arrendadores',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/arrendadores.new.html',
                        controller: 'arrendadorNewCtrl'
                    }
                }
            }).state('arrendadorUpdate', {
                url: '/update/{arrendadorId:int}',
                parent: 'arrendadores',
                param: {
                    arrendadorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/update/arrendadores.update.html',
                        controller: 'arrendadorUpdateCtrl'
                    }
                }
            }).state('arrendadorDelete', {
                url: '/delete/{arrendadorId:int}',
                parent: 'arrendadores',
                param: {
                    arrendadorId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/arrendador.delete.html',
                        controller: 'arrendadorDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);