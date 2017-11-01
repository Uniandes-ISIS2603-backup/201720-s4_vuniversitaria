(function (ng) {
    var mod = ng.module("origenModule", ['ui.router']);
    mod.constant("origenesContext", "api/origenes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/origenes/';
            var basePathEstudiantes = 'src/modules/estudiantes/';
            $urlRouterProvider.otherwise("/origenesList");
            $stateProvider.state('origenes', {
                url: '/origenes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'origenes.html',
                        controller: 'origenCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('origenesList', {
                url: '/list',
                parent: 'origenes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'origenes.list.html'
                    }
                }
            }).state('origenDetail', {
                url: '/{origenesId:int}/detail',
                parent: 'origenes',
                param: {
                    origenesId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePathEstudiantes + 'estudiantes.list.html',
                        controller: 'origenCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'origenes.detail.html',
                        controller: 'origenCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
