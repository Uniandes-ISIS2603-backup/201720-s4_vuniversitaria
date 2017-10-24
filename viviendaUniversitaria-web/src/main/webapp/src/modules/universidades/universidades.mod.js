(function (ng) {
    var mod = ng.module("universidadModule", ['ui.router']);
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
                    'listView': {
                        templateUrl: basePath + 'universidades.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'universidades.detail.html',
                        controller: 'universidadCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
        }]);
})(window.angular);
