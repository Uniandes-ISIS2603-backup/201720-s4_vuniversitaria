(function (ng) {
    var mod = ng.module("ubicacionModule", ['ui.router']);
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ubicaciones/';
            var basePathUniversidad = 'src/modules/universidades/';
            $urlRouterProvider.otherwise("/ubicaciones");
            $stateProvider.state('ubicaciones', {
                url: '/ubicaciones',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'ubicaciones.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionDetail', {
                url: '/{ubicacionesId:int}/detail',
                parent: 'ubicaciones',
                param: {
                    ubicacionesId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePathUniversidad + 'ubicaciones.detail.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
