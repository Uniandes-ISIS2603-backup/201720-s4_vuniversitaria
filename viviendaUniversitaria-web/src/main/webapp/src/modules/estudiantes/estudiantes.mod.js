(function (ng) {
    var mod = ng.module("estudianteModule", ['ui.router']);
    mod.constant("estudiantesContext", "api/estudiantes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/estudiantes/';
            $urlRouterProvider.otherwise("/estudiantesList");

            $stateProvider.state('estudiantes', {
                url: '/estudiantes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'estudiantes.html',
                        controller: 'estudianteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('estudiantesList', {
                url: '/list',
                parent: 'estudiantes',
                views: {
                    'listView': {
                        templateUrl: basePath + 'estudiantes.list.html'
                    }
                }
            }).state('estudianteDetail', {
                url: '/{estudianteId:int}/detail',
                parent: 'estudiantes',
                param: {
                    estudianteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'estudiantes.list.html'
                    },
                    'detailView': {
                        templateUrl: basePath + 'estudiantes.detail.html',
                        controller: 'estudianteCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
        }]);
})(window.angular);