(function (ng) {
    var mod = ng.module("universidadModule", ['ui.router','uiGmapgoogle-maps']);
    mod.constant("universidadesContext", "api/universidades");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/universidades/';
            $urlRouterProvider.otherwise("/universidadesList");

            $stateProvider.state('universidades', {
                url: '/universidades',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'universidades.html',
                        controller: 'universidadCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('universidadesList', {
                url: '/list',
                parent: 'universidades',
                views: {
                    'listView': {
                        templateUrl: basePath + 'universidades.list.html'
                    }
                }
            }).state('universidadDetail', {
                url: '/{universidadId:int}/detail',
                parent: 'universidades',
                param: {
                    universidadId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'universidades.detail.html',
                        controller: 'universidadCtrl',
                        controllerAs: 'ctrl'
                    },
                    'mapaView': {
                        templateUrl: 'src/modules/mapa/mapa.html',
                        controller: 'mapaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('universidadCreate', {
                url: '/create',
                parent: 'universidades',
                views: {
                    'detailView': {
                        templateUrl: basePath + '/new/universidades.new.html',
                        controller: 'universidadNewCtrl'
                    }
                }
            }).state('universidadEdit', {
                url: '/edit/{universidadId:int}',
                parent: 'universidades',
                param: {
                    universidadId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/' + '/edit/universidades.edit.html',
                        controller: 'universidadEditCtrl',
                        'controllerAs': 'editctrl'
                    }
                }
            }).state('universidadDelete', {
                url: '/delete/{universidadId:int}',
                parent: 'universidades',
                param: {
                    universidadId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/universidades.delete.html',
                        controller: 'universidadesDeleteCtrl',
                        controllerAs: 'deleteCtrl'
                    }

                }
            });
        }]);
})(window.angular);