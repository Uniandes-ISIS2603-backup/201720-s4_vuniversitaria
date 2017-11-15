(function (ng) {
    var mod = ng.module("ubicacionModule", ['ui.router']);
    mod.constant("ubicacionesContext", "api/ubicaciones");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/ubicacion/';
            $urlRouterProvider.otherwise("/ubicacionesList");
           
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
            }).state('ubicacionesList',{
                url: '/list',
                parent: 'ubicaciones',
                views:{
                    'listView':{
                        templateUrl: basePath + 'ubicaciones.list.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('ubicacionDetail', {
                url: '/{ubicacionId:int}/detail',
                parent: 'ubicaciones',
                param: {
                    ubicacionId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'ubicaciones.detail.html',
                        controller: 'ubicacionCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
